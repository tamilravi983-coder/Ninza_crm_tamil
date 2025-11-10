package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyfileutility {

	public String readdatafrompropertyfile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\SABARI\\eclipse-workspace\\E32_NINZA_CRM\\src\\test\\resources\\propetiesfileE32.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
//no need to use alone of this,means we not excuting this class,just have to resuse this methods so no need of main method

//by