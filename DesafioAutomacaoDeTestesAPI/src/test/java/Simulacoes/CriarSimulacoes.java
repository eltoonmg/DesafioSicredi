package Simulacoes;

import Utils.BaseTest;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CriarSimulacoes extends BaseTest {

    private Integer ID_SIMULACAO;

    @Test
    public void criarSimulacao(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", NOME);
        params.put("cpf", CPF);
        params.put("email", EMAIL);
        params.put("valor", VALOR_SIMULACAO);
        params.put("parcelas", PARCELAS);
        params.put("seguro", SEGURO);

        ID_SIMULACAO =
        given()
                .log().all()
                .contentType("application/json")
                .body(params)
        .when()
                .post("/simulacoes")
        .then()
                .log().all()
                .statusCode(201)
                .body("id", is(notNullValue()))
                .body("nome", is(NOME))
                .body("cpf", is(CPF))
                .body("email", is(EMAIL))
                .body("valor", is(VALOR_SIMULACAO))
                .body("seguro", is(SEGURO))
                .body("parcelas", is(PARCELAS))
                .extract().path("id")
        ;
        setID_SIMULACAO_CRIADO(ID_SIMULACAO);
    }

    @Test
    public void criarSimulacaoSemCamposObrigatorios(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "");
        params.put("email", "");
        params.put("valor", "");
        params.put("parcelas", "");
        params.put("seguro", "");

        given()
                .log().all()
                .contentType("application/json")
                .body(params)
                .when()
                .post("/simulacoes")
                .then()
                .log().all()
                .statusCode(400)
                .log().all()
                .body("erros.nome", is("Nome não pode ser vazio"))
                .body("erros.cpf", is("CPF não pode ser vazio"))
                .body("erros.valor", is("Valor não pode ser vazio"))
                .body("erros.email", is("E-mail deve ser um e-mail válido"))
                .body("erros.parcelas", is("Parcelas não pode ser vazio"))
                //.body("erros.Seguro", is("Seguro não pode ser vazio"))

        ;
    }

    @Test
    public void criarSimulacaoMesmoCPF(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nome", NOME_ALTERADO);
        params.put("cpf", CPF);
        params.put("email", EMAIL);
        params.put("valor", VALOR_SIMULACAO);
        params.put("parcelas", PARCELAS);
        params.put("seguro", SEGURO);

        given()
                .log().all()
                .contentType("application/json")
                .body(params)
                .when()
                .post("/simulacoes")
                .then()
                .log().all()
                .statusCode(400)
                .body("mensagem", is("CPF duplicado"))
        ;
    }

}
