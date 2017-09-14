package main.java.vendingmachinekata;

import java.util.Scanner;

public class VendingMachine {
	
	Controller controller;
	MoneyHandler mh;
	
	public VendingMachine(){
		mh = new MoneyHandler();
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

	public boolean insertCoin(char coinChar){
		for(Coin coin: Coin.values()){
			if(coinChar == coin.toString().charAt(0)){
				controller.insertCoin(coin);
				return true;
			}
		}
		return false;
	}

	public boolean selectProduct(String code) {
		for(Product product: Product.values()){
			if(code.equals(product.code())){
				controller.selectItem(product);
				return true;
			}
		}
		return false;
	}

	public boolean invalidFormat(String input) {
		int startingParenthesis = input.indexOf('(');
		int endingParenthesis = input.indexOf(')');
		if(startingParenthesis == 0 && endingParenthesis == input.length()-1){
			return false;
		}
		return true;
	}

	public String displayInvalidFormat() {
		return "Invaid key format. Please try again.";
	}

	public boolean insertManyCoins(String coins) {
		boolean allCoinsInserted = true;
		String onlyCoins = coins.replaceAll("\\s","");
		for(int i = 1; i <onlyCoins.length()-1;i++){
			if(!insertCoin(onlyCoins.charAt(i))){
				allCoinsInserted = false;
			}
		}
		return allCoinsInserted;
	}

	public String displayInvalidCoinError() {
		return "Invaid coins not entered.";
	}

	public String displayInvalidProductError() {
		return "Invaid product code. Please try again.";
	}

	public String displayInvalidKey() {
		return "Invaid key. Please try again.";
	}

	public String dispenseCoins() {
		int[] coinsDispensed = controller.dispenseCoinsToCoinReturnQuartersDimesNickelsPennies();
		StringBuilder coins = new StringBuilder();
		if(coinsDispensed[0] >0){
			coins.append(coinsDispensed[0]+" quarter(s) ");
		}
		if(coinsDispensed[1] >0){
			coins.append(coinsDispensed[1]+" dime(s) ");
		}
		if(coinsDispensed[2] >0){
			coins.append(coinsDispensed[2]+" nickel(s) ");
		}
		if(coinsDispensed[3] >0){
			coins.append(coinsDispensed[3]+" penny/pennies ");
		}
		if(coins.length()==0){
			return "0 coins dispensed.";
		}
		coins.append("dispensed.");
		return coins.toString();
	}
	
}
