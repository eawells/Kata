package main.java.vendingmachinekata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DisplayTests {
	
	@Test
	public void whenNoCoinIsInsertedDisplaySaysINSERTCOIN(){
		Display display = new Display();
		assertEquals("INSERT COIN", display.getDisplay());
	}
	
}
