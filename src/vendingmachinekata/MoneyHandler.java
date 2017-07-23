package vendingmachinekata;

public class MoneyHandler {
	
	private int coinReturnValue;
	private int moneyAvailable;
	
	public MoneyHandler(){
		coinReturnValue = 0;
		moneyAvailable = 0;
	}
	
	public void insertCoin(Coin coin) {
		if(coin.mass() == VendingMachineLiterals.PENNY_MASS && coin.diameter() == VendingMachineLiterals.PENNY_DIAMETER){
			coinReturnValue += VendingMachineLiterals.PENNY_VALUE;
		}
		if(coin.mass() == VendingMachineLiterals.DIME_MASS && coin.diameter() == VendingMachineLiterals.DIME_DIAMETER){
			moneyAvailable += VendingMachineLiterals.DIME_VALUE;
		}
		if(coin.mass() == VendingMachineLiterals.NICKEL_MASS && coin.diameter() == VendingMachineLiterals.NICKEL_DIAMETER){
			moneyAvailable += VendingMachineLiterals.NICKEL_VALUE;
		}
		if(coin.mass() == VendingMachineLiterals.QUARTER_MASS && coin.diameter() == VendingMachineLiterals.QUARTER_DIAMETER){
			moneyAvailable += VendingMachineLiterals.QUARTER_VALUE;
		}
		
	}
	
	public int getCoinReturnValue() {
		return coinReturnValue;
	}
	
	public int getMoneyAvailable(){
		return moneyAvailable;
	}

	public void selectItem(Product item) {
		if(moneyAvailable >= item.cost()){
			coinReturnValue += moneyAvailable - item.cost();
			moneyAvailable = 0;
		}
	}

	public String getCoinsInCoinReturn() {
		String change = "";
		int countQuarters = 0;
		int countDimes = 0;
		int countNickels = 0;
		int countPennies = 0;
		if(coinReturnValue >= 25){
			countQuarters = coinReturnValue/25;
	        coinReturnValue = coinReturnValue-(countQuarters*25);
	        change += countQuarters + " quarter(s)\n";
	        }
		if(coinReturnValue >= 10){
	        countDimes = coinReturnValue/10;
	        coinReturnValue = coinReturnValue-(countDimes*10);
	        change += countDimes + " dime(s)\n";
	        }
		if(coinReturnValue >= 5){
	        countNickels = coinReturnValue/5;
	        coinReturnValue = coinReturnValue-(countNickels*5);
	        change += countNickels + " nickel(s)\n";
	        }
		if(coinReturnValue >= 1){
			countPennies = coinReturnValue/1;
	        coinReturnValue = coinReturnValue-(countPennies*5);
	        change += countPennies + " penny(s)\n";
	        }
		return change;
	}

	public void returnCoins() {
		coinReturnValue = moneyAvailable;
		moneyAvailable = 0;
		
	}
	

}
