package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vendingmachinekata.Product;
import vendingmachinekata.ProductHandler;

public class ProductHandlerTests {
	
	@Test
	public void whenAItemHasNotBeenPurchasedThereAre10Left(){
		ProductHandler productHandler = new ProductHandler();
		assertEquals(10, productHandler.getStock(Product.CANDY));
	}

}
