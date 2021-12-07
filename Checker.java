import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checker {
	
	public static void main(String[] args) {
		
		String uen = "";
		System.out.println("Enter a UEN for verification: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			uen = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		if (isUENValid(uen)) {
			System.out.println("This UEN is valid");
		} else {
			System.out.println("This UEN is invalid");
		}
		
	}
	
	public static boolean isUENValid(String uen) {
		
		uen = uen.toUpperCase();
		char[] number = new char[uen.length()];
		
		// check for length of string
		if (uen.length() < 9 || uen.length() > 10) {
			return false;
		}
		
		// copy string to character array
		for (int i = 0; i < uen.length(); i++) {
			number[i] = uen.charAt(i);
		}
		
		// path for uen of length 9. category A
		if (uen.length() == 9) {
			// check if first 8 characters are digits
			for (int i = 0; i < uen.length() - 1; i++) {
				if (!isNumber(number[i])) {
					return false;
				}
			}
			
			// check if last character is a letter
			if (!isLetter(number[uen.length() - 1])) {
				return false;
			}
		}
		
		// path for uen of length 10
		if (uen.length() == 10) {
			
			// if first character is a number. category B
			if (isNumber(number[0])) {
				
				// check if the following 8 characters are numbers
				for (int i = 1; i < uen.length() - 1; i++) {
					if (!isNumber(number[i])) {
						return false;
					}
				}
				
				// check if the first 4 numbers represent a valid year. assume 
				// that anything more than 1000 and less than current year is valid
				int year = Integer.parseInt(uen.substring(0, 4));
				int todayYear;
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();
				
				todayYear = now.getYear();
				
				if (year < 1000 || year > todayYear) {
					return false;
				}
				
			} else if (!isLetter(number[0])) {
				// this means the first character is neither a number nor letter
				return false;
			} else {
				// this is category C
				
				// check if next two numbers are actually numbers
				for (int i = 1; i < 3; i++) {
					if (!isNumber(number[i])) {
						return false;
					}
				}
				
				// check if the two letters are a valid agency
				if (!isAgency(uen.substring(3, 5))) {
					return false;
				}
				
				// check if sixth to ninth numbers are actually numbers
				for (int i = 5; i < 8; i++) {
					if (!isNumber(number[i])) {
						return false;
					}
				}
			}
			
		}
		
		return true;
	}
	
	// function for checking if a character is a number
	public static boolean isNumber(char character) {
		if (Character.isDigit(character)) {
			return true;
		} else {
			return false;
		}
	}
	
	// function for checking if a character is a letter
	public static boolean isLetter(char character) {
		if (Character.isAlphabetic(character)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isAgency(String letters) {		
		switch(letters) {
			case "LP":
				break;
			case "LL":
				break;
			case "FC":
				break;
			case "PF":
				break;
			case "RF":
				break;
			case "MQ":
				break;
			case "MM":
				break;
			case "NB":
				break;
			case "CC":
				break;
			case "CS":
				break;
			case "MB":
				break;
			case "FM":
				break;
			case "GS":
				break;
			case "DP":
				break;
			case "CP":
				break;
			case "NR":
				break;
			case "CM":
				break;
			case "CD":
				break;
			case "MD":
				break;
			case "HS":
				break;
			case "VH":
				break;
			case "CH":
				break;
			case "MH":
				break;
			case "CL":
				break;
			case "XL":
				break;
			case "CX":
				break;
			case "RP":
				break;
			case "TU":
				break;
			case "TC":
				break;
			case "FB":
				break;
			case "FN":
				break;
			case "PA":
				break;
			case "PB":
				break;
			case "SS":
				break;
			case "MC":
				break;
			case "SM":
				break;
			case "GA":
				break;
			case "GB":
				break;
			default:
				return false;
		}
		
		return true;
	}
}
