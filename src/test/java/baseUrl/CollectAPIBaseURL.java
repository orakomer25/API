package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class CollectAPIBaseURL {
    protected RequestSpecification specCollecApi;
    @Before
    public void setUp(){
        specCollecApi=new RequestSpecBuilder()
                .setBaseUri("https://api.collectapi.com").build();


    }
}
