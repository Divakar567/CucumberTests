package com.divaportal.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import com.divaportal.devices.KeysExtractor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {
    
    
	

    @Then("^check the response Http status code as (\\d+)$")
    public void checkResponseHttpStatusCode(int thisHttpStatus) throws Throwable {
    	final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is( thisHttpStatus ));
    }

    @And("^check the server status response is with this response (.+)$")
    public void checkServerResponse(String expectedResponse) {
    	String recievedResponse=latestResponse.getBody();
    	assertThat("Response is incorrect: "+recievedResponse,recievedResponse, is(expectedResponse));
    }
    
    
    

}