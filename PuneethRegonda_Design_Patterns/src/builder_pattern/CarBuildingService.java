package builder_pattern;

public class CarBuildingService {
	
	private static CarBuildingService service = null;
	private CarBuildingService() {}
	
	public static CarBuildingService getCarService() {
		if(service==null) return new CarBuildingService();
		return service;
	}
	
	public static Car build(CarBuilder builder) {
		builder.buildBodyStyle();
	    builder.buildPower();
	    builder.buildEngine();
	    builder.buildBreaks();
	    builder.buildSeats();
	    builder.buildWindows();
	    builder.buildFuelType();
	    return builder.getCar();
	} 
	
}
