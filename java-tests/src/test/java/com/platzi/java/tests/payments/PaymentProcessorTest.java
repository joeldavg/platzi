package com.platzi.java.tests.payments;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.platzi.java.tests.payments.PaymentResponse.PaymentStatus;

public class PaymentProcessorTest {
	
	private PaymentGateway paymentGateway;
	private PaymentProcessor paymentProcessor;
	
	@Before
	public void setup() {
		paymentGateway = Mockito.mock(PaymentGateway.class);
		paymentProcessor = new PaymentProcessor(paymentGateway);
	}
	
	@Test
	public void paymentIsCorrect() {
		
		Mockito.when(paymentGateway.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentStatus.OK));
		
		assertTrue(paymentProcessor.makePayment(1000));
	}
	
	@Test
	public void paymentIsIncorrect() {
		
		Mockito.when(paymentGateway.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentStatus.ERROR));
		
		assertFalse(paymentProcessor.makePayment(1000));
	}

}
