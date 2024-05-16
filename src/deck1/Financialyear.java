package deck1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Financialyear {
	ChromeDriver driver;
	public Financialyear(ChromeDriver maindriver)
	{
		this.driver=maindriver;
	}

	public  void fyear() throws InterruptedException
	
	{
		System.out.println("\n");
		System.out.println("Check the Financial year  page");
		driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();      //settings button
		Thread.sleep(1000);
		Actions hover=new Actions(driver);
		WebElement btn1=driver.findElement(By.xpath("//span[contains(text(),'Financial Year')]")); //Financial Year
		hover.moveToElement(btn1).click().perform();
		WebElement title= driver.findElement(By.xpath("//h1[contains(text(),'FinancialYear Details')]"));
		
		if(title.isDisplayed())
	  	{
		  System.out.println("Sucessfully click the Financial year button "); 
	  	}   	  
	  	else
	  	{
		  System.out.println("User can not able to click the Financial year  button"); 
	  	}
		
		
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();  //add year button
		
		driver.findElement(By.name("fin_year")).sendKeys("2000");  //fin year
		driver.findElement(By.name("start_date")).click();			//start date
		driver.findElement(By.xpath("//td[contains(text(),'12')]")).click();
		
		driver.findElement(By.name("end_date")).click();			//end date
		driver.findElement(By.xpath("//td[contains(text(),'24')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();  //submit btn
		
driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();  //add year button
		
		driver.findElement(By.name("fin_year")).sendKeys("");  //fin year
		WebElement year1=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]"));
	
		
		
		driver.findElement(By.name("start_date")).click();			//start date
		driver.findElement(By.xpath("//td[contains(text(),'12')]")).click();
		
		driver.findElement(By.name("end_date")).click();			//end date
		driver.findElement(By.xpath("//td[contains(text(),'24')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();  //submit btn
	}

}
