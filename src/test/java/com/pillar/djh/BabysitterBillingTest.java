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
     * Test that a zero (0) is returned if no hours were worked (start hour equal to stop hour).
     */
    @Test
    public void workedNoHoursGetNoPay() {
    	
    	assertEquals(0, bb.totalPay(5,5,'A'));
    }
    
    /*
     * Test that a RANGE_ERROR is returned if the start/stop hours are out of range. 
     */
    @Test
    public void validateStartStopHour() {
    	
    	assertEquals(BabysitterBilling.RANGE_ERROR, bb.totalPay(4, 5, 'A'));
    	assertEquals(BabysitterBilling.RANGE_ERROR, bb.totalPay(-1, 5, 'A'));
    	assertEquals(BabysitterBilling.RANGE_ERROR, bb.totalPay(5, 13, 'A'));
    	assertEquals(BabysitterBilling.RANGE_ERROR, bb.totalPay(0, 0, 'A'));
    	assertEquals(BabysitterBilling.RANGE_ERROR, bb.totalPay(12, 14, 'A'));    	
    }
    
    /*
     * Test that a START_STOP_ERROR is returned if the start hour is greater 
     * chronologically than the stop hour. 
     */
    @Test
    public void validateStartHourLessThanStopHour() {
    	
    	assertEquals(BabysitterBilling.START_STOP_ERROR, bb.totalPay(6, 5, 'A'));
    	assertEquals(BabysitterBilling.START_STOP_ERROR, bb.totalPay(1, 12, 'A'));
    	assertEquals(BabysitterBilling.START_STOP_ERROR, bb.totalPay(2, 1, 'A'));
    	
    }
    
    /*
     * Test that a FAMILY_ID_ERROR is returned if the Family ID id not valid. 
     */
    @Test
    public void validateFamilyID() {
    	
    	assertEquals(BabysitterBilling.FAMILY_ID_ERROR, bb.totalPay(5, 6, 'X'));
    	assertEquals(BabysitterBilling.FAMILY_ID_ERROR, bb.totalPay(5, 6, '1'));
    	assertEquals(BabysitterBilling.FAMILY_ID_ERROR, bb.totalPay(5, 6, '!'));
    	
    }
    
    /*
     * Test that Babysitter is paid properly when working for Family 'A'.
     */
    @Test
    public void validateFamilyAPayment() {
    	
    	assertEquals(15, bb.totalPay(10, 11, 'A'));		//15
    	assertEquals(90, bb.totalPay(9, 2, 'A'));  		//15+15+20+20+20
    	assertEquals(60, bb.totalPay(1, 4, 'A'));		//20+20+20
    	assertEquals(190, bb.totalPay(5, 4, 'A'));		//6*15+5*20
    	
    }

    /*
     * Test that Babysitter is paid properly when working for Family 'B.
     */
    @Test
    public void validateFamilyBPayment() {
    	
    	assertEquals(12, bb.totalPay(9, 10, 'B'));		//12
    	assertEquals(60, bb.totalPay(9, 2, 'B'));  		//12+8+8+16+16
    	assertEquals(48, bb.totalPay(1, 4, 'B'));		//3*16
    	assertEquals(140, bb.totalPay(5, 4, 'B'));		//5*12+2*8+4*16
    	
    }
    
}    