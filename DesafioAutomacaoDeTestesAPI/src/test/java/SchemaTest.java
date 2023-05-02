import Utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class SchemaTest extends BaseTest {

    @Test
    public void validarSchema() {
        given()
                .log().all()
        .when()
                .get("/simulacoes")
        .then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("users.json"))
                        ;
    }
}
