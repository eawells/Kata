package vendingmachinekata;

public class VendingMachineLiterals {
	/**The coins in enum do not get their mass and diameter from this
	literals class because they are supposed to represent the real coins that go
	into the machine, which would already have a mass and diameter
	*/
	
	//Coin Literals: value in cents, mass in grams, diameter in mm
	public static final int PENNY_VALUE = 1;
	public static final int DIME_VALUE = 10;
	public static final int NICKEL_VALUE = 5;
	public static final int QUARTER_VALUE = 25;
	
	public static final double PENNY_MASS = 2.5;
	public static final double DIME_MASS = 2.268;
	public static final double NICKEL_MASS = 5;
	public static final double QUARTER_MASS = 5.670;

	public static final double PENNY_DIAMETER = 19;
	public static final double DIME_DIAMETER = 17.91;
	public static final double NICKEL_DIAMETER = 21.21;
	public static final double QUARTER_DIAMETER = 24.26;
	
	//Product Literals: cost in cents
	public static final double COLA_COST = 100;
	public static final double CHIPS_COST = 50;
	public static final double CANDY_COST = 65;

}
