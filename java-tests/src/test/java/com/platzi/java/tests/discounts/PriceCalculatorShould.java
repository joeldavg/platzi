package com.platzi.java.tests.discounts;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class PriceCalculatorShould {

	@Test
	public void totalZeroThereAreNotPrice() {
		PriceCalculator calculator = new PriceCalculator();
		
		assertThat(calculator.getTotal(), CoreMatchers.is(0.0));
	}
	
	@Test
	public void totalIsTheSumOfPrice() {
		PriceCalculator calculator = new PriceCalculator();
	
		calculator.addPrice(10.2);
		calculator.addPrice(15.5);
		
		assertThat(calculator.getTotal(), CoreMatchers.is(25.7));
	}
	
	@Test
	public void applyDiscountToPrices() {
		PriceCalculator calculator = new PriceCalculator();
		
		calculator.addPrice(100);
		calculator.addPrice(50);
		calculator.addPrice(50);
		
		calculator.setDiscount(25);
		
		assertThat(calculator.getTotal(), CoreMatchers.is(150.0));
	}
	
	
	
}
