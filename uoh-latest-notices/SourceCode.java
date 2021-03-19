package AllTasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UoH_LatestNotices {

	/*
	 * Script to fetch the description of the latest notice from the University of Hyderabad website
	 * */
	
	public static void main(String[] args) {
		
		//the path here should be replaced by the one in the user's system
		System.setProperty("webdriver.edge.driver", "C:\\Users\\amand\\OneDrive\\Documents\\Miscellaneous\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.manage().window().maximize();
		
		//navigating to the university page
		driver.get("https://uohyd.ac.in/");
		
		// clicking on the 'ALL NOTICES' link
		driver.findElement(By.xpath("//ul[@id='et-secondary-nav']/li[4]")).click();
		
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			System.out.println("An exception was encountered while loading the contents of the page!");
			e.printStackTrace();
		}
		
		// making the driver switch to the new tab in which the page is opened
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowIterator = windows.iterator();
		windowIterator.next();
		
		driver.switchTo().window(windowIterator.next());
		
		// waiting until at least 5 notices have been loaded
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".mdocs-description"), 6));

		// Creating a file for the output
		try {
			File outputFile = new File("Latest-5-Notices.txt");
			if (outputFile.exists()) {
				outputFile.delete();
			}
			
			if (outputFile.createNewFile()) {
				System.out.println("File created: " + outputFile.getName());
			} else {
				System.out.println("Error in deleting old file. File already exists.");
			}
			
			// Creating a FileWriter object
			FileWriter myWriter = new FileWriter(outputFile);
		
			List<WebElement> notices = driver.findElements(By.cssSelector(".mdocs-description"));
			
			for (int i = 1; i <= 5; i++) {
				myWriter.write(String.valueOf(i) + ": " + notices.get(i).getText() + "\n");
			}
			
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("An error occurred while creating the output file / writing to it.");
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
