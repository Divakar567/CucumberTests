Feature: Testing Device Delete API
	Scenario Outline: Sending DELETE request to /devices/
		When delete request sent
    	Then check the response Http status code as <status>
    	And check the server status response is with this response <response>
    Examples:
    	|status|response|
    	|200|{"response":"devices.devices_view_set.delete.success"}|
    	|404|{"response":"devices.devices_view_set.delete.device_not_exist"}|
