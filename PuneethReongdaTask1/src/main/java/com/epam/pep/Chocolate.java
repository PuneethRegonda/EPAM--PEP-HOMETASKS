package com.epam.pep;

public class Chocolate implements Gift{
	
	private final double weight=0.5;

	private final int noCholates;

	public Chocolate(int noChocolates) {
		this.noCholates = noChocolates;
	}
	
	public double getWeight(){
		return weight*this.noCholates;
	}

	public int getNoOfCholates(){
		return noCholates;
	}

}