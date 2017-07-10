package vendingmachinekata;

public class Controller {
	
	private MoneyHandler moneyHandler;
	private Display display;
	
	public Controller(){
		moneyHandler = new MoneyHandler();
		display = new Display();
	}
	
	
	
}
