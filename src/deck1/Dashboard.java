package deck1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Dashboard {
	 ChromeDriver driver;

	public Dashboard(ChromeDriver maindriver)
	{
		this.driver=maindriver;
	}
	
	
	public void dashboard() throws InterruptedException
	{
		 System.out.println("\n");
		 System.out.println("Check the dashboard");
		 driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).click(); 
		 
		 WebElement title1=driver.findElement(By.xpath("//body/div[1]/div[1]/section[1]/h1[1]"));
		 
		 if(title1.isDisplayed())
		 {
			 System.out.println("Sucessfully Navigated to dashboard "); 
		 }   	  
 	  	else
 	  	{
 	  		System.out.println("User can not Navigated to dashboard"); 
 	  	}
		 driver.findElement(By.xpath("//button[contains(text(),'today')]")).click(); 
		 Thread.sleep(1000);  
		 WebElement dateElement = driver.findElement(By.xpath("//a[contains(text(),'Fri 11/3')]"));
		 
		 String displayedDate = dateElement.getText();
		 String currentDate = new SimpleDateFormat("E MM/dd").format(new Date());

         SoftAssert softAssert = new SoftAssert();
         softAssert.assertEquals(displayedDate.compareTo(currentDate), "User cannot  click the today button");
         System.out.println("User can  click the today button");  //today button
		 
  
         driver.findElement(By.xpath("//body/div[1]/div[1]/section[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/button[1]/span[1]")).click();
         Thread.sleep(1000);  
         WebElement dateElement2 = driver.findElement(By.xpath("//h2[@id='fc-dom-1']"));
		 String displayedDate2 = dateElement2.getText();
		 String currentDate2 = new SimpleDateFormat("MMM dd – MMM dd, yyyy").format(new Date());
         	
         softAssert.assertEquals(displayedDate2.compareTo(currentDate2), "User cannot  click the left arrow button");
         System.out.println("User can  click the left arrow button");  //left arrow
		 
         
         
         driver.findElement(By.xpath("//body/div[1]/div[1]/section[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/button[2]/span[1]")).click();
         Thread.sleep(1000);  
         WebElement dateElement3 = driver.findElement(By.xpath("//h2[@id='fc-dom-1']"));
		 String displayedDate3 = dateElement3.getText();
		 String currentDate3 = new SimpleDateFormat("MMM dd – MMM dd, yyyy").format(new Date());
         
		
         softAssert.assertEquals(displayedDate3.compareTo(currentDate2), "User cannot  click the right arrow button");
         System.out.println("User can  click the right arrow button");  //right arrow
         
         
         String expectedurl=driver.getCurrentUrl();
         driver.findElement(By.xpath("//body/div[1]/div[1]/section[1]/ol[1]/li[1]/a[1]")).click();
         Thread.sleep(1000);  
         String actualurl=driver.getCurrentUrl();
        
        	  if(expectedurl.equals(actualurl))
        	   {
        		  System.out.println("Button responds because the url is matched\n" +expectedurl);
        	   }
        	  else
        	  {
        		  System.out.println("Button not responds because the url is not matched\n" +actualurl);
        	  }
        	
        	  				//check the home button using url
        		 
	}
	
	
	

}
