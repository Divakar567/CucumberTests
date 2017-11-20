Feature: Testing Device Activate/Deactivate API
	Scenario: Sending DELETE request to /devices/
		When delete request sent
    	Then check the response Http status code as 200
    	And check the server status response is with this response {"response":"devices.devices_view_set.delete.success"}
    Scenario: Sending DELETE request to /devices/
		When delete request sent 
    	Then check the response Http status code as 404
    	And check the server status response is with this response {"response":"devices.devices_view_set.delete.device_not_exist"}