package com.redhat.shipping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingCalculatorTest {


	@Test
	public void onLATAMRegionTheCostIs200() {
		// Given a shipping calculator
		 ShippingCalculator calculator = new ShippingCalculator();
		// // When LATAM is the country region
		 int calculatedCost = calculator.costForRegion("LATAM");
		// // Then the shipping cost is 200
		 assertEquals(200, calculatedCost);
		}

	@Test
	public void onEMEARegionTheCostIs300() {
		// Given a shipping calculator
		ShippingCalculator calculator = new ShippingCalculator();
		// // When EMEA is the country region
		int calculatedCost = calculator.costForRegion("EMEA");	
		assertEquals(300, calculatedCost);
	}
}
