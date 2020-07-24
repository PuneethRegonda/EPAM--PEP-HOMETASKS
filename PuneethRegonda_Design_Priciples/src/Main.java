
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Map<Character, operation> operationMap = new HashMap<Character, operation>();

		operationMap.put('+', new addition());
		operationMap.put('-', new subtraction());
		operationMap.put('*', new multiplication());
		operationMap.put('/', new division());

		Calculator calculator = Calculator.getInstance();
		
		do {
			
			System.out.println("Enter two numbers and +, -, * or / operartors");

			char operator = 0;
			double firstNum = 0;
			double secondNum = 0;
			try {
				firstNum = scanner.nextDouble();
				secondNum = scanner.nextDouble();
				operator = scanner.next().charAt(0);
			} catch (InputMismatchException e) {
				System.out.println("invalid input");
			}
		
			calculator.setCalculation(operationMap.getOrDefault(operator, new InValidOperation(operator)));
			System.out.println(calculator.calculate(firstNum, secondNum));
			
		} while (true);
	}

}

