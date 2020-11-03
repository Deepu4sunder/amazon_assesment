package amazon_assesment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class project {
	public static void main(String args[]) throws Exception {
	System.setProperty("webdriver.chrome.driver","/home/deepakraja4sund/Downloads/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	//calling the website
	driver.get("https://www.amazon.in/");
	Takescreenshot.takeSnapShot(driver, "/home/deepakraja4sund/Downloads/assesment/amazonhome.png");
	
	//Navigating to the mobile category
	driver.findElement(By.id("nav-hamburger-menu")).click();	
	driver.findElement(By.linkText("Mobiles, Computers")).click();
	Takescreenshot.takeSnapShot(driver, "/home/deepakraja4sund/Downloads/assesment/mobilecategories.png");
	
	//adding to the web elements to the list
	List<WebElement> links = driver.findElements(By.xpath("//a[@class='hmenu-item']"));
	
	//calling Database function for update and retrieve data
	Databaseactions db1= new Databaseactions();
	for (WebElement webElement : links)
	 {
		 
				if (webElement.getText() != null && webElement.getText().length()>0) { 
				java.lang.String categories=webElement.getText();
				db1.insertRecord(categories);
			}
		
	 } 
	 
	db1.retrieveData();
	
	driver.close();
	}



}
