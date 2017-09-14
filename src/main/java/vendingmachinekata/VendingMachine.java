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
		VendingMachine vendingMachine = new VendingMachine();
		System.out.println("VENDING MACHINE\n\nDISPLAY: " +vendingMachine.controller.getDisplay());
		System.out.println(vendingMachine.displayOptions()+"\n");
		Scanner userInput = new Scanner(System.in);	
		String buttonPressed;
		while(true){
			buttonPressed = userInput.nextLine().toUpperCase().trim();
			if(buttonPressed.equals(VendingMachineLiterals.EXIT)){
				return;
			}
			else if(buttonPressed.isEmpty()){
				System.out.println(vendingMachine.displayInvalidKey());
			}
			else if(buttonPressed.charAt(0)==VendingMachineLiterals.INSERT_COIN){
				if(!vendingMachine.invalidFormat(buttonPressed.substring(1))){
					if(!vendingMachine.insertManyCoins(buttonPressed.substring(1))){
						System.out.println(vendingMachine.displayInvalidCoinError());
					}
					System.out.println(vendingMachine.dispenseCoins());
				}
				else{
					System.out.println(vendingMachine.displayInvalidFormat());
				}
			}
			else if(buttonPressed.equals(VendingMachineLiterals.RETURN_COINS)){
				vendingMachine.controller.returnCoins();
				System.out.println(vendingMachine.dispenseCoins());
			}
			else if(buttonPressed.charAt(0)==VendingMachineLiterals.PURCHASE){
				if(!vendingMachine.invalidFormat(buttonPressed.substring(1))){
					System.out.println(vendingMachine.selectProduct(buttonPressed.substring(1)));
					System.out.println(vendingMachine.dispenseCoins());
				}
				else{
					System.out.println(vendingMachine.displayInvalidFormat());
				}
			}
			else if(buttonPressed.equals(VendingMachineLiterals.HELP)){
				System.out.println(vendingMachine.displayOptions());
			}
			else if(!buttonPressed.equals(VendingMachineLiterals.DISPLAY_REFRESH)){
				System.out.println(vendingMachine.displayInvalidKey());
			}
			System.out.println("\nPress " + VendingMachineLiterals.HELP + " for help.\nDISPLAY: " + vendingMachine.controller.getDisplay()+ "\n");
		}
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

	public String selectProduct(String code) {
		String codeOnly = code.substring(1, code.length()-1);
		for(Product product: Product.values()){
			if(codeOnly.equals(product.code())){
				if(!controller.selectItem(product)){
					return "Item not dispensed.";
				}
				return product.toString() + " dispensed.";
			}
		}
		return this.displayInvalidProductError();
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
