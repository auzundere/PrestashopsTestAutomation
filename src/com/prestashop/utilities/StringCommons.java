package com.prestashop.utilities;

public class StringCommons {

	public static void main(String[] args) {
		
		extractNumberFromString("Cybertek003Tech112ABC");
		extractNumberFromString("Call us now: 0123-456-789");
		

	}


	public static String extractNumberFromString(String targetString){
		
		//String employeeID = "Cybertek003Tech112ABC";
		String onlyNumber = ""; 
		for (int i = 0; i < targetString.length(); i++) {
			
			char eachChar = targetString.charAt(i);
			
			if( Character.isDigit(eachChar)){
				//System.out.println(eachChar);
				onlyNumber = onlyNumber + eachChar;  //onlyNumber+=eachChar ;
			}
		}
		System.out.println(onlyNumber);
		
		return onlyNumber; 
	}


}

