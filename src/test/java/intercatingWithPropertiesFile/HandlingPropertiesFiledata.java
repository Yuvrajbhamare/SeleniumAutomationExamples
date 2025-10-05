package intercatingWithPropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HandlingPropertiesFiledata {
	@Test(priority = 1, groups = { "sanity" })
	public void setData() throws IOException {
//WebDriverManager.chromedriver().setup();
//WebDriver driver=new ChromeDriver();
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.get("");
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\DataDriven\\Config.properties");
		Properties prop = new Properties();
		prop.load(file);
		Set<String> keys = prop.stringPropertyNames();

		System.out.println(keys);

		Collection<Object> values = prop.values();
		System.out.println(values);
		String expected = "abcf";
		String Actual = "asedr";
		Assert.assertEquals(Actual, expected);
		Assert.assertNotEquals(prop, prop);
		Assert.fail();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(0, 0);

	}

	public void method2() {

	}

}
