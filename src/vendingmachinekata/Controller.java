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
		if(coin.mass() == Coin.DIME.mass() && coin.diameter() == Coin.DIME.diameter()){
			if(isDigit(display.getDisplay())){
			
				int money = Integer.parseInt(display.getDisplay()) + 10;
				display.changeDisplayto(Integer.toString(money));
			}
			else{
				display.changeDisplayto("10");

			}
		}		
	}
	
	public String getDisplay() {
		return display.getDisplay();
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
