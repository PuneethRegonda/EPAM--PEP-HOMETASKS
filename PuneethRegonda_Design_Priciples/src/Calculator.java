
public class Calculator {
	public static Calculator instance = null;
	operation cal;
	 public static Calculator getInstance(){
	        if(instance == null){
	            instance = new Calculator();
	        }
	        return instance;
	    }
	 public void setCalculation(operation cal) {
	        this.cal = cal;
	    }
	 public double calculate(double value1, double value2) {
	       return cal.calculate(value1, value2);
	    }
}
