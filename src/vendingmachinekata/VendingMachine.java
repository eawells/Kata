package vendingmachinekata;

public class VendingMachine {

	private String display;
	private int coinReturnValue;
	
	public VendingMachine(){
		display = "INSERT COIN";
		coinReturnValue = 0;
	}
	public String getDisplay() {
		return display;
	}

	public void insertCoin(Coin coin) {
		if(coin.mass() == 2.5 && coin.diameter() == 19){
			coinReturnValue +=1;
		}
		
	}
	public int getCoinReturnValue() {
		return coinReturnValue;
	}

}
