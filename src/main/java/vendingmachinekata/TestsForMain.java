package main.java.vendingmachinekata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestsForMain {
	
	@Test
	public void displayOptionsReturnsOptions(){
		VendingMachine vm = new VendingMachine();
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

}
