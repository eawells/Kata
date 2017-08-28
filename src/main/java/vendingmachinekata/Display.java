package main.java.vendingmachinekata;

public class Display {

	private String display;
	
	
	public Display(){
		display = "INSERT COIN";
	}
		
	public String getDisplay() {
		return display;
	}

	public void changeDisplayto(String s){
		display = s;
	}

	public void addCoinToDisplay(Coin coin) {
		if(coin.mass() == VendingMachineLiterals.DIME_MASS_GRAMS && coin.diameter() == VendingMachineLiterals.DIME_DIAMETER_MM){
			addMoneytoDisplay(10);
		}	
		else if(coin.mass() == VendingMachineLiterals.NICKEL_MASS_GRAMS && coin.diameter() == VendingMachineLiterals.NICKEL_DIAMETER_MM){
			addMoneytoDisplay(5);
		}
		else if(coin.mass() == VendingMachineLiterals.QUARTER_MASS_GRAMS && coin.diameter() == VendingMachineLiterals.QUARTER_DIAMETER_MM){
			addMoneytoDisplay(25);
		}
	}
		private void addMoneytoDisplay(int amount){
			if(isDigit(getDisplay())){
				int money = Integer.parseInt(getDisplay()) + amount;
				changeDisplayto(Integer.toString(money));
			}
			else{
				changeDisplayto(amount+"");

			}
		}
		
		private boolean isDigit(String s){
			try{
				Integer.parseInt(s);
				return true;
			}
			catch(NumberFormatException e){
				return false;
			}
		}
}
