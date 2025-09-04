package propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		// Location of the properties File
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\DataDriven\\Config.properties");
		// Loading data from properties File
		Properties propObj = new Properties();
		propObj.load(file);
		// reading data from properties file

		String URL = propObj.getProperty("Pappurl");
		String Email = propObj.getProperty("Pemail");
		String Password = propObj.getProperty("Ppassword");

		System.out.println(URL + " " + Email + " " + Password);// www.google.com ybhamare@shipco.com Admin@2029

		// reading all the keys from properties file
		Set<String> keys = propObj.stringPropertyNames();
		System.out.println(keys);// [Ppassword, Pappurl, Pemail]

		// OR-for reading all keys(by object)
		Set<Object> keys1 = propObj.keySet();
		System.out.println(keys1);

		// Reading all the values only from properties file
		Collection<Object> values = propObj.values();
		System.out.println(values);

		file.close();
	}

}
