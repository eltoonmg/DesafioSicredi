package Simulacoes;

import Utils.BaseTest;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ConsultarSimulacoes extends BaseTest {

    @Test
    public void buscarTodasSimulacoes(){
        given()
                .when()
                .get("/simulacoes")
                .then()
                .statusCode(200)
                .body(is(not(nullValue())))
                .log().all();
        ;
    }

    @Test
    public void buscarSimulacaoPorCPF(){
        given()
                .pathParam("cpf", CPF)
        .when()
                .get("/simulacoes/{cpf}")
        .then()
                .statusCode(200)
                .body(is(not(nullValue())))
                .body("nome", containsString(NOME))
        ;
    }

    @Test
    public void buscarSimulacaoInvalidaPorCPF(){
        given()
                .pathParam("cpf", CPF_INVALIDO)
        .when()
                .get("/simulacoes/{cpf}")
        .then()
                .statusCode(404)
                .log().all()
                .body("mensagem", containsString("CPF " + CPF_INVALIDO + " não encontrado"))
        ;
    }
}
