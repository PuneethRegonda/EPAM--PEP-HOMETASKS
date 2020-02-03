package com.epam.pep;

public class Sweet implements Gift{
	private final double weight =1.0;

	private final int noSweets;
	
	public Sweet(int noOfSweet) {
		this.noSweets = noOfSweet;
	}

	public double getWeight(){
		return weight*this.noSweets;
	}

	public int getNoOfSweet(){
		return noSweets;
	}

}

