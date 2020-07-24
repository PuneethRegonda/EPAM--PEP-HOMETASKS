package logging_1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CostEstimation {
	
	private static final Logger LOGGER=LogManager.getLogger(CostEstimation.class);
	
	
	
double area;
int type_of_house;
CostEstimation(double a,int b){
area=a;
type_of_house=b;
}
void Calculation()
{
	double total=0;
	
	switch(type_of_house)
	{
	case 1:
		total=1200*area;
		break;
	case 2:
		total=1500*area;
		break;
	case 3:
		total=1800*area;
		break;
	case 4:
		total=2500*area;
		break;
	
	}
	LOGGER.info("Total cost is : "+total);
	
}
}
