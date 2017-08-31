package main.java.vendingmachinekata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
		mh.selectItem(Product.COLA,10);
		assertEquals(0,mh.getMoneyAvailable());
	}	
	
	@Test
	public void whenCandyIsPurchasedTheMoneyAvailableIs0(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CANDY,10);
		assertEquals(0,mh.getMoneyAvailable());
	}	
	
	@Test
	public void whenChipsArePurchasedTheMoneyAvailableIs0(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS,10);
		assertEquals(0,mh.getMoneyAvailable());
	}	
	
	@Test
	public void whenAProductIsPurchasedWith25CentsExtraCoinReturnHas25(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS,10);
		assertEquals(25,mh.getCoinReturnValue());
	}
	
	@Test
	public void whenTheCoinReturnValueIs25ThereIsAQuarterInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS,10);
		int[] coins = mh.dispenseCoinstoCoinReturn();
		assertEquals(1,coins[0]);
	}
	
	@Test
	public void whenTheCoinReturnValueIs10ThereIsADimeInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.DIME);
		mh.selectItem(Product.CHIPS,10);
		int[] coins = mh.dispenseCoinstoCoinReturn();
		assertEquals(1,coins[1]);
	}
	
	@Test
	public void whenTheCoinReturnValueIs5ThereIsANickelInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.NICKEL);
		mh.selectItem(Product.CHIPS,10);
		int[] coins = mh.dispenseCoinstoCoinReturn();
		assertEquals(1,coins[2]);
	}
	
	@Test
	public void whenTheCoinReturnValueIs1ThereIsAPennyInTheCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.PENNY);
		mh.selectItem(Product.CHIPS,10);
		int[] coins = mh.dispenseCoinstoCoinReturn();
		assertEquals(1,coins[3]);
	}
	
	@Test
	public void whenTheCoinReturnValueIs41ThereIsOneOfEachCoin(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.NICKEL);
		mh.insertCoin(Coin.NICKEL);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.PENNY);
		mh.selectItem(Product.CHIPS,10);
		int[] coins = mh.dispenseCoinstoCoinReturn();
		int quarter =coins[0]; 
		int dime = coins[1]; 
		int nickel = coins[2]; 
		int penny = coins[3]; 
		assertEquals("1q.1d.1n.1p.",quarter+"q."+dime+"d."+nickel+"n."+penny+"p.");
	}
	
	@Test
	public void whenReturnCoinsIsPressedMoneyAvailableIs0(){
		mh.insertCoin(Coin.DIME);
		mh.pressReturnCoins();
		assertEquals(0, mh.getMoneyAvailable());
	}
	
	@Test
	public void whenReturnCoinsIsPressedWithADimeCoinReturnValueIs10(){
		mh.insertCoin(Coin.DIME);
		mh.pressReturnCoins();
		assertEquals(10, mh.getCoinReturnValue());
	}
	
	@Test
	public void whenReturnCoinsIsPressedWith25CentsThereIsAQuarterInCoinReturn(){
		mh.insertCoin(Coin.QUARTER);
		mh.pressReturnCoins();
		int[] coins = mh.dispenseCoinstoCoinReturn();
		assertEquals(1, coins[0]);
	}
	
	@Test
	public void whenNoCoinsHaveBeenInsertedQuartersInMachineIsZero(){
		assertEquals(0, mh.getCoinsInMachine()[0]);
	}
	
	@Test
	public void whenNoCoinsHaveBeenInsertedDimesInMachineIsZero(){
		assertEquals(0, mh.getCoinsInMachine()[1]);
	}
	
	@Test
	public void whenNoCoinsHaveBeenInsertedNickelsInMachineIsZero(){
		assertEquals(0, mh.getCoinsInMachine()[2]);
	}
	
	@Test
	public void whenAQuaterIsInsertedCoinsInMachineIsQuarter(){
		mh.insertCoin(Coin.QUARTER);
		assertEquals(1, mh.getCoinsInMachine()[0]);
	}
	
	@Test
	public void whenADimeIsInsertedCoinsInMachineIsDime(){
		mh.insertCoin(Coin.DIME);
		assertEquals(1, mh.getCoinsInMachine()[1]);
	}
	
	@Test
	public void whenANickelIsInsertedCoinsInMachineIsNickel(){
		mh.insertCoin(Coin.NICKEL);
		assertEquals(1, mh.getCoinsInMachine()[2]);
	}
	
	@Test
	public void whenAQuarterGoesToTheCoinReturnItIsNoLongerInMachine(){
		mh.insertCoin(Coin.QUARTER);
		mh.pressReturnCoins();
		mh.dispenseCoinstoCoinReturn();
		assertEquals(0, mh.getCoinsInMachine()[0]);
	}
	
	@Test
	public void whenAQuarterInChangeIsGivenItIsNoLongerInMachine(){
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.insertCoin(Coin.QUARTER);
		mh.selectItem(Product.CHIPS,10);
		mh.dispenseCoinstoCoinReturn();
		assertEquals(2, mh.getCoinsInMachine()[0]);
	}
	
	@Test 
	public void whenADimeGoesToTheCoinReturnItIsNoLongerInMachine(){
		mh.insertCoin(Coin.DIME);
		mh.pressReturnCoins();
		mh.dispenseCoinstoCoinReturn();
		assertEquals(0, mh.getCoinsInMachine()[1]);
	}
	
	@Test 
	public void whenANickelGoesToTheCoinReturnItIsNoLongerInMachine(){
		mh.insertCoin(Coin.NICKEL);
		mh.pressReturnCoins();
		mh.dispenseCoinstoCoinReturn();
		assertEquals(0, mh.getCoinsInMachine()[2]);
	}
	
	@Test
	public void whenOnlyNickelsAreAvailableMachineOnlyGivesNickels(){
		mh.insertCoin(Coin.NICKEL);
		mh.insertCoin(Coin.NICKEL);
		mh.pressReturnCoins();
		int[] coins = mh.dispenseCoinstoCoinReturn();
		assertEquals(2, coins[2]);
	}
	
	@Test
	public void whenNoCoinsHaveBeenInsertedChangeCannotBeMade(){
		assertEquals(false, mh.changeCanBeMade());
	}
	
	@Test
	public void when2DimesAndANickelAreInTheMachineChangeCanBeMade(){
		mh.insertCoin(Coin.NICKEL);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.DIME);
		assertEquals(true, mh.changeCanBeMade());
	}
	
	@Test
	public void whenANickelADimeAPennyAndAQuarterAreInsertedTheMoneyAvailableIs40(){
		mh.insertCoin(Coin.NICKEL);
		mh.insertCoin(Coin.DIME);
		mh.insertCoin(Coin.PENNY);
		mh.insertCoin(Coin.QUARTER);
		assertEquals(40,mh.getMoneyAvailable());
	}

}
