package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload_Files {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
        /*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\ybhamare\\OneDrive - Shipco Transport\\Documents\\1718020515_Direct-Service-Guide--2024-JUN-10 (1).xlsx");
        
        if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("1718020515_Direct-Service-Guide--2024-JUN-10 (1).xlsx"))
        {
        	System.out.println("File successfully uploaded");
        }
	
        else
        {
        	System.out.println("File not uploaded");
        }*/
      //Multiple files uploading
        
        String file1 ="C:\\Users\\ybhamare\\Downloads\\Vendor-CoC-2024 (4).pdf";
        String file2 ="C:\\Users\\ybhamare\\Downloads\\Vendor-CoC-2024 (5).pdf";
        
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
        
        //validating no.of files uploaded 
        int noOfFilesUploaded=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
        if (noOfFilesUploaded==2)
        {
        	System.out.println("All Files are uploaded");
        }
        else
        {
        	System.out.println("All Files are uploaded are not uploaded");
        }
	}
	///

}
