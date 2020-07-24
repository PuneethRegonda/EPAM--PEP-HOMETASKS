package logging;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;


public class Main extends Interest{

	private static final Logger LOGGER=LogManager.getLogger(Main.class);
	
	Main(double d, double e, double f) {
	super(d, e, f);
}

public static void main(String args[]) 
{
	Scanner v=new Scanner(System.in);
	LOGGER.info("Enter Your Choice:\n1.Simple_interest\n2.Compound_interest");
	int choice=v.nextInt();
	Main obj;
	switch(choice)
	{
	case 1:
		LOGGER.info("Enter principle , rate_of_interset , time_in_years");
		obj=new Main(v.nextDouble(),v.nextDouble(),v.nextDouble());
		obj.Simple_Interest();
		break;
	case 2:
		LOGGER.info("Enter principle , rate_of_interset , time_in_years");
		 obj=new Main(v.nextDouble(),v.nextDouble(),v.nextDouble());
		obj.Compound_Interest();
		break;
	default :
		LOGGER.warn("Not in range");
	}
	v.close();
	}
}
