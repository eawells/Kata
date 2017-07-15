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
		int money = mh.getMoneyAvailable();
		mh.insertCoin(Coin.DIME);
		assertEquals(money+10, mh.getMoneyAvailable());
		}
	
	@Test
	public void whenANickelIsInsertedMoneyThatCanBeUsedToBuyIsIncreasedBy5(){
		int money = mh.getMoneyAvailable();
		mh.insertCoin(Coin.NICKEL);
		assertEquals(money+5, mh.getMoneyAvailable());
		}
	
	@Test
	public void whenAQuarterIsInsertedMoneyThatCanBeUsedToBuyIsIncreasedBy25(){
		int money = mh.getMoneyAvailable();
		mh.insertCoin(Coin.QUARTER);
		assertEquals(money+25, mh.getMoneyAvailable());
		}


	
		
}
