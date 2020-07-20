package singleton_pattern;
//Singleton Design Pattern

public class DBService {
	
	private static DBService instance = null;
	private static int access = 0;
	
	private DBService() {
		access = 1;
	}

	static public DBService getInstance() {
		access = access + 1; 
		if (instance == null)
			instance = new DBService();
		return instance;
	}
	
	static public int accessCount() {
		return access;
	}
	
}