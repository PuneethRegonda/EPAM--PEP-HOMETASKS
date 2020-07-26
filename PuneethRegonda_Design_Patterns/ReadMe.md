
```
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
		 * 
		 **/
		 
		LOGGER.info("Factory Pattern");
		String image = "sampleImage.jpeg";
		ImageReader reader =  ImageFactory.getReader(image);
		LOGGER.info(reader.getDecodeImage().toString());

		
	}


OUTPUT 

Jul 26, 2020 3:26:52 PM Main main
INFO: 4
Jul 26, 2020 3:26:52 PM Main main
INFO: BUILDER PATTERN
Jul 26, 2020 3:26:52 PM Main main
INFO: --------------SPORTS--------------------- \n Body: External dimensions: overall length (inches): 192.3, overall width (inches): 75.5, overall height (inches): 54.2, wheelbase (inches): 112.3, front track (inches): 63.7, rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7\n Power: 323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm\n Engine: 3.6L V 6 DOHC and variable valve timing\n Breaks: Four-wheel disc brakes: two ventilated. Electronic brake distribution. StabiliTrak stability control\n Seats: Driver sports front seat with one power adjustments manual height, front passenger seat sports front seat with one power adjustments\n Windows: Front windows with one-touch on two windows\n Fuel Type: Gasoline 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range
Jul 26, 2020 3:26:52 PM Main main
INFO: AbstractFactory  PATTERN
Jul 26, 2020 3:26:52 PM Main main
INFO: Monthly EMI is 2864.2578732455763 for the amount 100000.0
Jul 26, 2020 3:26:52 PM Main main
INFO: Factory Pattern
Jul 26, 2020 3:26:52 PM Main main
INFO: sampleImage.jpeg: is decoded

```  
  
### Creational Patterns
  #### Singleton Pattern
  #### Builder Pattern
  #### AbstractFactory Pattern
  #### Factory Pattern
  
