package test;

import baseUrl.HerOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPOJO;
import pojos.BookingPOJO;
import pojos.HerokuAppPOJO;

import static io.restassured.RestAssured.given;

public class C24_POST_POJOClas extends HerOkuAppBaseURL {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body = Expected Data
    	            	{
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){
        specHerOkuApp.pathParam("pp1","booking");
        BookingDatesPOJO bookingdates=new BookingDatesPOJO("2021-06-01","2021-06-10");
        BookingPOJO reqBody=new BookingPOJO("Ali","Bak",500,false,bookingdates,"wi-fi");

        HerokuAppPOJO expBody=new HerokuAppPOJO(2750,reqBody);

        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON)
                         .when()
                        .body(reqBody).post("/{pp1}");
        HerokuAppPOJO respPOJO=response.as(HerokuAppPOJO.class);

       // Assert.assertEquals(expBody.getBookingid(),respPOJO.getBookingid());
        Assert.assertEquals(expBody.getBooking().getFirstname(),respPOJO.getBooking().getFirstname());
        Assert.assertEquals(expBody.getBooking().getLastname(),respPOJO.getBooking().getLastname());
        Assert.assertEquals(expBody.getBooking().getTotalprice(),respPOJO.getBooking().getTotalprice());
        Assert.assertEquals(expBody.getBooking().isDepositpaid(),respPOJO.getBooking().isDepositpaid());
        Assert.assertEquals(expBody.getBooking().getBookingdates().getCheckin(),respPOJO.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expBody.getBooking().getBookingdates().getCheckout(),respPOJO.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(expBody.getBooking().getAdditionalneeds(),respPOJO.getBooking().getAdditionalneeds());







    }

}
