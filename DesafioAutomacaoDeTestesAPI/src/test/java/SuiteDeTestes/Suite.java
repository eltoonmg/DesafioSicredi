package SuiteDeTestes;

import Utils.BaseTest;
import Restricao.Restricoes;
import Simulacoes.AlterarSimulacoes;
import Simulacoes.ConsultarSimulacoes;
import Simulacoes.CriarSimulacoes;
import Simulacoes.DeletarSimulacoes;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
      Restricoes.class,
      CriarSimulacoes.class,
      ConsultarSimulacoes.class,
      AlterarSimulacoes.class,
      DeletarSimulacoes.class
})
public class Suite extends BaseTest {

    @BeforeClass
    public static void setup() {

        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();
    }
}
