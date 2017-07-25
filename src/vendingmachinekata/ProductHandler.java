package vendingmachinekata;

public class ProductHandler {
	
	private int candyStock;
	
	public ProductHandler(){
		candyStock = 10;
	}

	public int getStock(Product item) {
		return candyStock;
	}

	public void purchase(Product item) {
		candyStock -= 1;
	}

}
