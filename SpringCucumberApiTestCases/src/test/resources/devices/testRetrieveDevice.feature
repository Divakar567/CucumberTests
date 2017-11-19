Feature: Testing Single Device Retrieve API
	Scenario: Sending GET request to /devices/<device_unique_id> for retrieving single device
		When get request sent to this URI http://localhost:8000/20161025141111/devices/20161025142616
    	Then check the response Http status code as 200
    	And compare server response with this Object payload {"device_id":11,"name":"APP27HGTR","ipaddress":"10.2.31.8","dns_name":"APP27HGTR.Tukuru.local","serial_number":"889QB3TMY454","os":"Windows Datacenter Server","physicalmemory_GB":"32.00","sysvendor":"DELL","mac_address":"00:50:56:85:00:02","model":"DELL","bioversion":"8.9.33.4","biosname":"Phoenix","device_type_id":8,"activated":1,"manufacturer":"DELL","org_id":571,"unique_id":2016102514370,"created_date":null,"modified_date":null,"status":2,"status_last_update":0,"site_name":null,"city_id":0,"service_name":null,"logmein_host_id":null,"hardware_inventory":null,"system_inventory":null,"anti_virus_details":null}
    Scenario: Sending GET bad request to /devices/ for registering user List
		When get request sent to this URI http://localhost:8000/20161025141111/devices/20000000000001
    	Then check the response Http status code as 404
    	And check the server status response is with this response {"response":"devices.devices_view_set.get.device_not_exist"}