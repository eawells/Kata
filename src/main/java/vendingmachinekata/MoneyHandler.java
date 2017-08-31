package main.java.vendingmachinekata;

public class MoneyHandler {
	
	private int coinReturnValue;
	private int moneyAvailable;
	private int[] coinsInMachineQuartersDimesNickelsPennies;
	private int[] productCostsColaChipsCandy = {VendingMachineLiterals.COLA_COST_CENTS, VendingMachineLiterals.CHIPS_COST_CENTS, VendingMachineLiterals.CANDY_COST_CENTS};
	
	public MoneyHandler(){
		coinReturnValue = 0;
		moneyAvailable = 0;
		coinsInMachineQuartersDimesNickelsPennies = new int[4];
	}
	
	public void insertCoin(Coin coin) {
		if(coin.mass() == VendingMachineLiterals.PENNY_MASS_GRAMS && coin.diameter() == VendingMachineLiterals.PENNY_DIAMETER_MM){
			coinReturnValue += VendingMachineLiterals.PENNY_VALUE_CENTS;
			coinsInMachineQuartersDimesNickelsPennies[3] += 1;
		}
		if(coin.mass() == VendingMachineLiterals.QUARTER_MASS_GRAMS && coin.diameter() == VendingMachineLiterals.QUARTER_DIAMETER_MM){
			moneyAvailable += VendingMachineLiterals.QUARTER_VALUE_CENTS;
			coinsInMachineQuartersDimesNickelsPennies[0] += 1;
		}
		if(coin.mass() == VendingMachineLiterals.DIME_MASS_GRAMS && coin.diameter() == VendingMachineLiterals.DIME_DIAMETER_MM){
			moneyAvailable += VendingMachineLiterals.DIME_VALUE_CENTS;
			coinsInMachineQuartersDimesNickelsPennies[1] += 1;
		}
		if(coin.mass() == VendingMachineLiterals.NICKEL_MASS_GRAMS && coin.diameter() == VendingMachineLiterals.NICKEL_DIAMETER_MM){
			moneyAvailable += VendingMachineLiterals.NICKEL_VALUE_CENTS;
			coinsInMachineQuartersDimesNickelsPennies[2] += 1;
		}
		
		
	}
	
	public int getCoinReturnValue() {
		return coinReturnValue;
	}
	
	public int getMoneyAvailable(){
		return moneyAvailable;
	}

	public boolean selectItem(Product item, int stock) {
		if(stock>0 && moneyAvailable >= item.cost()){
			coinReturnValue += moneyAvailable - item.cost();
			moneyAvailable = 0;
			return true;
		}
		return false;
	}

	public int[] dispenseCoinstoCoinReturn() {
		int[] change = calculateChange(coinReturnValue);
		coinReturnValue = 0;
		for(int i = 0;i<coinsInMachineQuartersDimesNickelsPennies.length;i++){
			coinsInMachineQuartersDimesNickelsPennies[i] -= change[i];
		}
		return change;
	}
	
	private int[] calculateChange(int amount){
		int[] quartersDimesNickelsPennies = new int[4];
		if(amount >= 25){
			quartersDimesNickelsPennies[0] = amount/25;
			quartersDimesNickelsPennies[0] = Math.min(quartersDimesNickelsPennies[0], coinsInMachineQuartersDimesNickelsPennies[0]);
			if(quartersDimesNickelsPennies[0] != 0){
				amount = amount-(quartersDimesNickelsPennies[0]*25);
				}
			}
		if(amount >= 10){
			quartersDimesNickelsPennies[1] = amount/10;
			quartersDimesNickelsPennies[1] = Math.min(quartersDimesNickelsPennies[1], coinsInMachineQuartersDimesNickelsPennies[1]);
			if(quartersDimesNickelsPennies[1] != 0){
				amount = amount-(quartersDimesNickelsPennies[1]*10);
				}
	        }
		if(amount >= 5){
	        quartersDimesNickelsPennies[2] = amount/5;
	        quartersDimesNickelsPennies[2] = Math.min(quartersDimesNickelsPennies[2], coinsInMachineQuartersDimesNickelsPennies[2]);
	        if(quartersDimesNickelsPennies[2] != 0){
		        amount = amount-(quartersDimesNickelsPennies[2]*5);
	        	}
	        }
		if(amount >= 1){
			quartersDimesNickelsPennies[3] = amount/1;
			quartersDimesNickelsPennies[3] = Math.min(quartersDimesNickelsPennies[3], coinsInMachineQuartersDimesNickelsPennies[3]);
			if(quartersDimesNickelsPennies[3] != 0){
				amount = amount-(quartersDimesNickelsPennies[3]*5);
				}
	        }
		return quartersDimesNickelsPennies;
	}
	
	public boolean pressReturnCoins() {
		if(moneyAvailable == 0){
			return false;
		}
		else{
			coinReturnValue += moneyAvailable;
			moneyAvailable = 0;
			return true;
		}
	}

	public int[] getCoinsInMachine() {
		return coinsInMachineQuartersDimesNickelsPennies;
	}

	public boolean changeCanBeMade() {
		if(coinsInMachineQuartersDimesNickelsPennies[2] ==0 && nickelNeeded()){
			return false;
		}
		int valueOfDimesAndNickelsInMachine = coinsInMachineQuartersDimesNickelsPennies[1]*10 + coinsInMachineQuartersDimesNickelsPennies[2]*5;
		if(valueOfDimesAndNickelsInMachine >= VendingMachineLiterals.QUARTER_VALUE_CENTS- VendingMachineLiterals.NICKEL_VALUE_CENTS){
			return true;
		}
		return false;
	}
	
	private boolean nickelNeeded(){
		for(int i =0; i <productCostsColaChipsCandy.length; i++){
			if(productCostsColaChipsCandy[i]%10 != 0){
				return true;
			}
		}
		return false;
	}
	

}
