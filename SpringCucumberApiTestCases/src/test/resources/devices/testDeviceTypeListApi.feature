Feature: Testing Device Type List API
	Scenario Outline: Sending GET request to /devices/ for Devices Type List
		When get request sent to this URI <url>
    	Then check the response Http status code as <status>
    	And compare server response with this payload <samplePayload>
    Examples:
    |url|status|samplePayload|
    |http://localhost:8000/20161025141111/devices/types/|200|{"device_type_id":116,"name":"Desktop"}|