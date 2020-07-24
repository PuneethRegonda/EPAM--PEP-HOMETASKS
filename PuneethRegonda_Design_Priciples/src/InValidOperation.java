
import java.util.InputMismatchException;
public class InValidOperation implements operation{
	private char sign;
    InValidOperation(char sign){
        this.sign = sign;
}
public double calculate(double a,double b) {
	 
	throw new InputMismatchException("Invalid operator sign: "+sign);

}
}
