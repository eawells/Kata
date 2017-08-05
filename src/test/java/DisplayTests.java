package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.vendingmachinekata.Display;

public class DisplayTests {
	
	@Test
	public void whenNoCoinIsInsertedDisplaySaysINSERTCOIN(){
		Display display = new Display();
		assertEquals("INSERT COIN", display.getDisplay());
	}
	
}
