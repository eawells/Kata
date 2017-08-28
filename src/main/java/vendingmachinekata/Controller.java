package main.java.vendingmachinekata;

public class Controller {
	
	private MoneyHandler moneyHandler;
	private Display display;
	private ProductHandler productHandler;
	
	public Controller(MoneyHandler moneyHandler,Display display,ProductHandler productHandler){
		this.moneyHandler = moneyHandler;
		this.display = display;
		this.productHandler = productHandler;
		updateDisplay();
	}
	
	public void insertCoin(Coin coin) {
		moneyHandler.insertCoin(coin);
		display.addCoinToDisplay(coin);			
	}
	

	public String getDisplay() {
		String newDisplay = display.getDisplay();
		updateDisplay();
		return newDisplay;
		 	
	}
	
	public int getMoneyAvailable() {
		return	moneyHandler.getMoneyAvailable();
	}
	
	public boolean selectItem(Product item) {
		//check if in stock to purchase, display SOLD OUT if out of stock
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
		updateDisplay();
		return isReturned;
	}
	
	public String dispenseCoinstoCoinReturn(){
		return "Coins dispensed to coin return: " + moneyHandler.dispenseCoinstoCoinReturn();
	}
	
	private void updateDisplay(){
		if(getMoneyAvailable() > 0){
			display.changeDisplayto(getMoneyAvailable()+"");
		}
		else if(!moneyHandler.changeCanBeMade()){
			display.changeDisplayto("EXACT CHANGE ONLY");
		}
		else{
			display.changeDisplayto("INSERT COIN");
		}
	}
}
