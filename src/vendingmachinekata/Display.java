package vendingmachinekata;

public class Display {

	private String display;
	
	
	public Display(){
		display = "INSERT COIN";
	}
		
	public String getDisplay() {
		return display;
	}

	public void changeDisplayto(String s){
		display = s;
	}
	
}
