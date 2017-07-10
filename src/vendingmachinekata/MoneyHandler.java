package vendingmachinekata;

public class MoneyHandler {
	
	private int coinReturnValue;
	private int moneyThatCanBeUsedToBuy;
	
	public MoneyHandler(){
		coinReturnValue = 0;
		moneyThatCanBeUsedToBuy = 0;
	}
	
	public void insertCoin(Coin coin) {
		if(coin.mass() == 2.5 && coin.diameter() == 19){
			coinReturnValue += VendingMachineLiterals.PENNY_VALUE;
		}
	
	}
	
	public int getCoinReturnValue() {
		return coinReturnValue;
	}
	
	public int getMoneyThatCanBeUsedToBuy(){
		return moneyThatCanBeUsedToBuy;
	}

}
