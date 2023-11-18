package test;

import baseUrl.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyDataPOJO;
import pojos.DummyExpDataPOJO;

import static io.restassured.RestAssured.given;

public class C25_GET_PojoClassKullanimi extends DummyBaseUrl {
    /*
    {
"status": "success",
"data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
},
"message": "Successfully! Record has been fetched."
}

     */

    @Test
    public void Get01() {
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        //2-ExpData hazırla

        DummyDataPOJO dataPOJO=new DummyDataPOJO(3,"Ashton Cox",86000,66,"");
        DummyExpDataPOJO expDataPOJO=new DummyExpDataPOJO("success",dataPOJO,"Successfully! Record has been fetched.");

        Response response =given().spec(specDummy)
                .when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
       // response.prettyPrint();
        DummyExpDataPOJO respPOJO=response.as(DummyExpDataPOJO.class);

        Assert.assertEquals(expDataPOJO.getStatus(),respPOJO.getStatus());
        Assert.assertEquals(expDataPOJO.getData().getId(),respPOJO.getData().getId());
        Assert.assertEquals(expDataPOJO.getData().getEmployee_name(),respPOJO.getData().getEmployee_name());
        Assert.assertEquals(expDataPOJO.getData().getEmployee_age(),respPOJO.getData().getEmployee_age());
        Assert.assertEquals(expDataPOJO.getData().getEmployee_salary(),respPOJO.getData().getEmployee_salary());
        Assert.assertEquals(expDataPOJO.getMessage(),respPOJO.getMessage());


    }
}
