import java.util.logging.Logger;

import abstractfactory_pattern.AbstractFactory;
import abstractfactory_pattern.FactoryCreator;
import abstractfactory_pattern.Loan;
import builder_pattern.Car;
import builder_pattern.CarBuilder;
import builder_pattern.CarBuildingService;
import builder_pattern.SportsCarBuilder;

import factory_pattern.ImageFactory;
import factory_pattern.ImageReader;
import singleton_pattern.DBService;

public class Main {

	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {

		DBService dbInstance1 = DBService.getInstance();
		DBService dbInstance2 = DBService.getInstance();
		DBService dbInstance3 = DBService.getInstance();
		DBService dbInstance4 = DBService.getInstance();

		LOGGER.info(String.valueOf(DBService.accessCount()));

		// Builder Pattern
		CarBuilder sportsCarBuilder = new SportsCarBuilder();

		Car car = CarBuildingService.build(sportsCarBuilder);
		LOGGER.info("BUILDER PATTERN");
		LOGGER.info(car.toString());

		/**
		 * AbstractFactory Pattern
		 * 
		 * AbstractFactory abstract class - Bank (SBI, HDFC,ICICI )and
		 * Loan(BussinessLoan,HomeLoan) interfaces BankFactory class implements
		 * AbstractFactory and same with LoanFactory class
		 **/

		LOGGER.info("AbstractFactory  PATTERN");
		AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
		Loan l = loanFactory.getLoan("Home");
		l.getInterestRate(2);
		l.calculateLoanPayment(100000, 3);
		LOGGER.info(l.toString());

		/* Factory Pattern
		 * 
		 **/
		
		LOGGER.info("Factory Pattern");
		String image = "sampleImage.jpeg";
		ImageReader reader =  ImageFactory.getReader(image);
		LOGGER.info(reader.getDecodeImage().toString());

	}

}
