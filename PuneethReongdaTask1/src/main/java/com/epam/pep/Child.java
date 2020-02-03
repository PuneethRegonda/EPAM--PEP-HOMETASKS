package com.epam.pep;


class Child implements Comparable<Child> {
	private final NewYearGift newYearGift;
	
	public Child(NewYearGift newYearGift) {
		this.newYearGift = newYearGift;
	}

	public NewYearGift getNewYearGift() {
		return newYearGift;
	}

	public int compareTo(Child child) {
		double currentChildGiftWeight =this.newYearGift.getTotalWeight();
		double nextchildGiftWeight = child.getNewYearGift().getTotalWeight();
		if(currentChildGiftWeight==nextchildGiftWeight)
		return 0;
		else if (currentChildGiftWeight>nextchildGiftWeight)
			return 1;
		else 
			return -1;
	}
	
	public String toString() {
		return "Child with newYearGift"+"of totalweight " + Double.toString(newYearGift.getTotalWeight())+" (no of chocolates ) "+Double.toString(newYearGift.getNoOfChocolates())+" (no of Sweets) "+Double.toString(newYearGift.getNoOfSweets());      
	}
}

