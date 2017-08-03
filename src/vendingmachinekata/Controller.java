package vendingmachinekata;

public class Controller {
	
	private MoneyHandler moneyHandler;
	private Display display;
	private ProductHandler productHandler;
	
	public Controller(){
		moneyHandler = new MoneyHandler();
		display = new Display();
		productHandler = new ProductHandler();
		updateDisplay();
	}
	
	public void insertCoin(Coin coin) {
		moneyHandler.insertCoin(coin);
		if(coin.mass() == VendingMachineLiterals.DIME_MASS && coin.diameter() == VendingMachineLiterals.DIME_DIAMETER){
			addMoneytoDisplay(10);
		}	
		else if(coin.mass() == VendingMachineLiterals.NICKEL_MASS && coin.diameter() == VendingMachineLiterals.NICKEL_DIAMETER){
			addMoneytoDisplay(5);
		}
		else if(coin.mass() == VendingMachineLiterals.QUARTER_MASS && coin.diameter() == VendingMachineLiterals.QUARTER_DIAMETER){
			addMoneytoDisplay(25);
		}
			
	}
	
	private void addMoneytoDisplay(int amount){
		if(isDigit(display.getDisplay())){
			int money = Integer.parseInt(display.getDisplay()) + amount;
			display.changeDisplayto(Integer.toString(money));
		}
		else{
			display.changeDisplayto(amount+"");

		}
	}
	
	private boolean isDigit(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}

	public String getDisplay() {
		String newDisplay = display.getDisplay();
		updateDisplay();
		return newDisplay;
		 	
	}
	
	public int getMoneyAvailable() {
		return	moneyHandler.getMoneyAvailable();
	}
	
	public void selectItem(Product item) {
		//check if in stock to purchase, display SOLD OUT if out of stock
		if(productHandler.getStock(item) != 0){
			if(getMoneyAvailable() >= item.cost()){
				display.changeDisplayto("THANK YOU");
				productHandler.purchase(item);
				moneyHandler.selectItem(item);
			}
			else{
				display.changeDisplayto("PRICE: " + item.cost() );
			}	
		}
		else{
			display.changeDisplayto("SOLD OUT");
		}		
	}

	public void returnCoins() {
		moneyHandler.returnCoins();
		updateDisplay();
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
