package vendingmachinekata;

public class MoneyHandler {
	
	private int coinReturnValue;
	private int moneyAvailable;
	private int[] coinsInMachineQuartersDimesNickels;
	
	public MoneyHandler(){
		coinReturnValue = 0;
		moneyAvailable = 0;
		coinsInMachineQuartersDimesNickels = new int[3];
	}
	
	public void insertCoin(Coin coin) {
		if(coin.mass() == VendingMachineLiterals.PENNY_MASS && coin.diameter() == VendingMachineLiterals.PENNY_DIAMETER){
			coinReturnValue += VendingMachineLiterals.PENNY_VALUE;
		}
		if(coin.mass() == VendingMachineLiterals.QUARTER_MASS && coin.diameter() == VendingMachineLiterals.QUARTER_DIAMETER){
			moneyAvailable += VendingMachineLiterals.QUARTER_VALUE;
			coinsInMachineQuartersDimesNickels[0] += 1;
		}
		if(coin.mass() == VendingMachineLiterals.DIME_MASS && coin.diameter() == VendingMachineLiterals.DIME_DIAMETER){
			moneyAvailable += VendingMachineLiterals.DIME_VALUE;
			coinsInMachineQuartersDimesNickels[1] += 1;
		}
		if(coin.mass() == VendingMachineLiterals.NICKEL_MASS && coin.diameter() == VendingMachineLiterals.NICKEL_DIAMETER){
			moneyAvailable += VendingMachineLiterals.NICKEL_VALUE;
			coinsInMachineQuartersDimesNickels[2] += 1;
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
		String change = makeChange(coinReturnValue);
		coinReturnValue = 0;
		return change;
	}
	
	private String makeChange(int amount){
		String change = "";
		int countQuarters = 0;
		int countDimes = 0;
		int countNickels = 0;
		int countPennies = 0;
		if(amount >= 25){
			countQuarters = amount/25;
			amount = amount-(countQuarters*25);
	        change += countQuarters + " quarter(s)\n";
	        }
		if(amount >= 10){
	        countDimes = amount/10;
	        amount = amount-(countDimes*10);
	        change += countDimes + " dime(s)\n";
	        }
		if(amount >= 5){
	        countNickels = amount/5;
	        amount = amount-(countNickels*5);
	        change += countNickels + " nickel(s)\n";
	        }
		if(amount >= 1){
			countPennies = amount/1;
			amount = amount-(countPennies*5);
	        change += countPennies + " penny(s)\n";
	        }
		return change;
	}

	public void returnCoins() {
		coinReturnValue = moneyAvailable;
		moneyAvailable = 0;
		
	}

	public String getCoinsInMachine() {
		if(coinsInMachineQuartersDimesNickels[0] != 0){
			return coinsInMachineQuartersDimesNickels[0] + " quarter(s)\n";
		}
		return "None";
	}
	

}
