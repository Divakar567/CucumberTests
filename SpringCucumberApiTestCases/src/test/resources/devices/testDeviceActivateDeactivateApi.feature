#Test cases for Activate/Deactivate API are in Examples: 4-9
#	1. Positive test case (Request with good url and good request body for activation of device)
#	2. Positive test case (Request with good url and good request body for deactivatio of device)
#	3. Nagative test case (Request with good url and bad request body with wrong device ids for activation)
#	4. Nagative test case (Request with good url and bad request body with wrong device ids for deactivation)
#	5. Nagative test case (Request with bad url with wrong org id and good request body for activation)
#	6. Nagative test case (Request with bad url with wrong ofg id and good request body for deactivation)
Feature: Testing Update Device API and Device Activate/Deactivate API
	Scenario Outline: Sending PATCH requests to /devices/
		When patch request with payload as <payload> sent to this URI <url>
    	Then check the response Http status code as <httpstatus>
    	And check the server status response is with this response <response>
    
    Examples:
    |payload|url|httpstatus|response|
    |{"status_code":1,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20161025141111/devices/|200|{"status":"success","response":"devices.services.patch.activation_succuss"}|
    |{"status_code":0,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20161025141111/devices/|200|{"status":"success","response":"devices.services.patch.deactivation_success"}|
    |{"status_code":1,"unique_ids":[100000000000002,100000000000004]}|http://localhost:8000/20161025141111/devices/|200|{"status":"failed","response":"devices.services.patch.activation_fail_ids"}|
    |{"status_code":0,"unique_ids":[100000000000002,100000000000004]}|http://localhost:8000/20161025141111/devices/|200|{"status":"failed","response":"devices.services.patch.deactivation_fail_ids"}|
    |{"status_code":1,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20000000000001/devices/|404|{"status":"failed","response":"devices.devices_view_set.patch.org_not_exist"}|
    |{"status_code":0,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20000000000001/devices/|404|{"status":"failed","response":"devices.devices_view_set.patch.org_not_exist"}|
    