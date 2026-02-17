package api;
import config.ApiConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
//Llamados a microservicios
public class PostmanClient {
     private static final String SOAP_ACTION = "consultarUsuario";

    public Response consultarUsuario(String idCliente) {
        String soap = buildConsultarUsuarioRequest(idCliente);
     return given()
                .baseUri(ApiConfig.getBaseUrl())
                .basePath(ApiConfig.getWsPortalPath())
                .contentType("text/xml; charset=UTF-8")
                .accept(ContentType.XML)
                .header("SOAPAction", SOAP_ACTION)
                .body(soap)
                .when()
                .post();
    }

    private String buildConsultarUsuarioRequest(String idCliente) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:ser=\"http://services.backoffice.omnichannel.technisys.com/\">"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                + "<ser:consultarUsuario>"
                + "<idCliente>" + idCliente + "</idCliente>"
                + "<userName></userName>"
                + "<boUser>admin</boUser>"
                + "<boPassword>1munqgy4odetg12w6z0bb8nd84tszmwzju342o2doltngqgvvmik5j5t57r1n84jtvrvr36oa9mf9wf9udtk8o06rn1xsurfteezefa133gypiccifwlgf30d7m7vuvxtyhm15xe6s92f4diwklxqjmn1n95u4hndd6ekpvv5hgwrt4s2p1rt10sewgaaongq3koxbc</boPassword>"
                + "<usuarioPortal>wspadmin</usuarioPortal>"
                + "<agenciaPortal>037</agenciaPortal>"
                + "</ser:consultarUsuario>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
    }
}

