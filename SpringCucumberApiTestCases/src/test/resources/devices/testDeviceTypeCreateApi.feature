Feature: Testing create Device Type API
	Scenario Outline: Sending good POST request to /devices/ for creating Device type
		When post request with payload as <payload> sent to this URI <url>
    	Then check the response Http status code as <status>
    	And check the server status response is with this response <response>
    Examples:
    	|payload|url|status|response|
    	|{"name":"Desktop","parent_type_id":1,"path":"desktop"}|http://localhost:8000/20161025141111/devices/types/|200|{"response":"devices.services.post.device_type.success"}|