package test;

import baseUrl.CollectAPIBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C27_CollectAPI_NobEcz extends CollectAPIBaseURL {
    @Test
    public void NobetciEczane() {
        specCollecApi.pathParams("pp1","health","pp2","dutyPharmacy").queryParams("ilce","Üsküdar","il","İstanbul");
        String token="0pCMVm90RHY5yJgj1aHNX3:5uCH7s5XyeMUzZshynjwHD";
        Response response=given()
                .spec(specCollecApi)
                .headers("authorization","apikey "+token)
                .when()
                .get("/{pp1}/{pp2}");


        System.out.println("statusCode() = " + response.statusCode());
        response.prettyPrint();


    }
}
