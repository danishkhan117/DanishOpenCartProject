package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties init_Prop() {                              

		try {
			FileInputStream fis = new FileInputStream("./PropertiesFiles./Config.Properties");

			Properties prop = new Properties();

			prop.load(fis);

			return prop;                                                      

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}

