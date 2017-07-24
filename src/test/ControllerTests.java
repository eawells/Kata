package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vendingmachinekata.Coin;
import vendingmachinekata.Controller;
import vendingmachinekata.Product;
import vendingmachinekata.VendingMachineLiterals;

public class ControllerTests {
	
	private Controller control;
	
	@Before
	public void setUp(){
		control = new Controller();
	}
	
	@Test
	public void whenADimeIsInsertedTheDisplaySays10(){
		control.insertCoin(Coin.DIME);
		assertEquals("10",control.getDisplay());
	}
	
	@Test
	public void whenTwoDimesAreInsertedTheDisplaySays20(){
		control.insertCoin(Coin.DIME);
		control.insertCoin(Coin.DIME);
		assertEquals("20",control.getDisplay());
	}
	
	@Test 
	public void whenANickelIsInsertedTheDisplaySays5(){
		control.insertCoin(Coin.NICKEL);
		assertEquals("5",control.getDisplay());
	}
	
	@Test 
	public void whenTwoNickelsAreInsertedTheDisplaySays10(){
		control.insertCoin(Coin.NICKEL);
		control.insertCoin(Coin.NICKEL);
		assertEquals("10",control.getDisplay());
	}
	
	@Test 
	public void whenAQuarterIsInsertedTheDisplaySays25(){
		control.insertCoin(Coin.QUARTER);
		assertEquals("25",control.getDisplay());
	}
	
	@Test 
	public void whenTwoQuartersAreInsertedTheDisplaySays50(){
		control.insertCoin(Coin.NICKEL);
		control.insertCoin(Coin.NICKEL);
		assertEquals("10",control.getDisplay());
	}
	
	@Test
	public void whenANickelADimeAPennyAndAQuarterAreInsertedTheDisplaySays40(){
		control.insertCoin(Coin.NICKEL);
		control.insertCoin(Coin.DIME);
		control.insertCoin(Coin.PENNY);
		control.insertCoin(Coin.QUARTER);
		assertEquals("40",control.getDisplay());
	}
	
	@Test
	public void whenANickelADimeAPennyAndAQuarterAreInsertedTheMoneyAvailableIs40(){
		control.insertCoin(Coin.NICKEL);
		control.insertCoin(Coin.DIME);
		control.insertCoin(Coin.PENNY);
		control.insertCoin(Coin.QUARTER);
		assertEquals(40,control.getMoneyAvailable());
	}
	
	@Test
	public void whenAColaIsPurchasedWithADollarDisplaySaysTHANKYOU(){
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.selectItem(Product.COLA);
		assertEquals("THANK YOU",control.getDisplay());
	}
	
	@Test
	public void whenAColaIsSelectedWithoutEnoughMoneyDisplayGivesPrice(){
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.selectItem(Product.COLA);
		assertEquals("PRICE: " +VendingMachineLiterals.COLA_COST,control.getDisplay());
	}
	
	@Test
	public void whenAColaIsSelectedWithoutEnoughMoneySecondCheckToDisplayGivesMoneyAvailable(){
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.selectItem(Product.COLA);
		control.getDisplay();
		assertEquals("75",control.getDisplay());
	}
	
	@Test
	public void whenAColaIsSelectedWithoutAnyMoneySecondCheckToDisplayGivesInsertCoin(){
		control.selectItem(Product.COLA);
		control.getDisplay();
		assertEquals("INSERT COIN",control.getDisplay());
	}
		
	@Test
	public void whenACandyIsPurchasedWithADollarDisplaySaysTHANKYOU(){
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER); 
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.selectItem(Product.CANDY);
		assertEquals("THANK YOU",control.getDisplay());
	}
		
	@Test 
	public void whenCandyIsSelectedWithoutEnoughMoneyDisplayGivesPrice(){ 
		control.insertCoin(Coin.QUARTER); 
		control.selectItem(Product.CANDY); 
		assertEquals("PRICE: " +VendingMachineLiterals.CANDY_COST,control.getDisplay()); 
	} 
	
	@Test
	public void whenACandyIsSelectedWithoutEnoughMoneySecondCheckToDisplayGivesMoneyAvailable(){
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.selectItem(Product.CANDY);
		control.getDisplay();
		assertEquals("50",control.getDisplay());
	}
	
	@Test
	public void whenACandyIsSelectedWithoutAnyMoneySecondCheckToDisplayGivesInsertCoin(){
		control.selectItem(Product.CANDY);
		control.getDisplay();
		assertEquals("INSERT COIN",control.getDisplay());
	}
	
	@Test
	public void whenChipsArePurchasedWithADollarDisplaySaysTHANKYOU(){
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER); 
		control.insertCoin(Coin.QUARTER);
		control.insertCoin(Coin.QUARTER);
		control.selectItem(Product.CHIPS);
		assertEquals("THANK YOU",control.getDisplay());
	}
		
	@Test 
	public void whenChipsAreSelectedWithoutEnoughMoneyDisplayGivesPrice(){ 
		control.insertCoin(Coin.QUARTER); 
		control.selectItem(Product.CHIPS); 
		assertEquals("PRICE: " +VendingMachineLiterals.CHIPS_COST,control.getDisplay()); 
	} 
	
	@Test
	public void whenChipsAreSelectedWithoutEnoughMoneySecondCheckToDisplayGivesMoneyAvailable(){
		control.insertCoin(Coin.QUARTER);
		control.selectItem(Product.CHIPS);
		control.getDisplay();
		assertEquals("25",control.getDisplay());
	}
	
	@Test
	public void whenChipsAreSelectedWithoutAnyMoneySecondCheckToDisplayGivesInsertCoin(){
		control.selectItem(Product.CHIPS);
		control.getDisplay();
		assertEquals("INSERT COIN",control.getDisplay());
	}
	
	@Test
	public void whenReturnCoinsIsPressedDisplayIsInsertCoin(){
		control.insertCoin(Coin.DIME);
		control.returnCoins();
		assertEquals("INSERT COIN",control.getDisplay());
	}
	
	@Test 
	public void whenReturnCoinsIsPressedMoneyAvailableIs0(){ 
		control.insertCoin(Coin.DIME); 
		control.returnCoins(); 
		assertEquals(0, control.getMoneyAvailable()); 
	}
	
}
