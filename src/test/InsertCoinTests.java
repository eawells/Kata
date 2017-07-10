package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vendingmachinekata.Coin;
import vendingmachinekata.Display;
import vendingmachinekata.MoneyHandler;
import vendingmachinekata.VendingMachine;

public class InsertCoinTests {
	
	@Test
	public void whenNoCoinIsInsertedDisplaySaysINSERTCOIN(){
		Display display = new Display();
		assertEquals("INSERT COIN", display.getDisplay());
	}
	
	@Test
	public void whenAPennyIsInsertedDisplayDoesNotChange(){
		Display display = new Display();
		MoneyHandler mh = new MoneyHandler();
		String displ = display.getDisplay();
		mh.insertCoin(Coin.PENNY);
		assertEquals(displ, display.getDisplay());
	}
	
	@Test
	public void whenAPennyIsInsertedCoinReturnValueIsPlus1(){
		MoneyHandler mh = new MoneyHandler();
		int coinReturn = mh.getCoinReturnValue();
		mh.insertCoin(Coin.PENNY);
		assertEquals(coinReturn+1, mh.getCoinReturnValue());
	}
	
}
