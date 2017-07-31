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
	
	@Test
	public void whenChipsArePurchasedTheMoneyAvailableIs0(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS);
		assertEquals(0,mh.getMoneyAvailable());
	}	
	
	@Test
	public void whenAProductIsPurchasedWith25CentsExtraCoinReturnHas25(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS);
		assertEquals(25,mh.getCoinReturnValue());
	}
	
	@Test
	public void whenTheCoinReturnValueIs25ThereIsAQuarterInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS);
		assertEquals("1 quarter(s). ",mh.getCoinsInCoinReturn());
	}
	
	@Test
	public void whenTheCoinReturnValueIs10ThereIsADimeInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.DIME);
		mh.selectItem(Product.CHIPS);
		assertEquals("1 dime(s). ",mh.getCoinsInCoinReturn());
	}
	
	@Test
	public void whenTheCoinReturnValueIs5ThereIsANickelInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.NICKEL);
		mh.selectItem(Product.CHIPS);
		assertEquals("1 nickel(s). ",mh.getCoinsInCoinReturn());
	}
	
	@Test
	public void whenTheCoinReturnValueIs1ThereIsAPennyInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.PENNY);
		mh.selectItem(Product.CHIPS);
		assertEquals("1 penny(s). ",mh.getCoinsInCoinReturn());
	}
	
	@Test
	public void whenTheCoinReturnValueIs41ThereIsOneOfEachCoin(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.PENNY);
		mh.selectItem(Product.CHIPS);
		assertEquals("1 quarter(s). 1 dime(s). 1 nickel(s). 1 penny(s). ",mh.getCoinsInCoinReturn());
	}
	
	@Test
	public void whenReturnCoinsIsPressedMoneyAvailableIs0(){
		mh.insertCoin(Coin.DIME);
		mh.returnCoins();
		assertEquals(0, mh.getMoneyAvailable());
	}
	
	@Test
	public void whenReturnCoinsIsPressedWithADimeCoinReturnValueIs10(){
		mh.insertCoin(Coin.DIME);
		mh.returnCoins();
		assertEquals(10, mh.getCoinReturnValue());
	}
	
	@Test
	public void whenReturnCoinsIsPressedWith25CentsThereIsAQuarterInCoinReturn(){
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.NICKEL);
		mh.returnCoins();
		assertEquals("1 quarter(s). ", mh.getCoinsInCoinReturn());
	}
	
	@Test
	public void whenNoCoinsHaveBeenInsertedCoinsInMachineIsNone(){
		assertEquals("None", mh.getCoinsInMachine());
	}
	
	@Test
	public void whenAQuaterIsInsertedCoinsInMachineIsQuarter(){
		mh.insertCoin(Coin.QUARTER);
		assertEquals("1 quarter(s). ", mh.getCoinsInMachine());
	}
	
	@Test
	public void whenADimeIsInsertedCoinsInMachineIsDime(){
		mh.insertCoin(Coin.DIME);
		assertEquals("1 dime(s). ", mh.getCoinsInMachine());
	}
	
	@Test
	public void whenANickelIsInsertedCoinsInMachineIsNickel(){
		mh.insertCoin(Coin.NICKEL);
		assertEquals("1 nickel(s). ", mh.getCoinsInMachine());
	}
	
	@Test
	public void whenAQuarterGoesToTheCoinReturnItIsNoLongerInMachine(){
		mh.insertCoin(Coin.QUARTER);
		mh.returnCoins();
		mh.getCoinsInCoinReturn();
		assertEquals("None", mh.getCoinsInMachine());
	}
	
	@Test
	public void whenAQuarterInChangeIsGivenItIsNoLongerInMachine(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS);
		mh.getCoinsInCoinReturn();
		assertEquals("2 quarter(s). ", mh.getCoinsInMachine());
	}
	
	@Test 
	public void whenADimeGoesToTheCoinReturnItIsNoLongerInMachine(){
		mh.insertCoin(Coin.DIME);
		mh.returnCoins();
		mh.getCoinsInCoinReturn();
		assertEquals("None", mh.getCoinsInMachine());
	}
	
}
