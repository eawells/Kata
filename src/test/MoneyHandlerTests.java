package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vendingmachinekata.Coin;
import vendingmachinekata.MoneyHandler;
import vendingmachinekata.Product;
import vendingmachinekata.VendingMachineLiterals;

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
		
	@Test
	public void whenAColaIsPurchasedTheMoneyAvailableIs0(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.COLA);
		assertEquals(0,mh.getMoneyAvailable());
	}	
	
	@Test
	public void whenCandyIsPurchasedTheMoneyAvailableIs0(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CANDY);
		assertEquals(0,mh.getMoneyAvailable());
	}	
	
	
}
