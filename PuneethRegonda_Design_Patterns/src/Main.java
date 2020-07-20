import java.util.logging.Logger;

import builder_pattern.Car;
import builder_pattern.CarBuilder;
import builder_pattern.CarBuildingService;
import builder_pattern.SportsCarBuilder;
import singleton_pattern.DBService;

public class Main {
	
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {

		DBService dbInstance1 = DBService.getInstance();	
		DBService dbInstance2 = DBService.getInstance();
		DBService dbInstance3=  DBService.getInstance();
		DBService dbInstance4 = DBService.getInstance();
		
		LOGGER.info(String.valueOf(DBService.accessCount()));
		
		// Builder Pattern 
		CarBuilder sportsCarBuilder= new SportsCarBuilder();
		
		Car car = CarBuildingService.build(sportsCarBuilder);
		LOGGER.info("BUILDER PATTERN");
		LOGGER.info(car.toString());
		
	}

}
