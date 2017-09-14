package main.java.vendingmachinekata;

public class Controller {
	
	private MoneyHandler moneyHandler;
	private Display display;
	private ProductHandler productHandler;
	
	public Controller(MoneyHandler moneyHandler,Display display,ProductHandler productHandler){
		this.moneyHandler = moneyHandler;
		this.display = display;
		this.productHandler = productHandler;
		display.updateDisplay(moneyHandler.getMoneyAvailable(),moneyHandler.changeCanBeMade());
	}
	
	public void insertCoin(Coin coin) {
		moneyHandler.insertCoin(coin);
		display.addCoinToDisplay(coin);			
	}
	

	public String getDisplay() {
		String newDisplay = display.getDisplay();
		display.updateDisplay(moneyHandler.getMoneyAvailable(), moneyHandler.changeCanBeMade());
		return newDisplay;
		 	
	}
	
	public boolean selectItem(Product item) {
		int stock = productHandler.getStock(item);
		int moneyAvailable = moneyHandler.getMoneyAvailable();
		display.selectItem(item,stock,moneyAvailable);
		return productHandler.purchase(item,moneyAvailable) && moneyHandler.selectItem(item, stock);
	}
	
	public boolean returnCoins() {
		boolean isReturned = moneyHandler.pressReturnCoins();
		display.updateDisplay(moneyHandler.getMoneyAvailable(), moneyHandler.changeCanBeMade());
		return isReturned;
	}
	
	public int[] dispenseCoinsToCoinReturnQuartersDimesNickelsPennies(){
		int[] coinsInCoinReturn = moneyHandler.dispenseCoinstoCoinReturn();
		return coinsInCoinReturn;
	}
	

}
