package com.platzi.java.tests.payments;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class PaymentProcessorTest {

	@Test
	public void paymentIsCorrect() {
		
		PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
		Mockito.when(paymentGateway.requestPayment(new PaymentRequest(Mockito.anyDouble()))).
			thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
		
		PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
		
		assertTrue(paymentProcessor.makePayment(1000));
	}

}
