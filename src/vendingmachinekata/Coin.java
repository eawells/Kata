package vendingmachinekata;

public enum Coin {
	PENNY (2.5, 19),
	DIME (2.268, 17.91),
	NICKEL (5, 21.21),
	QUARTER (5.670, 24.26);

	//Mass is in grams, diameter is in mm
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
