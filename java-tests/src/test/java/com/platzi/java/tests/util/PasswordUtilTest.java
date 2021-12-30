package com.platzi.java.tests.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordUtilTest {

	@Test
	public void weakWhenHasLessThan8Letters() {
		assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("1234567"));
	}
	
	@Test
	public void weakWhenHasOnlyLetters() {
		assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("abcdefgh"));
	}
	
	@Test
	public void mediumWhenHasLettersAndNumbers() {
		assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("abcd1234"));
	}

	@Test
	public void strongWhenHasLettersNumbersAndSymbols() {
		assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("abcd1234"));
	}

}
