

 ## HOMETASKS COMPLETED :
 ``` 
 *  Create multiple objects of sweets
 *  Collect children's gift to define total weight
 *  Sort the chocolates in a gift by one of the options
 ```


 ## OUTPUT:
 ```
  Child with newYearGiftof totalweight 1.5 (no of chocolates ) 1.0 (no of Sweets) 1.0
  Child with newYearGiftof totalweight 2.0 (no of chocolates ) 0.0 (no of Sweets) 2.0
  Child with newYearGiftof totalweight 2.5 (no of chocolates ) 1.0 (no of Sweets) 2.0
  Child with newYearGiftof totalweight 2.5 (no of chocolates ) 3.0 (no of Sweets) 1.0
  Child with newYearGiftof totalweight 3.0 (no of chocolates ) 4.0 (no of Sweets) 1.0
```

 * Design an object model for a given domain. Use (demonstrate the ability to work with): 
- Classes (abstract classes – if possible) 
- Interfaces 
- Inheritance, 
- Polymorphism, 
- Encapsulation 
Each class methods and variables must have a sense and be informative. It is good to think about exactly
what classes are needed in the solution. Inheritance should be used only when it makes sense. Classes
must be properly laid out in packages. Working with a user’s console menu should be minimal (only
necessary data input, display only what is asked in the problem). The task is a domain area where you
have to allocate the necessary hierarchy of classes and to implement it with the features of OOP (using
inheritance, if necessary or realizing interfaces). Each class must have fields and methods that you
consider necessary. The program should create objects of different classes in the selected domain,
combine them in any set of objects (use the collection). As a rule, the task requires to perform some
action on the objects in a collection of objects based on specified criteria. 
  ## Tasks : 
     Create the below project using Maven.  
    1. New Year's gift. Identify the hierarchy of chocolates and other sweets. Create multiple objects of
       sweets. Collect children&#39;s gift to define total weight. Sort the chocolates in a gift by one of the options.
       Find candies in the gift corresponding to a predetermined range of options.

 	1. Identify the hierarchy of chocolates and other sweets
  2. Create multiple objects of sweets
  3. Collect children's gift to define total weight
 	4. Sort the chocolates in a gift by one of the options
  5. Find "candies" in the gift corresponding to a predetermined range of "options" ????
  
## code sniffits

  ## Child 
  ```
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
```


## MAIN  - TASK1
```
package com.epam.pep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
	public static void main(String args[]) {
	
		List<Child> children = new ArrayList<Child>();
		
		children.add(new Child(new NewYearGift(1, 2)));
		children.add(new Child(new NewYearGift(3, 1)));
		children.add(new Child(new NewYearGift(4, 1)));
		children.add(new Child(new NewYearGift(1, 1)));
		children.add(new Child(new NewYearGift(0, 2)));
		
		Collections.sort(children);
		
		
		for(Child child: children) {
			System.out.println(child.toString());
		}
		
	}
}

```
### interface - Gift 

```
package com.epam.pep;

public interface Gift{
	public double getWeight();
}
```

### implements Models Class 

```
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

```

```

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

```


## UTILS CLass 

```
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

```


