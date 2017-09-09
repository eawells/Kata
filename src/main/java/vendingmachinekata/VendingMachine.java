package main.java.vendingmachinekata;

import java.util.Scanner;

public class VendingMachine {
	
	Controller controller;
	
	public VendingMachine(){
		MoneyHandler mh = new MoneyHandler();
		Display d = new Display();
		ProductHandler ph = new ProductHandler();
		controller = new Controller(mh,d,ph);
	}
	
	public static void main(String[] args) {
		
	}

	String displayOptions() {
		StringBuilder options = new StringBuilder("\nPRODUCT OPTIONS:\n");
		for(Product product : Product.values()){
			options.append(product.code() +" "+ product.toString() +" "+ product.cost() +" CENTS\n");
		}
		return options
				+"\nKeys:\n" + VendingMachineLiterals.EXIT + " is exit.\n"
				+VendingMachineLiterals.INSERT_COIN +"(coins) is insert coin. For example, " + VendingMachineLiterals.INSERT_COIN 
				+ "(Q D N P) would insert a quarter, a dime, a nickel, and a penny.\n"
				+VendingMachineLiterals.RETURN_COINS +" is return inserted coins.\n"
				+VendingMachineLiterals.PURCHASE +"(item) is purchase item. For example, "+ VendingMachineLiterals.PURCHASE
				+ "("+ VendingMachineLiterals.COLA_CODE + ") would select cola for purchase. Only one item can be purchased at a time.\n"
				+VendingMachineLiterals.DISPLAY_REFRESH +" is refresh display.\n"
				+VendingMachineLiterals.HELP +" is help (display all options again).\n"
				+"This machine only accepts quarters, nickels, and dimes.";
	}

	public void insertCoin(String coins) {
		if(coins.charAt(1) ==  'Q'){
			controller.insertCoin(Coin.QUARTER);
		}
		else if(coins.charAt(1) ==  'D'){
			controller.insertCoin(Coin.DIME);
		}	
	}
}
