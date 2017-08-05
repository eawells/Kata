package main.java.vendingmachinekata;

import java.util.Scanner;

public class VendingMachine {
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		System.out.println("VENDING MACHINE");
		displayOptions();
		System.out.println("Display: " + controller.getDisplay() + "\n");
		Scanner userInput = new Scanner(System.in);
		
		String buttonPressed;
		while(true){
			buttonPressed = userInput.nextLine().toUpperCase().trim();
			
			if(buttonPressed.equals(VendingMachineLiterals.EXIT)){
				return;
			}
			else if(buttonPressed.charAt(0)==VendingMachineLiterals.INSERT_COIN){
				//change the buttonPressed into a string without spaces or parenthesis
				String coins = buttonPressed.replaceAll("\\s","");
				if(coins.length()>=4 && coins.charAt(1) == '(' && coins.charAt(coins.length()-1) == ')'){
					int countPennies = 0;
					boolean invalidCoin = false;
					for(int i = 1; i <coins.length();i++){
						if(coins.charAt(i) ==  'Q'){
							controller.insertCoin(Coin.QUARTER);
						}
						else if(coins.charAt(i) ==  'D'){
							controller.insertCoin(Coin.DIME);
						}		
						else if(coins.charAt(i) ==  'N'){
							controller.insertCoin(Coin.NICKEL);
						}
						else if(coins.charAt(i) ==  'P'){
							controller.insertCoin(Coin.PENNY);
							countPennies +=1;
						}	
						else if(coins.charAt(i) != '(' && coins.charAt(i) != ')'){
							invalidCoin = true;
						}
					}
					if(countPennies !=0){
						System.out.println(controller.dispenseCoinstoCoinReturn());
					}
					if(invalidCoin){
						System.out.println("Invalid coin not entered.");
					}
				}
				else{
					invalidKeyFormat();
				}
				
			}
			else if(buttonPressed.equals(VendingMachineLiterals.RETURN_COINS)){
				if(controller.returnCoins()){
					System.out.println(controller.dispenseCoinstoCoinReturn());
				}	
				else{
					System.out.println("No coins to return.");
				}
			}
			else if(buttonPressed.charAt(0)==VendingMachineLiterals.PURCHASE){
				String item = buttonPressed.replaceAll("\\s","");
				//get the letters between the parenthesis
				int startingParenthesis = item.indexOf('(');
				int endingParenthesis = item.indexOf(')');
				//if the parenthesis don't exist, then throw invalid key format error
				if(startingParenthesis > 0 && endingParenthesis > 0 && endingParenthesis > startingParenthesis){
					item = item.substring(startingParenthesis+1, endingParenthesis);
					StringBuffer productName = new StringBuffer();
					boolean purchased = false;
					if(item.equals(VendingMachineLiterals.COLA_CODE)){
						purchased = controller.selectItem(Product.COLA);
						productName.append("Cola");
					}
					else if(item.equals(VendingMachineLiterals.CHIPS_CODE)){
						purchased = controller.selectItem(Product.CHIPS);
						productName.append("Chips");
					}
					else if(item.equals(VendingMachineLiterals.CANDY_CODE)){
						purchased = controller.selectItem(Product.CANDY);
						productName.append("Candy");
					}
					else{
						System.out.println("Invaid product code. Please try again.");
					}
					if(purchased){
						System.out.println(productName.toString() + " dispensed. \n" + controller.dispenseCoinstoCoinReturn());
					}
				}
				else{
					invalidKeyFormat();
				}
				
			}
			else if(buttonPressed.equals(VendingMachineLiterals.HELP)){
				displayOptions();
			}
			else if(!buttonPressed.equals(VendingMachineLiterals.DISPLAY_REFRESH)){
				System.out.println("Invaid key. Please try again.");
			}
			System.out.println("\nPress H for help.\nDisplay: " + controller.getDisplay()+ "\n");
		}
	}
	private static void displayOptions(){
		System.out.println("Keys:\n" + VendingMachineLiterals.EXIT + " is exit.");
		System.out.println(VendingMachineLiterals.INSERT_COIN +"(coins) is insert coin. For example, I(Q D N P) would insert a quarter, a dime, "
				+ "a nickel, and a penny.");
		System.out.println(VendingMachineLiterals.RETURN_COINS +" is return inserted coins.");
		System.out.println(VendingMachineLiterals.PURCHASE +"(item) is purchase item. For example, P("+ VendingMachineLiterals.COLA_CODE + ") "
				+ "would select cola for purchase. Only one item can be purchased at a time.");
		System.out.println(VendingMachineLiterals.DISPLAY_REFRESH +" is refresh display.");
		System.out.println(VendingMachineLiterals.HELP +" is help (display all options again).");
		System.out.println("This machine only accepts quarters, nickels, and dimes.");
		System.out.println("\nPRODUCT OPTIONS:\n" + VendingMachineLiterals.COLA_CODE + " COLA " + VendingMachineLiterals.COLA_COST + " CENTS");
		System.out.println(VendingMachineLiterals.CHIPS_CODE + " CHIPS " + VendingMachineLiterals.CHIPS_COST + " CENTS");
		System.out.println(VendingMachineLiterals.CANDY_CODE + " CANDY " + VendingMachineLiterals.CANDY_COST + " CENTS\n");
	}
	
	private static void invalidKeyFormat(){
		System.out.println("Invaid key format. Please try again.");
	}
}
