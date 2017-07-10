package vendingmachinekata;

public class Display {

	private String display;
	
	
	public Display(){
		display = "INSERT COIN";
	}
		
	public String getDisplay() {
		return display;
	}

	public void insertCoin(Coin coin) {
		if(coin.mass() == Coin.DIME.mass() && coin.diameter() == Coin.DIME.diameter()){
			display = "10";
		}
		
	}

}
