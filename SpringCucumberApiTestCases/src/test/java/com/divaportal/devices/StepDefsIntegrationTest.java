package com.divaportal.devices;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {
    
    
    @When("^get request sent to this URI (.+)$")
    public void callUsersList(String url) throws Throwable {
    	String request=(url);
        executeUserListGet(request);
    }

    @Then("^check the response Http status code as (\\d+)$")
    public void checkResponseHttpStatusCode(int thisHttpStatus) throws Throwable {
    	final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is( thisHttpStatus ));
    }

    @And("^compare server response with this payload (.+)$")
    public void getDevicesList(String sampleDevicesJsonObject) throws Throwable {
    	String sampleDevicesJsonList="["+sampleDevicesJsonObject+"]";
    	assertTrue(KeysExtractor.compareKeys(KeysExtractor.returnKeysFromResponseBody(sampleDevicesJsonList),KeysExtractor.returnKeysFromResponseBody(latestResponse.getBody())));
    }

    @And("^check the server status response is with this response (.+)$")
    public void checkServerResponse(String expectedResponse) {
    	String recievedResponse=latestResponse.getBody();
    	assertThat("Response is incorrect: "+recievedResponse,recievedResponse, is(expectedResponse));
    }
    
    @And("^compare server response with this Object payload (.+)$")
    public void getDeviceDetails(String sampleDevicesJsonObject) throws Throwable {
    	assertTrue(KeysExtractor.compareKeys(KeysExtractor.returnKeysFromResponseBody(sampleDevicesJsonObject,1),KeysExtractor.returnKeysFromResponseBody(latestResponse.getBody(),1)));
    }
    
    @When("^post request with payload as (.+) sent to this URI (.+)$")
    public void postPayloadToUri(String payload, String uri) throws IOException {
    	executeUserPost(uri, payload);
    }
    
    @When("^patch request with payload as (.+) sent to this URI (.+)$")
    public void patchPayloadToUri(String payload, String uri) throws IOException {
    	executeUserPatch(uri, payload);
    }
    
    @When("^delete request sent$")
    public void delete_request_sent() throws Throwable {
    	String request="http://localhost:8000/20161025141111/devices/";
    	executeUserListGet(request);
    	String deviceID=KeysExtractor.findTestDevice(latestResponse.getBody());
    	if(deviceID==null) {
    		deviceID="1000000000000009";
    	}
    	latestResponse=null;
    	request=request+deviceID.trim()+"/";
    	executeUserDelete(request);
    }

}