package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vendingmachinekata.Coin;
import vendingmachinekata.MoneyHandler;

public class MoneyHandlerTests {
		
	MoneyHandler mh;
	@Before
	public void setUp(){
		mh = new MoneyHandler();
	}
	
	@Test
	public void whenAPennyIsInsertedCoinReturnValueIsPlus1(){
		int coinReturn = mh.getCoinReturnValue();
		mh.insertCoin(Coin.PENNY);
		assertEquals(coinReturn+1, mh.getCoinReturnValue());
	}
	
	@Test
	public void whenADimeIsInsertedMoneyThatCanBeUsedToBuyIsIncreasedBy10(){
		int money = mh.getMoneyThatCanBeUsedToBuy();
		mh.insertCoin(Coin.DIME);
		assertEquals(money+10, mh.getMoneyThatCanBeUsedToBuy());
		}
	
	
		
}
