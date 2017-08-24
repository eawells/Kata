package main.java.vendingmachinekata;

public enum Product {
	COLA (VendingMachineLiterals.COLA_CODE, VendingMachineLiterals.COLA_COST_CENTS),
	CHIPS (VendingMachineLiterals.CHIPS_CODE, VendingMachineLiterals.CHIPS_COST_CENTS),
	CANDY (VendingMachineLiterals.CANDY_CODE, VendingMachineLiterals.CANDY_COST_CENTS);
	
	
	private final String code; 
	private final int cost;
	
	Product(String code, int cost){
		this.code = code;
		this.cost = cost;
	}
	
	protected String code(){
		return code;
	}
	
	protected int cost(){
		return cost;
	}
}
