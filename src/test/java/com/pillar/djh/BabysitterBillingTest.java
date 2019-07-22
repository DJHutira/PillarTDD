package com.pillar.djh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Babysitter Billing App.
 */
public class BabysitterBillingTest 
{
	BabysitterBilling bb;
	
	@Before
	public void init() {
		bb = new BabysitterBilling();
	}
	
    /*
     * Test that a zero (0) is returned if no hours were worked (Start hour equal to Stop hour).
     */
    @Test
    public void workedNoHoursGetNoPay() {
    	
    	assertEquals(0, bb.totalPay(5,5,'A'));
    }
    
    /*
     * Test that a negative one (-1) is returned if the start hour is out of range. 
     */
    @Test
    public void validateStartHour() {
    	
    	assertEquals(-1, bb.totalPay(4, 5, 'A'));
    	
    }
    
}    