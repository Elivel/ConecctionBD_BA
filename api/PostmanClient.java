package api;
import static io.restassured.RestAssured.given;
import config.ApiConfig;
//Llamados a microservicios
public class PostmanClient {
     public void crearTarjeta() {

        given()
            .baseUri(ApiConfig.getBaseUrl('https://10.54.5.220/backoffice/services/WSPortal?wsdl'))
            .body("
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services.backoffice.omnichannel.technisys.com/">
    <soapenv:Header/>
    <soapenv:Body>
        <ser:consultarUsuario>
            <idCliente>38687</idCliente>
        String soap = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ser='http://services.backoffice.omnichannel.technisys.com/'>\n"
                + "    <soapenv:Header/>\n"
                + "    <soapenv:Body>\n"
                + "        <ser:consultarUsuario>\n"
                + "            <idCliente>38687</idCliente>\n"
                + "            <userName></userName>\n"
                + "            <boUser>admin</boUser>\n"
                + "            <boPassword>1munqgy4odetg12w6z0bb8nd84tszmwzju342o2doltngqgvvmik5j5t57r1n84jtvrvr36oa9mf9wf9udtk8o06rn1xsurfteezefa133gypiccifwlgf30d7m7vuvxtyhm15xe6s92f4diwklxqjmn1n95u4hndd6ekpvv5hgwrt4s2p1rt10sewgaaongq3koxbc</boPassword>\n"
                + "            <usuarioPortal>wspadmin</usuarioPortal>\n"
                + "            <agenciaPortal>037</agenciaPortal>\n"
                + "        </ser:consultarUsuario>\n"
                + "    </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        given()
            .baseUri(ApiConfig.getBaseUrl("https://10.54.5.220/backoffice/services/WSPortal?wsdl"))
            .body(soap)
        .when()
            .post("/tarjetas")
        .then()
            .statusCode(200);
