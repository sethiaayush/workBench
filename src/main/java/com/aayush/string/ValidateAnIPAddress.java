package com.aayush.string;

public class ValidateAnIPAddress {
	//According to Wikipedia, IPv4 addresses are canonically represented in dot-decimal notation, 
	//which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1 . 
	//The generalized form of an IPv4 address is (0-255).(0-255).(0-255).(0-255). Here we are considering 
	//numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.
	
	public static void main(String[] args) {
		String ipAddress = "222.111.111.111";
		String ipAddress1 = "5555..555";
		String ipAddress2 = "aaa.111.111.111";
		String ipAddress3 = "00.00.00.00";
		String ipAddress4 = "001.1.1.1";
		String ipAddress5 = "172.16.254.01";
		String ipAddress6 = "0.0.0.0.";
		
		
		/*System.out.println(isValid(ipAddress));
		System.out.println(isValid(ipAddress1));
		System.out.println(isValid(ipAddress2));
		System.out.println(isValid(ipAddress3));
		System.out.println(isValid(ipAddress4));
		System.out.println(isValid(ipAddress5));*/
		System.out.println(isValid(ipAddress6));
	}
	
	
	public static boolean isValid(String s) {
		
		if(s==null || s.isEmpty()) {
			return false;
		}
		//validate it contains 3 dots
		//validate 4 values for range 0-255
		//validate 
		String[] splitByDot = s.split("\\.");
		int count = 0;
		 
		for (int i = 0; i < s.length(); i++) {
		    if (s.charAt(i) == '.') {
		        count++;
		    }
		}
		if(count!=3) {
			return false;
		}
		if(splitByDot.length != 4) {
			return false;
		}
		
		for(String single : splitByDot) {
			//check if single has all numbers if yes cast to number and check the value
			if(single.matches("^\\d{1,3}$")) {
				
				Integer singleNumber = Integer.valueOf(single);
				if(single.split(singleNumber.toString()).length>0) {
					return false;
				}
				if(singleNumber>=0 && singleNumber<=255) {
					
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		
		return true;
		
    }
}
