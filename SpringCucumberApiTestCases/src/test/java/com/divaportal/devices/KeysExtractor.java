package com.divaportal.devices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KeysExtractor {

	public static ArrayList<String> returnKeysFromResponseBody(String responseBody) throws JSONException{
		
		JSONArray jsonArray = new JSONArray(responseBody);
		JSONObject jsonObj = jsonArray.getJSONObject(0);
		@SuppressWarnings("rawtypes")
		Iterator objKeys = jsonObj.keys();
		ArrayList<String> payloadKeys=new ArrayList<String>();
		while(objKeys.hasNext()) {
			String key=(String)objKeys.next();
			payloadKeys.add(key);
		}
		return payloadKeys;
		
	}
	
	public static ArrayList<String> returnKeysFromResponseBody(String responseBody,int no) throws JSONException{
		
		JSONObject jsonObj = new JSONObject(responseBody);
		@SuppressWarnings("rawtypes")
		Iterator objKeys = jsonObj.keys();
		ArrayList<String> payloadKeys=new ArrayList<String>();
		while(objKeys.hasNext()) {
			String key=(String)objKeys.next();
			payloadKeys.add(key);
		}
		return payloadKeys;
		
	}

	public static boolean compareKeys(ArrayList<String> sampleResponse, ArrayList<String> originalResponse) {
		if (sampleResponse == null && originalResponse == null) return true;


	    if ((sampleResponse == null && originalResponse!= null) || (sampleResponse != null && originalResponse== null) || (sampleResponse.size() != originalResponse.size()))
	    {
	        return false;
	    }
         
	    Collections.sort(sampleResponse);
	    Collections.sort(originalResponse);      
	    return sampleResponse.equals(originalResponse);
	}

	public static String findTestDevice(String responseBody) throws JSONException {
		JSONArray jsonArray = new JSONArray(responseBody);
		for(int i=0;i<jsonArray.length();i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			String name=jsonObj.getString("name");
			if(name.equals("TestDevice")) {
				Long device_unique_id=new Long(jsonObj.getLong("unique_id"));
				String deviceID=device_unique_id.toString();
				return deviceID;
			}
		}
		return null;
	}

	
//	public static void main(String args[]) {
//		ArrayList<String> a=returnKeysFromResponseBody("[\r\n" + 
//				"    {\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"HP\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:0D:3A:70:96:4E\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 1,\r\n" + 
//				"        \"physicalmemory_GB\": 32.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"66S89LOMY2421\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"10.10.0.4\",\r\n" + 
//				"        \"manufacturer\": \"HP\",\r\n" + 
//				"        \"name\": \"AZR-FTP01\",\r\n" + 
//				"        \"dns_name\": \"AZR-FTP01.Tukuru.local\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"8.2.33.8\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"HP Priloant\",\r\n" + 
//				"        \"os\": \"Windows 2012-R2-Datacenter\",\r\n" + 
//				"        \"unique_id\": 20161025142616\r\n" + 
//				"    },\r\n" + 
//				"    {\r\n" + 
//				"        \"logmein_host_id\": null,\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"DELL\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:50:56:85:00:02\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 11,\r\n" + 
//				"        \"physicalmemory_GB\": 32.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"889QB3TMY454\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"10.2.31.8\",\r\n" + 
//				"        \"manufacturer\": \"DELL\",\r\n" + 
//				"        \"name\": \"APP27HGTR\",\r\n" + 
//				"        \"dns_name\": \"APP27HGTR.Tukuru.local\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"8.9.33.4\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"DELL\",\r\n" + 
//				"        \"os\": \"Windows Datacenter Server\",\r\n" + 
//				"        \"unique_id\": 2016102514370\r\n" + 
//				"    },\r\n" + 
//				"    {\r\n" + 
//				"        \"logmein_host_id\": null,\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"HP\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:50:99:85:20:02\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 21,\r\n" + 
//				"        \"physicalmemory_GB\": 64.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"UY77890OKT77\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"10.10.0.9\",\r\n" + 
//				"        \"manufacturer\": \"HP\",\r\n" + 
//				"        \"name\": \"FSBQQY65\",\r\n" + 
//				"        \"dns_name\": \"FSBQQY65tukuru.local\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"8.33.2.1B\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"HP\",\r\n" + 
//				"        \"os\": \"Microsoft Windows Server 2012 Datacenter\",\r\n" + 
//				"        \"unique_id\": 20161025143929\r\n" + 
//				"    },\r\n" + 
//				"    {\r\n" + 
//				"        \"logmein_host_id\": null,\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"Lenovo\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:0D:3A:13:28:24\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 31,\r\n" + 
//				"        \"physicalmemory_GB\": 64.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"88900022378JU\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"192.168.44.2\",\r\n" + 
//				"        \"manufacturer\": \"Lenovo\",\r\n" + 
//				"        \"name\": \"KLAWNYFS.klawpc.com\",\r\n" + 
//				"        \"dns_name\": \"KLAWNYFS.klawpc.com\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"5.99.0000\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"Lenovo\",\r\n" + 
//				"        \"os\": \"Microsoft Windows Server 2012 \",\r\n" + 
//				"        \"unique_id\": 20161025144154\r\n" + 
//				"    }\r\n" + 
//				"]");
//		
//		ArrayList<String> b=returnKeysFromResponseBody("[\r\n" + 
//				"    {\r\n" + 
//				"        \"logmein_host_id\": null,\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"HP\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:0D:3A:70:96:4E\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 1,\r\n" + 
//				"        \"physicalmemory_GB\": 32.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"66S89LOMY2421\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"10.10.0.4\",\r\n" + 
//				"        \"manufacturer\": \"HP\",\r\n" + 
//				"        \"name\": \"AZR-FTP01\",\r\n" + 
//				"        \"dns_name\": \"AZR-FTP01.Tukuru.local\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"8.2.33.8\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"HP Priloant\",\r\n" + 
//				"        \"os\": \"Windows 2012-R2-Datacenter\",\r\n" + 
//				"        \"unique_id\": 20161025142616\r\n" + 
//				"    },\r\n" + 
//				"    {\r\n" + 
//				"        \"logmein_host_id\": null,\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"DELL\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:50:56:85:00:02\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 11,\r\n" + 
//				"        \"physicalmemory_GB\": 32.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"889QB3TMY454\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"10.2.31.8\",\r\n" + 
//				"        \"manufacturer\": \"DELL\",\r\n" + 
//				"        \"name\": \"APP27HGTR\",\r\n" + 
//				"        \"dns_name\": \"APP27HGTR.Tukuru.local\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"8.9.33.4\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"DELL\",\r\n" + 
//				"        \"os\": \"Windows Datacenter Server\",\r\n" + 
//				"        \"unique_id\": 2016102514370\r\n" + 
//				"    },\r\n" + 
//				"    {\r\n" + 
//				"        \"logmein_host_id\": null,\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"HP\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:50:99:85:20:02\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 21,\r\n" + 
//				"        \"physicalmemory_GB\": 64.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"UY77890OKT77\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"10.10.0.9\",\r\n" + 
//				"        \"manufacturer\": \"HP\",\r\n" + 
//				"        \"name\": \"FSBQQY65\",\r\n" + 
//				"        \"dns_name\": \"FSBQQY65tukuru.local\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"8.33.2.1B\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"HP\",\r\n" + 
//				"        \"os\": \"Microsoft Windows Server 2012 Datacenter\",\r\n" + 
//				"        \"unique_id\": 20161025143929\r\n" + 
//				"    },\r\n" + 
//				"    {\r\n" + 
//				"        \"logmein_host_id\": null,\r\n" + 
//				"        \"site_name\": null,\r\n" + 
//				"        \"city_id\": 0,\r\n" + 
//				"        \"service_name\": null,\r\n" + 
//				"        \"sysvendor\": \"Lenovo\",\r\n" + 
//				"        \"status_last_update\": 0,\r\n" + 
//				"        \"system_inventory\": null,\r\n" + 
//				"        \"anti_virus_details\": null,\r\n" + 
//				"        \"modified_date\": null,\r\n" + 
//				"        \"hardware_inventory\": null,\r\n" + 
//				"        \"biosname\": \"Phoenix\",\r\n" + 
//				"        \"deviceType\": \"Router\",\r\n" + 
//				"        \"mac_address\": \"00:0D:3A:13:28:24\",\r\n" + 
//				"        \"device_type_id\": 8,\r\n" + 
//				"        \"device_id\": 31,\r\n" + 
//				"        \"physicalmemory_GB\": 64.0,\r\n" + 
//				"        \"STATUS\": 2,\r\n" + 
//				"        \"activated\": 1,\r\n" + 
//				"        \"parent_type_id\": 39,\r\n" + 
//				"        \"serial_number\": \"88900022378JU\",\r\n" + 
//				"        \"path\": \"Network Device >> Router\",\r\n" + 
//				"        \"ipaddress\": \"192.168.44.2\",\r\n" + 
//				"        \"manufacturer\": \"Lenovo\",\r\n" + 
//				"        \"name\": \"KLAWNYFS.klawpc.com\",\r\n" + 
//				"        \"dns_name\": \"KLAWNYFS.klawpc.com\",\r\n" + 
//				"        \"org_id\": 571,\r\n" + 
//				"        \"bioversion\": \"5.99.0000\",\r\n" + 
//				"        \"created_date\": null,\r\n" + 
//				"        \"model\": \"Lenovo\",\r\n" + 
//				"        \"os\": \"Microsoft Windows Server 2012 \",\r\n" + 
//				"        \"unique_id\": 20161025144154\r\n" + 
//				"    }\r\n" + 
//				"]");
//		
//		if(compareKeys(a,b)) {
//			System.out.println("Success");
//		}else {
//			System.out.println("False");
//		}
//	}

}
