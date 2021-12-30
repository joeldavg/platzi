package com.platzi.java.tests.payments;

public interface PaymentGateway {
	
	PaymentResponse requestPayment(PaymentRequest request);
	
}
