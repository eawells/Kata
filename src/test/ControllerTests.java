package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vendingmachinekata.Coin;
import vendingmachinekata.Controller;

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
		control.selectItem("A1");
		assertEquals("THANK YOU",control.getDisplay());
	}
	
}
