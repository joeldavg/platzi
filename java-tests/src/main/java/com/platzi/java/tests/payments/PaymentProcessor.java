package com.platzi.java.tests.payments;

public class PaymentProcessor {
	
	private PaymentGateway paymentGateway;
	
	public PaymentProcessor(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public boolean makePayment(double amout) {
		
		PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amout));
		if (response.getStatus().equals(PaymentResponse.PaymentStatus.OK)) {
			return true;

		} else {

			return false;
		}
	}
	
}
