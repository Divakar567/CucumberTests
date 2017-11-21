package com.divaportal.users;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;


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

    @And("^check the get response is (.+)$")
    public void getUsersList(String Success) throws Throwable {
    	String status;
    	if(latestResponse.getBody().contains("org_name") && latestResponse.getBody().contains("activated") && latestResponse.getBody().contains("created_by") && latestResponse.getBody().contains("org_type_id")) {
    		status="Success";
    	}else {
    		status="Fail";
    	}
    	assertThat(status , is(Success));
    }

    @When("^the user is new user$")
    public void testRegisteringUser() throws Throwable {
        String postBody = "{ \"username\":\"Divakar567\", \"password\":\"test123\", \"fname\":\"Divakar Babu\", \"zip\":\"12345\", \"phone\":\"907654321\", \"org_id\":251, \"lname\":\"Budumuru\", \"email\":\"divakar.budumuru1@netenrich.com\", \"address\":\"Srikakulam\", \"country_id\":1, \"city\":\"Srikakulam\", \"created_by\":151, \"modified_by\":17356, \"image\":\"\" }";
    	String postRequest="http://localhost:8000/2016101819336/users/";
    	executeUserPost(postRequest, postBody);
    }

    @And("^check the post response as (.+)$")
    public void checkResponseBody(String thisResponseBody) throws Throwable {
    	final String currentResponseBody=latestResponse.getBody();
    	System.out.println("Good :"+currentResponseBody);
    	System.out.println("Bad :"+thisResponseBody);
        assertEquals(currentResponseBody,thisResponseBody);
    }
}