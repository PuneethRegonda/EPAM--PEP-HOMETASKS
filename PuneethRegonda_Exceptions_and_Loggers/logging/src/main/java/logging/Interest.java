package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interest {
	private static final Logger LOGGER=LogManager.getLogger(Interest.class);
	
	double principle;
	double rate_of_interest;
	double time;
Interest(double a,double b, double c)
{
	principle=a;
	 rate_of_interest=b;
	 time=c;
}
void Simple_Interest()
{
	double calculation=(principle*rate_of_interest*time)/100;
	LOGGER.info("Simple_Intrest is :"+calculation);
}
void Compound_Interest()
{
	double calculation=principle * Math.pow(1.0+rate_of_interest/100.0,time) - principle;
	LOGGER.info("Compound_Intrest is :"+calculation);
}
}
