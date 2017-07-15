package vendingmachinekata;

public class MoneyHandler {
	
	private int coinReturnValue;
	private int moneyThatCanBeUsedToBuy;
	
	public MoneyHandler(){
		coinReturnValue = 0;
		moneyThatCanBeUsedToBuy = 0;
	}
	
	public void insertCoin(Coin coin) {
		if(coin.mass() == VendingMachineLiterals.PENNY_MASS && coin.diameter() == VendingMachineLiterals.PENNY_DIAMETER){
			coinReturnValue += VendingMachineLiterals.PENNY_VALUE;
		}
		if(coin.mass() == VendingMachineLiterals.DIME_MASS && coin.diameter() == VendingMachineLiterals.DIME_DIAMETER){
			moneyThatCanBeUsedToBuy += VendingMachineLiterals.DIME_VALUE;
		}
		if(coin.mass() == VendingMachineLiterals.NICKEL_MASS && coin.diameter() == VendingMachineLiterals.NICKEL_DIAMETER){
			moneyThatCanBeUsedToBuy += VendingMachineLiterals.NICKEL_VALUE;
		}
		if(coin.mass() == VendingMachineLiterals.QUARTER_MASS && coin.diameter() == VendingMachineLiterals.QUARTER_DIAMETER){
			moneyThatCanBeUsedToBuy += VendingMachineLiterals.QUARTER_VALUE;
		}
		
	}
	
	public int getCoinReturnValue() {
		return coinReturnValue;
	}
	
	public int getMoneyThatCanBeUsedToBuy(){
		return moneyThatCanBeUsedToBuy;
	}

}
