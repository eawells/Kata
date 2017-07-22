package vendingmachinekata;

public class Controller {
	
	private MoneyHandler moneyHandler;
	private Display display;
	private boolean normalDisplay;
	
	public Controller(){
		moneyHandler = new MoneyHandler();
		display = new Display();
		normalDisplay = true;
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
		if(!normalDisplay){
			normalDisplay = true;
			return display.getDisplay();
		}
		if(getMoneyAvailable() > 0){
			return getMoneyAvailable()+"";
		}
		return "INSERT COIN";
		
		 	
	}
	
	public int getMoneyAvailable() {
		return	moneyHandler.getMoneyAvailable();
	}
	
	public void selectItem(Product item) {
		if(getMoneyAvailable() >= item.cost()){
			display.changeDisplayto("THANK YOU");
			normalDisplay = false;
		}
		else{
			display.changeDisplayto("PRICE: " + item.cost() );
			normalDisplay = false;
		}
		
		moneyHandler.selectItem(item);
		
	}

	public void returnCoins() {
		display.changeDisplayto("INSERT COIN");
		normalDisplay = false;
	}	
}
