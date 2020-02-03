package com.epam.pep;

import java.util.ArrayList;
import java.util.List;

//for simplicity lets make the weight of each sweet =1 unit 
//and weight of each chocolate is 0.5
public class NewYearGift {
	
	private final int noOfChocolates;
	private final int noOfSweets;
	
	private List<Gift> gifts;
	
	public NewYearGift(int noOfChocolates ,int noOfSweets) {
		this.noOfChocolates = noOfChocolates;
		this.noOfSweets  = noOfSweets;
		init();
	}
	
	private void init() {
		
		gifts  = new ArrayList<Gift>();
		
		if(getNoOfChocolates()>0)
		{	
			Chocolate chocolate = new Chocolate(getNoOfChocolates());
			gifts.add(chocolate);
		}
		
		if(getNoOfSweets()>0)
		{	
			Sweet sweet = new Sweet(getNoOfSweets());
			gifts.add(sweet);
		}
	}

	// gets the totalWeights of Gift i.e Chocolate or Sweet
	public double getTotalWeight() {
		double totalGift =0;
		for(Gift gift:gifts) {
			totalGift += gift.getWeight();
		}
		return totalGift;
	}
	
	// gets the no of Sweets in NewYearGift
	public int getNoOfSweets() {
		return noOfSweets;
	}
	
	// gets the no of Chocolate in NewYearGift
	public int getNoOfChocolates() { 
		return noOfChocolates;
	}
	
}