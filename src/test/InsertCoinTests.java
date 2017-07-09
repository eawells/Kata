package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vendingmachinekata.Coin;
import vendingmachinekata.VendingMachine;

public class InsertCoinTests {
	
	VendingMachine vendingMachine;
	
//	@Before
//	public void setUp(){
//		VendingMachine vendingMachine = new VendingMachine();
//	}
	
	@Test
	public void whenNoCoinIsInsertedDisplaySaysINSERTCOIN(){
		VendingMachine vendingMachine = new VendingMachine();
		assertEquals("INSERT COIN", vendingMachine.getDisplay());
	}
	
	@Test
	public void whenAPennyIsInsertedDisplayDoesNotChange(){
		VendingMachine vendingMachine = new VendingMachine();
		String display = vendingMachine.getDisplay();
		vendingMachine.insertCoin(Coin.PENNY);
		assertEquals(display, vendingMachine.getDisplay());
	}
	
	@Test
	public void whenAPennyIsInsertedCoinReturnValueIsPlus1(){
		VendingMachine vendingMachine = new VendingMachine();
		int coinReturn = vendingMachine.getCoinReturnValue();
		vendingMachine.insertCoin(Coin.PENNY);
		assertEquals(coinReturn+1, vendingMachine.getCoinReturnValue());
	}
	
}
