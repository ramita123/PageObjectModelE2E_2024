package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderHelper {

	private static Properties prop;
	
	public static String getConfigPropertyData(String customPropertyName) {
		 prop= new Properties();
		 
		 
			
			try (FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\config.properties"))
			{
			    prop.load(file);
				System.out.println( file.toString());
			} catch (IOException e) {
			    e.printStackTrace();
			    throw new RuntimeException("Failed to load properties file.", e);
			}
			
		return	prop.getProperty(customPropertyName);
	}
}
