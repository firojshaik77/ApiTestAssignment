package org.testng.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.propertymgr.PropertyManager;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;


/**
 * Purpose: To automate GET request and assert the status code. 
 * @author Firoj Shaik
 *
 */
public class GetAPITest extends PropertyManager {

    private final Properties configProperty = new PropertyManager()
            .loadPropertyFile("config.properties");
    String serviceUrl;
    String apiUrl;
    String url;

    /**
     * set values.
     * @throws IOException
     */
    @BeforeMethod
    public void setUp() throws IOException {

        apiUrl = configProperty.getProperty("apiURL");
        serviceUrl = configProperty.getProperty("serviceURL1");
        url = apiUrl + serviceUrl;

    }


    /**
     * Test method for GET and assert the status code and print the response.
     */
    @Test
    public void getAPITest() {
        System.out.println("GET API Test ...");
        Response resp = given().when().get(url);
        Assert.assertEquals(resp.getStatusCode(), RESPONSE_STATUS_CODE_200);
        System.out.println("The API response code is : " + resp.getStatusCode());
        System.out.println("The API Response is : " + resp.asString());

    }


}
