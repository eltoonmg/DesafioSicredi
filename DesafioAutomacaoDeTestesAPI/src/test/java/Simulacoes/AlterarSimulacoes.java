package Simulacoes;

import Utils.BaseTest;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class AlterarSimulacoes extends BaseTest {

    @Test
    public void alterarSimulacao(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", NOME_ALTERADO);
        params.put("cpf", CPF_ALTERADO);
        params.put("email", EMAIL);
        params.put("valor", VALOR_SIMULACAO);
        params.put("parcelas", PARCELAS);
        params.put("seguro", SEGURO);
        given()
                .contentType("application/json")
                .body(params)
                .pathParam("cpf", CPF)
        .when()
                .put("http://localhost:8080/api/v1/simulacoes/{cpf}")
        .then()
                .statusCode(200)
                .log().all()
                .body("nome", is(NOME_ALTERADO))
                .body("cpf", is(CPF_ALTERADO))
        ;
    }

    @Test
    public void alterarSimulacaoCamposVazios(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", "");
        params.put("email", "");
        params.put("valor", "");
        params.put("parcelas", "");
        params.put("seguro", "");

        given()
                .contentType("application/json")
                .body(params)
                .pathParam("cpf", CPF)
        .when()
                .put("http://localhost:8080/api/v1/simulacoes/{cpf}")
        .then()
                .statusCode(400)
                .log().all()
//                .body("erros.nome", is("Nome não pode ser vazio"))
//                .body("erros.cpf", is("CPF não pode ser vazio"))
//                .body("erros.valor", is("Valor não pode ser vazio"))
                .body("erros.email", is("E-mail deve ser um e-mail válido"))
//                .body("erros.parcelas", is("Parcelas não pode ser vazio"))
        ;
    }

    @Test
    public void alterarSimulacaoCPFInvalido(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", NOME_ALTERADO);
        params.put("cpf", CPF_ALTERADO);
        params.put("email", EMAIL);
        params.put("valor", VALOR_SIMULACAO);
        params.put("parcelas", PARCELAS);
        params.put("seguro", SEGURO);

        given()
                .contentType("application/json")
                .body(params)
                .pathParam("cpf", CPF_INVALIDO)
        .when()
                .put("http://localhost:8080/api/v1/simulacoes/{cpf}")
        .then()
                .statusCode(404)
                .log().all()
                .body("mensagem", is("CPF " + CPF_INVALIDO + " não encontrado"))
        ;
    }
}
