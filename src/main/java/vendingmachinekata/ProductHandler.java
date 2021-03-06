package main.java.vendingmachinekata;

public class ProductHandler {
	
	private int candyStock;
	private int chipsStock; 
	private int colaStock;
	
	public ProductHandler(){
		candyStock = VendingMachineLiterals.CANDY_MAX_STOCK;
		chipsStock = VendingMachineLiterals.CHIPS_MAX_STOCK; 
		colaStock = VendingMachineLiterals.COLA_MAX_STOCK;
	}

	public int getStock(Product item) {
		if(item.code().equals(Product.CANDY.code())){
			return candyStock;
		}
		else if(item.code().equals(Product.CHIPS.code())){
			return chipsStock;
		}
		else if(item.code().equals(Product.COLA.code())){
			return colaStock;
		}
		return 0;		 
	}

	public boolean purchase(Product item, int moneyAvailable) {
		if(getStock(item) > 0 && moneyAvailable >= item.cost()){
			if(item.code().equals(Product.CANDY.code())){
				candyStock -= 1;
			}
			else if(item.code().equals(Product.CHIPS.code())){
				chipsStock -= 1; 
			}
			else if(item.code().equals(Product.COLA.code())){
				colaStock -= 1; 
			}
			return true;
		}
		return false;
	}

}
