package main.java.vendingmachinekata;

public class Controller {
	
	private MoneyHandler moneyHandler;
	private Display display;
	private ProductHandler productHandler;
	
	public Controller(MoneyHandler moneyHandler,Display display,ProductHandler productHandler){
		this.moneyHandler = moneyHandler;
		this.display = display;
		this.productHandler = productHandler;
		display.updateDisplay(getMoneyAvailable(),moneyHandler.changeCanBeMade());
	}
	
	public void insertCoin(Coin coin) {
		moneyHandler.insertCoin(coin);
		display.addCoinToDisplay(coin);			
	}
	

	public String getDisplay() {
		String newDisplay = display.getDisplay();
		display.updateDisplay(getMoneyAvailable(), moneyHandler.changeCanBeMade());
		return newDisplay;
		 	
	}
	
	public int getMoneyAvailable() {
		return	moneyHandler.getMoneyAvailable();
	}
	
	public boolean selectItem(Product item) {
		
		if(productHandler.getStock(item) != 0){
			if(getMoneyAvailable() >= item.cost()){
				productHandler.purchase(item);
				moneyHandler.selectItem(item);
				display.changeDisplayto("THANK YOU");
				return true;
			}
			else{
				display.changeDisplayto("PRICE: " + item.cost() );
				return false;
			}	
		}
		else{
			display.changeDisplayto("SOLD OUT");
			return false;
		}		
	}

	public boolean returnCoins() {
		boolean isReturned = moneyHandler.returnCoins();
		display.updateDisplay(getMoneyAvailable(), moneyHandler.changeCanBeMade());
		return isReturned;
	}
	
	public String dispenseCoinstoCoinReturn(){
		return "Coins dispensed to coin return: " + moneyHandler.dispenseCoinstoCoinReturn();
	}
	

}
