
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void findAverage(List<Integer> list) {
		list.stream().mapToInt(i -> i) 
        .average() 
        .ifPresent(avg -> System.out.println("Average found is " + avg));
	}
	
	public static List<String> filterStrings(List<String> list, Predicate<String> predicate){
		List<String> finalList = list.stream().filter(str->predicate.test(str)).collect(Collectors.toList());
		
		return finalList;
	}
	public static List<String> filterStringPal(List<String> list, Predicate<String> predicate){
		List<String> finalList = list.stream().filter(str->predicate.test(str)).collect(Collectors.toList());
		return finalList;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Find the average of a list of numbers");
		List<Integer> list = new ArrayList<Integer>();
		System.out.print("Enter the length of the list: ");
		
		int len = Integer.parseInt(inp.readLine());
		for(int i=0;i<len;i++) {
			list.add(Integer.parseInt(inp.readLine()));
		}
		 findAverage(list);
		 
		 System.out.println("Finding the strings that start with letter 'a' ");
		 List<String> strList = new ArrayList<String>();
		 System.out.print("Enter the length of the list:");
		 int s_len = Integer.parseInt(inp.readLine());
		 System.out.println("Enter the strings");
		 for(int i=0;i<s_len;i++) {
			 strList.add(inp.readLine());
		 }
		List<String> filteredList = filterStrings(strList, (String str) -> str.charAt(0)=='a'&& str.length()==3);
		System.out.println("Strings in the filtered list are:");
		System.out.println(filteredList);
		
		System.out.println("Finding the strings which are palindromes");
		System.out.print("Enter the length of the list:");
		int st_len = Integer.parseInt(inp.readLine());
		List<String> str_List = new ArrayList<String>();
		for(int i=0;i<st_len;i++) {
			str_List.add(inp.readLine());
		}
		List<String> filtered_List = filterStringPal(str_List, (String str) -> str.equals(new StringBuilder(str).reverse().toString()));
		System.out.println("Strings in the filtered list are:");
		System.out.println(filtered_List);
		inp.close();
	}

}
