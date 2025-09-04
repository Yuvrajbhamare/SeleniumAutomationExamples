package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int noOfBrokenLinks=0;
		System.out.println(links.size());
		for(WebElement hrefvalue:links)
		{
			@SuppressWarnings("deprecation")
			String hrefAttributevalue=hrefvalue.getAttribute("href");
			if(hrefAttributevalue==null||hrefAttributevalue.isEmpty())
			{
				System.out.println("no Attribute vales");
				continue;
			}
			try
			{
			@SuppressWarnings("deprecation")
			URL alllinks=new URL(hrefAttributevalue);
			HttpURLConnection conn=(HttpURLConnection) alllinks.openConnection();
			conn.connect();
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefAttributevalue+"URL is broken");
				noOfBrokenLinks++;
			}
			else
			{
				System.out.println(hrefAttributevalue+"URL is Not Broken");
			}
			}
			catch(Exception e)
			{
				
			}
			System.out.println("TotalBrokenLinks:"+noOfBrokenLinks);
		}
		
	}

}
