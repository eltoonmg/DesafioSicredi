package Restricao;

import Utils.BaseTest;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Restricoes extends BaseTest {

    @Test
    public void concultarCPFComRestricao(){
        given()
                .pathParam("cpf", CPF_COM_RESTRICAO)
        .when()
                .get("/restricoes/{cpf}")
        .then()
                .statusCode(200)
                .body(containsString("O CPF " + CPF_COM_RESTRICAO + " tem problema"))
        ;

    }

    @Test
    public void concultarCPFSemRestricao(){
        given()
                .pathParam("cpf", CPF_SEM_RESTRICAO)
        .when()
                .get("/restricoes/{cpf}")
        .then()
                .statusCode(204)
                ;
    }
}
