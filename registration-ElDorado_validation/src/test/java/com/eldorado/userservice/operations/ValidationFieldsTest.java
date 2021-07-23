package com.eldorado.userservice.operations;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.eldorado.userservice.operations.ValidateFields.*;

import com.eldorado.userservice.exception.EmptyFieldException;
import com.eldorado.userservice.exception.InvalidDataException;


public class ValidationFieldsTest {

	@Test
	public void usernameNull()
	{
		Executable executable = ()-> validateUsername(null);
		assertThrows(EmptyFieldException.class, executable);
	}
	
	@Test
	public void passwordNull()
	{
		Executable executable = ()-> validatePassword(null);
		assertThrows(EmptyFieldException.class, executable);
	}
	
	@Test
	public void usernameEmpty()
	{
		Executable executable = ()-> validateUsername("");
		assertThrows(EmptyFieldException.class, executable);
	}
	
	@Test
	public void passwordEmpty()
	{
		Executable executable = ()-> validatePassword("");
		assertThrows(EmptyFieldException.class, executable);
	}
	
	@Test
	public void passwordTooLong()
	{
		Executable executable = ()-> validatePassword("0123456789$abcdefgAB123456789");
		assertThrows(InvalidDataException.class, executable);
	}
	
	@Test
	public void usernameCharactersNotAllowed() 
	{
		Executable executable = ()-> validateUsername("ab#c@gmail.com");
		assertThrows(InvalidDataException.class, executable);
	}
	
	@Test
	public void usernameInitialCharactersMissing() 
	{
		Executable executable = ()-> validateUsername("@gmail.com");
		assertThrows(InvalidDataException.class, executable);
	}
	
	@Test
	public void usernameCorrect() throws EmptyFieldException, InvalidDataException 
	{ // providing correct email
		try {
		assertTrue(validateUsername("abc@gmail.com"));
		}
		catch(EmptyFieldException e) 
		{
			System.out.println("Empty field");
		}
		catch(InvalidDataException e) 
		{
			System.out.println("Invalid field");
		}
	}
	
	@Test
	public void passwordSpecialCharacterMissing() 
	{
		Executable executable = ()-> validatePassword("java REGEX 123");
		assertThrows(InvalidDataException.class, executable);
	}
	
	@Test
	public void passwordTooShort() 
	{
		Executable executable = ()-> validatePassword("Aojo@");
		assertThrows(InvalidDataException.class, executable);
	}
	
	@Test
	public void passwordCorrect() throws EmptyFieldException, InvalidDataException 
	{ // providing correct password
		try {
		assertTrue(validatePassword("abc@123A23"));
		}
		catch(EmptyFieldException e) 
		{
			System.out.println("Empty field");
		}
		catch(InvalidDataException e) 
		{
			System.out.println("Invalid field");
		}
	}	
	
	
	
}
