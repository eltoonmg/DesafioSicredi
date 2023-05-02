package Simulacoes;

import Utils.BaseTest;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class DeletarSimulacoes extends BaseTest {

    @Test
    public void deletarSimulacao(){
        given()
                .log().all()
                .pathParam("id", getID_SIMULACAO_CRIADO())
        .when()
                .delete("/simulacoes/{id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void deletarSimulacaoInexistente(){
        given()
                .log().all()
                .pathParam("id", ID_INEXISTENTE)
        .when()
                .delete("/simulacoes/{id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }
}
