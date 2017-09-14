package main.java.vendingmachinekata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestsForMain {
	
	VendingMachine vm;
	
	@Before
	public void setUp(){
		vm = new VendingMachine();
	}
	@Test
	public void displayOptionsReturnsOptions(){
		assertEquals("\nPRODUCT OPTIONS:\n" + VendingMachineLiterals.COLA_CODE + " COLA " + VendingMachineLiterals.COLA_COST_CENTS 
				+ " CENTS\n" +VendingMachineLiterals.CHIPS_CODE + " CHIPS " + VendingMachineLiterals.CHIPS_COST_CENTS + " CENTS\n"
				+VendingMachineLiterals.CANDY_CODE + " CANDY " + VendingMachineLiterals.CANDY_COST_CENTS + " CENTS\n"
				+"\nKeys:\n" + VendingMachineLiterals.EXIT + " is exit.\n"
				+VendingMachineLiterals.INSERT_COIN +"(coins) is insert coin. For example, " + VendingMachineLiterals.INSERT_COIN 
				+ "(Q D N P) would insert a quarter, a dime, a nickel, and a penny.\n"
				+VendingMachineLiterals.RETURN_COINS +" is return inserted coins.\n"
				+VendingMachineLiterals.PURCHASE +"(item) is purchase item. For example, "+ VendingMachineLiterals.PURCHASE
				+ "("+ VendingMachineLiterals.COLA_CODE + ") would select cola for purchase. Only one item can be purchased at a time.\n"
				+VendingMachineLiterals.DISPLAY_REFRESH +" is refresh display.\n"
				+VendingMachineLiterals.HELP +" is help (display all options again).\n"
				+"This machine only accepts quarters, nickels, and dimes.", vm.displayOptions());
	}
	
	@Test
	public void insertQuarterChangesDisplayTo25(){
		vm.insertCoin('Q');
		assertEquals("25", vm.controller.getDisplay());
	}
	
	@Test
	public void insertDimeChangesDisplayTo10(){
		vm.insertCoin('D');
		assertEquals("10", vm.controller.getDisplay());
	}
	
	@Test
	public void insertNickelChangesDisplayTo5(){
		vm.insertCoin('N');
		assertEquals("5",vm.controller.getDisplay());
	}
	
	@Test 
	public void insertPennyChangesMoneyInCoinReturn(){
		vm.insertCoin('P');
		assertEquals(1,vm.mh.getCoinReturnValue());
	}
	
	@Test
	public void whenAProductIsSelectedWithoutMoneyThePriceIsDisplayed(){
		vm.selectProduct("A1");
		assertEquals("PRICE: 100", vm.controller.getDisplay());
	}
	
	@Test
	public void whenNoParenthesisAreUsedForSelectionOrInsertionOptionsInvaildFormatIsTrue(){
		assertEquals(true,vm.invalidFormat("A1"));
	}
	
	@Test
	public void whenFormattedCorrectlyInvalidFormatIsFalse(){
		assertEquals(false,vm.invalidFormat("(A1)"));
	}
	
	@Test
	public void whenThereAreCharsOutsideParenthesisInvaildFormatIsTrue(){
		assertEquals(true,vm.invalidFormat("(A1)A"));
	}
	
	@Test
	public void whenDisplayInvalidFormatMethodCalledItDisplaysInvaidFormat(){
		assertEquals("Invaid key format. Please try again.", vm.displayInvalidFormat());
	}
	
	@Test 
	public void whenInvalidCoinInsertedInsertCoinIsFalse(){
		assertEquals(false,vm.insertCoin('C'));
	}
	
	@Test
	public void whenValidCoinInsertedInsertCoinIsTrue(){
		assertEquals(true,vm.insertCoin('P'));
	}
	
	@Test
	public void whenInsertingManyCoinsDisplayUpdatedCorrectly(){
		vm.insertManyCoins("(Q D N P)");
		assertEquals("40", vm.controller.getDisplay());
	}
	
	@Test
	public void whenOneCoinIsInvalidInsertManyCoinsReturnsFalse(){
		assertEquals(false, vm.insertManyCoins("(Q F)"));
	}
	
	@Test 
	public void whenValidCoinsInsertedInsertManyCoinsReturnsTrue(){
		assertEquals(true, vm.insertManyCoins("(Q N D P)"));
	}
	
	@Test
	public void whenDisplayInvaidCoinMethodCalledItDisplaysInvaidCoinError(){
		assertEquals("Invaid coins not entered.", vm.displayInvalidCoinError());
	}
	
	@Test
	public void whenInvalidProductIsSelectedSelectProductIsFalse(){
		assertEquals(false,vm.selectProduct("D2"));
	}
	
	@Test
	public void whenDisplayInvaidProductMethodCalledItDisplaysInvaidProductError(){
		assertEquals("Invaid product code. Please try again.", vm.displayInvalidProductError());
	}
	
	@Test
	public void whenDisplayInvalidKeyIsCalledItDisplaysInvalidKeyError(){
		assertEquals("Invaid key. Please try again.", vm.displayInvalidKey());
	}
	
	@Test
	public void whenCoinsAreDispensedTheAmountAndTypeOfCoinsAreDisplayed(){
		vm.insertManyCoins("(Q Q Q N D P)");
		vm.selectProduct("A2");
		assertEquals("1 quarter(s) 1 dime(s) 1 nickel(s) 1 penny/pennies dispensed.",vm.dispenseCoins());
	}
}
