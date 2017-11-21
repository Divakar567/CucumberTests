#Test cases for Device Update API Examples: 1-3
#	1. Positive test case (Request with good url and good Request Body)
#	2. Nagative test case (Request with bad url and good Request Body)
#	3. Nagative test case (Request with good url and bad Request Body)
Feature: Testing Update Device API
	Scenario Outline: Sending PATCH requests to /devices/ for updating Device
		When patch request with payload as <payload> sent to this URI <url>
    	Then check the response Http status code as <httpstatus>
    	And check the server status response is with this response <response>
    
    Examples:
    |payload|url|httpstatus|response|
    |{"device_type_id":"11","name":"Testlabmember1","dns_name":"10.5.0.1","ipaddress":"10.5.0.6","mac_address":"00:0D:3A:12:93:3B","os":"Windows 2012-R2-Datacenter","physicalmemory_GB":"0","model":"","manufacturer":"","sysvendor":"AZURE","serial_number":"","biosname":"","bioversion":""}|http://localhost:8000/20161025141111/devices/171120554456698/|200|{"response":"devices.services.update_device_success"}|
    |{"device_type_id":"11","name":"Testlabmember1","dns_name":"10.0.01","serial_number":"3","os":"windows","physicalmemory_GB":120,"sysvendor":"Dell","mac_address":"12.23.56.3","model":"123","bioversion":"2","biosname":"test","device_type":1,"manufacturer":"Dell","status":1,"status_last_update":0}|http://localhost:8000/20161025141111/devices/171100000000098/|404|{"response":"devices.devices_view_set.put.device_not_exist"}|
    |{"dns_name":"10.0.01","serial_number":"3","os":"windows","physicalmemory_GB":120,"sysvendor":"Dell","mac_address":"12.23.56.3","model":"123","bioversion":"2","biosname":"test","device_type":1,"manufacturer":"Dell","status":1,"status_last_update":0}|http://localhost:8000/20161025141111/devices/171120554456698/|200|"devices.services.put.mandatory_resp"|