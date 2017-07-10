package vendingmachinekata;

public class MoneyHandler {
	
	private int coinReturnValue;
	private int moneyThatCanBeUsedToBuy;
	
	public MoneyHandler(){
		coinReturnValue = 0;
		moneyThatCanBeUsedToBuy = 0;
	}
	
	public void insertCoin(Coin coin) {
		if(coin.mass() == Coin.PENNY.mass() && coin.diameter() == Coin.PENNY.diameter()){
			coinReturnValue += VendingMachineLiterals.PENNY_VALUE;
		}
		if(coin.mass() == Coin.DIME.mass() && coin.diameter() == Coin.DIME.diameter()){
			moneyThatCanBeUsedToBuy += VendingMachineLiterals.DIME_VALUE;
		}
	}
	
	public int getCoinReturnValue() {
		return coinReturnValue;
	}
	
	public int getMoneyThatCanBeUsedToBuy(){
		return moneyThatCanBeUsedToBuy;
	}

}
