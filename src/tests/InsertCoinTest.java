package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vendingmachine.VendingMachine;

public class InsertCoinTest {
	
	@Test
	public void whenNoCoinIsInsertedDisplaySaysINSERTCOIN(){
		VendingMachine vendingMachine = new VendingMachine();
		assertEquals("INSERT COIN", vendingMachine.getDisplay());
	}
}
