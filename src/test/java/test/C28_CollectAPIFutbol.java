package test;

import baseUrl.CollectAPIBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C28_CollectAPIFutbol extends CollectAPIBaseURL {
    @Test
    public void Get01() {
        specCollecApi.pathParams("pp1","football","pp2","leaguesList");

        String token="0pCMVm90RHY5yJgj1aHNX3:5uCH7s5XyeMUzZshynjwHD";
        Response response=given().spec(specCollecApi)
                .headers("authorization","apikey "+token)
                .when()
                .get("/{pp1}/{pp2}");

        response.prettyPrint();
    }
}
