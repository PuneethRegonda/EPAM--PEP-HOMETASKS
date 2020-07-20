

class Main{
	
	public static void main(String[] args){

		CustomList list = new CustomList<String>();
	        list.add(1291);
		list.add(1292);
		list.add(1293);
		list.add(1294);
		list.add(1295);
		list.add(1296);
		list.add(1297);
		list.add(1298);
		list.add(1299);
		list.add(1300);
		// initial size of list is 10 

		// list grows to 100 dynamically with support of abstract list growing feature

		for(int i =0;i<100;i++){
		  list.add(new Integer(i));		
		}

		// printing method
		System.out.println(list.toString());

		list.set(0, 13);
        	list.set(2, 14);
        	list.set(5, 15);
        	list.remove(0);
        	list.remove(4);
        	list.remove(2);
				
	}	
}


// list may grow 0 to inf size
// list will be initialized to 10 elements at time of creation
// list will provide methods for fetching , adding, removing , printing the list at any state in its lifecycle
