Feature: Testing Devices List API
	Scenario: Sending GET request to /devices/ for Devices List
		When get request sent to this URI http://localhost:8000/20161025141111/devices/
    	Then check the response Http status code as 200
    	And compare server response with this payload {"logmein_host_id":null,"site_name":null,"city_id":0,"service_name":null,"sysvendor":"HP","status_last_update":0,"system_inventory":null,"anti_virus_details":null,"modified_date":null,"hardware_inventory":null,"biosname":"Phoenix","deviceType":"Router","mac_address":"00:0D:3A:70:96:4E","device_type_id":8,"device_id":1,"physicalmemory_GB":32.0,"STATUS":2,"activated":1,"parent_type_id":39,"serial_number":"66S89LOMY2421","path":"Network Device >> Router","ipaddress":"10.10.0.4","manufacturer":"HP","name":"AZR-FTP01","dns_name":"AZR-FTP01.Tukuru.local","org_id":571,"bioversion":"8.2.33.8","created_date":null,"model":"HP Priloant","os":"Windows 2012-R2-Datacenter","unique_id":20161025142616}
    Scenario: Sending GET bad request to /users/ for registering user List
		When get request sent to this URI http://localhost:8000/20000000000001/devices/
    	Then check the response Http status code as 404
    	And check the server status response is with this response {"status":"failed","response":"devices.devices_view_set.get.org_not_exist"}
 