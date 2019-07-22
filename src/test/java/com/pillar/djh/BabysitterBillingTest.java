package com.pillar.djh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for Babysitter Billing App.
 */
public class BabysitterBillingTest 
{
    /**
     * 
     */
    @Test
    public void workedNoHoursGetNoPay() {
    	BabysitterBilling bb = new BabysitterBilling();
    	
    	assertEquals(0, bb.totalPay(5,5,'A'));
    }
    
}    