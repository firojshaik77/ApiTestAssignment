package org.testng.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.propertymgr.PropertyManager;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;


/**
 * Purpose: To automate POST request and assert the status code. 
 * @author Firoj Shaik
 *
 */
public class PostAPITest extends PropertyManager {
    private final Properties configProperty = new PropertyManager()
            .loadPropertyFile("config.properties");
    String serviceUrl;
    String apiUrl;
    String url;
    String jsonFilePath;

    /**
     * @throws IOException
     */
    @BeforeMethod
    public void setUp() throws IOException {

        apiUrl = configProperty.getProperty("apiURL");
        serviceUrl = configProperty.getProperty("serviceURL2");
        jsonFilePath = configProperty.getProperty("jsonPath");
        url = apiUrl + serviceUrl;

    }

    /**
     * Test method for POST and assert the status code and print the response.
     */
    @Test
    public void postAPITest() {
        System.out.println("POST API Test ...");
        File file = new File(jsonFilePath);
        Response resp = given().body(file).when().contentType("application/json").post(url);
        Assert.assertEquals(resp.getStatusCode(), RESPONSE_STATUS_CODE_200);
        System.out.println("The API response code is : " + resp.getStatusCode());
        System.out.println("The API Response is : " + resp.asString());

    }

}
