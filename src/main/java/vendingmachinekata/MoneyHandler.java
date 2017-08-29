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

	//gives a string of the coins in coin return
	public String dispenseCoinstoCoinReturn() {
		if(coinReturnValue ==0){
			return "None";
		}
		String change = makeChange(coinReturnValue);
		coinReturnValue = 0;
		return change;
	}
	
	private String makeChange(int amount){
		StringBuffer change = new StringBuffer();
		int countQuarters = 0;
		int countDimes = 0;
		int countNickels = 0;
		int countPennies = 0;
		if(amount >= 25){
			countQuarters = amount/25;
			//take the minimum between the quarters that need to be given and the number of quarters there are
			countQuarters = Math.min(countQuarters, coinsInMachineQuartersDimesNickelsPennies[0]);
			if(countQuarters != 0){
				amount = amount-(countQuarters*25);
				change.append(countQuarters + " quarter(s). ");
				coinsInMachineQuartersDimesNickelsPennies[0] -= countQuarters;
				}
			}
		if(amount >= 10){
			countDimes = amount/10;
			countDimes = Math.min(countDimes, coinsInMachineQuartersDimesNickelsPennies[1]);
			if(countDimes != 0){
				amount = amount-(countDimes*10);
		        change.append(countDimes + " dime(s). ");
		        coinsInMachineQuartersDimesNickelsPennies[1] -= countDimes;
				}
	        }
		if(amount >= 5){
	        countNickels = amount/5;
	        countNickels = Math.min(countNickels, coinsInMachineQuartersDimesNickelsPennies[2]);
	        if(countNickels != 0){
		        amount = amount-(countNickels*5);
		        change.append(countNickels + " nickel(s). ");
		        coinsInMachineQuartersDimesNickelsPennies[2] -= countNickels;
	        	}
	        }
		if(amount >= 1){
			countPennies = amount/1;
			countPennies = Math.min(countPennies, coinsInMachineQuartersDimesNickelsPennies[3]);
			if(countPennies != 0){
				amount = amount-(countPennies*5);
				change.append(countPennies + " penny(s). ");
				coinsInMachineQuartersDimesNickelsPennies[3] -= countPennies;
			}
	        }
		return change.toString();
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
		/*for any product price that can be purchased with quarters, dimes, nickels,
		the greatest amount of change needed would be quarter value - nickel value. However, 
		if one of the products is not divisible by 10, then a nickel would also be needed
		*/
		for(int i =0; i <productCostsColaChipsCandy.length; i++){
			if(productCostsColaChipsCandy[i]%10 != 0){
				if(coinsInMachineQuartersDimesNickelsPennies[2] ==0){
					return false;
				}
			}
		}
		int amountInMachine = coinsInMachineQuartersDimesNickelsPennies[1]*10 + coinsInMachineQuartersDimesNickelsPennies[2]*5;
		if(amountInMachine >= VendingMachineLiterals.QUARTER_VALUE_CENTS- VendingMachineLiterals.NICKEL_VALUE_CENTS){
			return true;
		}
		return false;
	}
	

}
