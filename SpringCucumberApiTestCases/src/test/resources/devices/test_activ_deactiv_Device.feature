#Test cases for Device Update API Examples: 1-3
#	1. Positive test case (Request with good url and good Request Body)
#	2. Nagative test case (Request with bad url and good Request Body)
#	3. Nagative test case (Request with good url and bad Request Body)
#Test cases for Activate/Deactivate API are in Examples: 4-9
#	4. Positive test case (Request with good url and good request body for activation of device)
#	5. Positive test case (Request with good url and good request body for deactivatio of device)
#	6. Nagative test case (Request with good url and bad request body with wrong device ids for activation)
#	7. Nagative test case (Request with good url and bad request body with wrong device ids for deactivation)
#	8. Nagative test case (Request with bad url with wrong org id and good request body for activation)
#	9. Nagative test case (Request with bad url with wrong ofg id and good request body for deactivation)
Feature: Testing Update Device API and Device Activate/Deactivate API
	Scenario Outline: Sending PATCH requests to /devices/
		When patch request with payload as <payload> sent to this URI <url>
    	Then check the response Http status code as <httpstatus>
    	And check the server status response is with this response <response>
    
    Examples:
    |payload|url|httpstatus|response|
    |{"device_type_id":"11","name":"Testlabmember1","dns_name":"10.5.0.1","ipaddress":"10.5.0.6","mac_address":"00:0D:3A:12:93:3B","os":"Windows 2012-R2-Datacenter","physicalmemory_GB":"0","model":"","manufacturer":"","sysvendor":"AZURE","serial_number":"","biosname":"","bioversion":""}|http://localhost:8000/20161025141111/devices/171120554456698/|200|{"response":"devices.services.update_device_success"}|
    |{"device_type_id":"11","name":"Testlabmember1","dns_name":"10.0.01","serial_number":"3","os":"windows","physicalmemory_GB":120,"sysvendor":"Dell","mac_address":"12.23.56.3","model":"123","bioversion":"2","biosname":"test","device_type":1,"manufacturer":"Dell","status":1,"status_last_update":0}|http://localhost:8000/20161025141111/devices/171100000000098/|404|{"response":"devices.devices_view_set.put.device_not_exist"}|
    |{"dns_name":"10.0.01","serial_number":"3","os":"windows","physicalmemory_GB":120,"sysvendor":"Dell","mac_address":"12.23.56.3","model":"123","bioversion":"2","biosname":"test","device_type":1,"manufacturer":"Dell","status":1,"status_last_update":0}|http://localhost:8000/20161025141111/devices/171120554456698/|200|"devices.services.put.mandatory_resp"|
    |{"status_code":1,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20161025141111/devices/|200|{"status":"success","response":"devices.services.patch.activation_succuss"}|
    |{"status_code":0,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20161025141111/devices/|200|{"status":"success","response":"devices.services.patch.deactivation_success"}|
    |{"status_code":1,"unique_ids":[100000000000002,100000000000004]}|http://localhost:8000/20161025141111/devices/|200|{"status":"failed","response":"devices.services.patch.activation_fail_ids"}|
    |{"status_code":0,"unique_ids":[100000000000002,100000000000004]}|http://localhost:8000/20161025141111/devices/|200|{"status":"failed","response":"devices.services.patch.deactivation_fail_ids"}|
    |{"status_code":1,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20000000000001/devices/|404|{"status":"failed","response":"devices.devices_view_set.patch.org_not_exist"}|
    |{"status_code":0,"unique_ids":[171120729163182,171120724117044]}|http://localhost:8000/20000000000001/devices/|404|{"status":"failed","response":"devices.devices_view_set.patch.org_not_exist"}|
    