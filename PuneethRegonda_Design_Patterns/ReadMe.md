
```
public static void main(String[] args) {
    // Singleton Pattern
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

```  
  
### Creational Pattern
  #### Singleton Pattern
  #### Builder Pattern
