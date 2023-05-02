package Utils;

import io.restassured.http.ContentType;

public interface Constantes {

    String APP_BASE_URL = "http://localhost";
    Integer APP_PORT = 8080;
    String APP_BASE_PATH = "/api/v1";


    String CPF_COM_RESTRICAO = "97093236014";
    String CPF_SEM_RESTRICAO = "15412025030";
    String CPF_INVALIDO = "10000000000";

    Integer ID_INEXISTENTE = 1000;

    String NOME = "Elton";
    String CPF = "81070037052";
    String EMAIL = "elton@gmail.com";
    Integer VALOR_SIMULACAO = 2000;
    Integer PARCELAS = 3;
    Boolean SEGURO = true;
    String NOME_ALTERADO = "Nome Alterado";
    String CPF_ALTERADO = "54108134053";
    ContentType APP_CONTENT_TYPE = ContentType.JSON;


}
