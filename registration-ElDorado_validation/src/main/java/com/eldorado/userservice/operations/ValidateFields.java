package com.eldorado.userservice.operations;

//import java.util.regex.Pattern;
import java.util.regex.*;

import com.eldorado.userservice.exception.EmptyFieldException;
import com.eldorado.userservice.exception.InvalidDataException;

import java.util.*;

public class ValidateFields {
	
	public static boolean validateUsername(String username) throws EmptyFieldException, InvalidDataException
	{	// validating email
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(username);
		
		if(username==null|| username.equals(""))
			throw new EmptyFieldException("username cannot be empty");
		if(matcher.matches()==false)
			throw new InvalidDataException("username should only contain alphabets, numbers or special characters .,_,- ");
	
		return true;
	}

	public static boolean validatePassword(String password) throws EmptyFieldException, InvalidDataException
	{
		String PASSWORD_PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		
		if(password==null|| password.equals(""))
			throw new EmptyFieldException("password cannot be empty");
		if(matcher.matches()==false)
			throw new InvalidDataException("password should only contain atleast one lowercase character, one uppercase character, one digit, one special character, and length between 8 to 20.");		
		
		return true;
	}
	
}
