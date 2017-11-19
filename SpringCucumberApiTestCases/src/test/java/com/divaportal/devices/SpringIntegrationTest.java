package com.divaportal.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.divaportal.SpringCucumberApiTestCasesApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringCucumberApiTestCasesApplication.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
public class SpringIntegrationTest {
	static ResponseResults latestResponse = null;

	@Autowired
	protected RestTemplate restTemplate;

	
	void executeUserListGet(String url) throws IOException {
		final Map<String, String> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
		final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

		restTemplate.setErrorHandler(errorHandler);
		latestResponse = restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
			if (errorHandler.hadError) {
				return (errorHandler.getResults());
			} else {
				return (new ResponseResults(response));
			}
		});
	}
	
	
	void executeUserPost(String postRequest, String postBody) throws IOException {
		final Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
		
		requestCallback.setBody(postBody);
		final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}

		restTemplate.setErrorHandler(errorHandler);
		latestResponse = restTemplate.execute(postRequest, HttpMethod.POST, requestCallback,
				response -> {
					if (errorHandler.hadError) {
						return (errorHandler.getResults());
					} else {
						return (new ResponseResults(response));
					}
				});
	}

	private class ResponseResultErrorHandler implements ResponseErrorHandler {
		private ResponseResults results = null;
		private Boolean hadError = false;

		private ResponseResults getResults() {
			return results;
		}

		@Override
		public boolean hasError(ClientHttpResponse response) throws IOException {
			hadError = response.getRawStatusCode() >= 400;
			return hadError;
		}

		@Override
		public void handleError(ClientHttpResponse response) throws IOException {
			results = new ResponseResults(response);
		}
	}

}