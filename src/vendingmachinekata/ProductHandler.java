package vendingmachinekata;

public class ProductHandler {
	
	private int candyStock;
	private int chipsStock; 
	
	public ProductHandler(){
		candyStock = 10;
		chipsStock = 10; 
	}

	public int getStock(Product item) {
		if(item.code().equals(Product.CANDY.code())){
			return candyStock;
		}
		return chipsStock; 
	}

	public void purchase(Product item) {
		if(item.code().equals(Product.CANDY.code())){
			candyStock -= 1;
		}
		if(item.code().equals(Product.CANDY.code())){
			chipsStock -= 1; 
		}
	}

}
