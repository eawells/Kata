package vendingmachinekata;

public class Controller {
	
	private MoneyHandler moneyHandler;
	private Display display;
	
	public Controller(){
		moneyHandler = new MoneyHandler();
		display = new Display();
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
	
	public String getDisplay() {
		return display.getDisplay();
	}
	
	public int getMoneyAvailable() {
		return	moneyHandler.getMoneyAvailable();
	}
	
	public void selectItem(String item) {
		if(item.equalsIgnoreCase(VendingMachineLiterals.COLA_CODE)){
			if(getMoneyAvailable() >= VendingMachineLiterals.COLA_COST){
			display.changeDisplayto("THANK YOU");
			}
			else{
				display.changeDisplayto("PRICE: " + VendingMachineLiterals.COLA_COST);
			}
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


	
	
}
