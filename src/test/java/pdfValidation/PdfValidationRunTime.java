package pdfValidation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class PdfValidationRunTime {
	WebDriver driver;

	@Test
	public void pdfValidate() throws InterruptedException, InvalidPasswordException, IOException {
		// Set download folder
		String downloadPath = System.getProperty("user.dir") + "\\PDFValidationRunTime\\AirWayConditions.pdf";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");

		// Set Chrome preferences
		options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {
			{
				put("download.default_directory", downloadPath);
				put("plugins.always_open_pdf_externally", true);
			}
		}
		);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open your application
		driver.get("https://staging.www.shipco.com/");

		// Click the link/button to download PDF
		WebElement pdfhyperlink=driver.findElement(By.xpath("//div[@class='text-center']//a[@target='_blank'][normalize-space()='Air Waybill Conditions of Contract']"));
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()",pdfhyperlink);


		// Wait for download to complete
		Thread.sleep(5000); // Better: use dynamic wait with file check

		// Check if PDF downloaded
		File folder = new File(downloadPath);
		File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

		if (files != null && files.length > 0) {
			File downloadedPDF = files[0];
			System.out.println("PDF Downloaded: " + downloadedPDF.getName());

			// Extract and check text
			FileInputStream fis = new FileInputStream(downloadedPDF);
			PDDocument document = PDDocument.load(fis);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(document);
			document.close();

			if (text.contains("NOTICE APPEARING ON THE FACE OF THE AIR WAYBILL")) {
				System.out.println("Word found in PDF!");
			} else {
				System.out.println("Word NOT found in PDF!");
			}
		} else {
			System.out.println(" No PDF downloaded.");
		}

		driver.quit();
	}

}
