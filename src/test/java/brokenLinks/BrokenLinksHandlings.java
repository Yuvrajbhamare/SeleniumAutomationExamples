package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksHandlings {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		// capture all links from webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("TotalNoOfLinks:" + links.size());
		int noOfBrokenLinks = 0;
		for (WebElement linkElement : links) {
			@SuppressWarnings("deprecation")
			String hrefAttributevalue = linkElement.getAttribute("href");
			if (hrefAttributevalue == null || hrefAttributevalue.isEmpty()) {
				System.out.println("href Attribute value is null");
				continue;
			}
			try 
			{
			 // Hit URL to the server
				@SuppressWarnings("deprecation")
				URL linkurl = new URL(hrefAttributevalue);// converted hrefvalue from string to URL Format
				HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection();// opens connection to the server
				conn.connect();// connect to the server and sent request to the server
				if (conn.getResponseCode() >= 400) {
					System.out.println(hrefAttributevalue + "===>Broken Link");
					noOfBrokenLinks++;
				} else {
					System.out.println(hrefAttributevalue + "===>Not a broken link");
				}
			} catch (Exception e) {
			}
		}
		System.out.println("Number of Broken Links:" + noOfBrokenLinks);
	}
}