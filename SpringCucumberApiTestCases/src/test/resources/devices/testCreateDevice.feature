Feature: Testing create Device API and Delete Device API and Device Type create API
	Scenario Outline: Sending good POST request to /devices/ for registering single device
		When post request with payload as <payload> sent to this URI <url>
    	Then check the response Http status code as <status>
    	And check the server status response is with this response <response>
    Examples:
    	|payload|url|status|response|
    	|{"name":"TestDevice","ipaddress":"172.26.10.56","dns_name":"10.0.01","serial_number":"3","os":"windows","physicalmemory_GB":120,"sysvendor":"Dell","mac_address":"12.23.56.3","model":"123","bioversion":"2","biosname":"test","device_type":1,"manufacturer":"Dell","status":1,"status_last_update":0}|http://localhost:8000/20161025141111/devices/|200|{"status":"success","response":"devices.services.create_device_success"}|
    	|{"name":"Desktop","parent_type_id":1,"path":"desktop"}|http://localhost:8000/20161025141111/devices/types/|200|{"response":"devices.services.post.device_type.success"}|
    Scenario: Sending bad POST request to /devices/ for registering single device
		When post request with payload as {"dns_name":"10.0.01","serial_number":"3","os":"windows","physicalmemory_GB":120,"sysvendor":"Dell","mac_address":"12.23.56.3","model":"123","bioversion":"2","biosname":"test","device_type":1,"manufacturer":"Dell","status":1,"status_last_update":0} sent to this URI http://localhost:8000/20161025141111/devices/
    	Then check the response Http status code as 302
    	And check the server status response is with this response {"status":"failed","response":"devices.services.post.mandatory_resp"}
	
	Scenario Outline: Sending DELETE request to /devices/
		When delete request sent
    	Then check the response Http status code as <status>
    	And check the server status response is with this response <response>
    Examples:
    	|status|response|
    	|200|{"response":"devices.devices_view_set.delete.success"}|
    	|404|{"response":"devices.devices_view_set.delete.device_not_exist"}|
