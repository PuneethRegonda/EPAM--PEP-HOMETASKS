package logging_1;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main extends CostEstimation {
	
	private static final Logger LOGGER=LogManager.getLogger(Main.class);
	Main(double a, int b) {
		super(a, b);

	}

	public static void main(String args[]) 
	{
	Scanner v=new Scanner(System.in);
	
	LOGGER.info("Enter Your Choice Material:\n1.Standard\n2.Above standard\n3.High standard\n4.High Standard and Fully Automated");
	int choice=v.nextInt();
	if(choice > 4 || choice <1)
	{

		LOGGER.warn("Not in range");
	}
	else
	{
	LOGGER.info("Enter Area of house in sq.fts");
	double area=v.nextDouble();
	Main obj=new Main(area,choice);
	obj.Calculation();
	}
	v.close();	
}
}

