package main.java.vendingmachinekata;

public enum Coin {
	
	PENNY (VendingMachineLiterals.PENNY_MASS_GRAMS, VendingMachineLiterals.PENNY_DIAMETER_MM),
	DIME (VendingMachineLiterals.DIME_MASS_GRAMS, VendingMachineLiterals.DIME_DIAMETER_MM),
	NICKEL (VendingMachineLiterals.NICKEL_MASS_GRAMS, VendingMachineLiterals.NICKEL_DIAMETER_MM),
	QUARTER (VendingMachineLiterals.QUARTER_MASS_GRAMS, VendingMachineLiterals.QUARTER_DIAMETER_MM);

	private final double mass; 
	private final double diameter;
	
	Coin(double mass, double diameter){
		this.mass = mass;
		this.diameter = diameter;
	}
	
	protected double mass(){
		return mass;
	}
	
	protected double diameter(){
		return diameter;
	}

}
