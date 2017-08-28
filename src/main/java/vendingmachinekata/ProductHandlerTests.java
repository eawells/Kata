package main.java.vendingmachinekata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductHandlerTests {
	
	ProductHandler productHandler;
	
	@Before
	public void setUp(){
		productHandler = new ProductHandler();
	}
	
	@Test
	public void whenAItemHasNotBeenPurchasedThereAre10Left(){
		assertEquals(10, productHandler.getStock(Product.CANDY));
	}


	@Test
	public void whenOneCandyHasBeenPurchasedThereAre9Left(){
		productHandler.purchase(Product.CANDY,500);
		assertEquals(9, productHandler.getStock(Product.CANDY));
	}
	
	@Test
	public void whenChipsHaveNotBeenPurchasedThereAre10Left(){
		assertEquals(10, productHandler.getStock(Product.CHIPS));
	}
	
	@Test 
	public void whenOneBagOfChipsHasBeenPurchasedThereAre9Left(){ 
		productHandler.purchase(Product.CHIPS,500); 
		productHandler.purchase(Product.CANDY,500); 
		assertEquals(9, productHandler.getStock(Product.CHIPS)); 
	}
	
	@Test
	public void whenColaHasNotBeenPurchasedThereAre10Left(){
		assertEquals(10, productHandler.getStock(Product.COLA));
	}
	
	@Test
	public void whenOneColaHasBeenPurchasedThereAre9Left(){
		productHandler.purchase(Product.COLA,500);
		assertEquals(9, productHandler.getStock(Product.COLA));
	}

}
