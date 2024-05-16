package deck1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Header {

       ChromeDriver driver;
	
       public Header(ChromeDriver maindriver)
     
       {
		this.driver=maindriver;
       }
       
       public void header() throws InterruptedException
       {
    	 System.out.println("Check the buttons in header");
    	   
    	
    	 driver.findElement(By.xpath("//header/nav[1]/a[1]")).click(); 	   
    	 Thread.sleep(1000);  
    	 WebElement bodyElement = driver.findElement(By.tagName("body"));
         // Get the class attribute value of the body element
         String classAttributeValue = bodyElement.getAttribute("class");
         
         SoftAssert softAssert = new SoftAssert();
         softAssert.assertTrue(classAttributeValue.contains("skin-blue sidebar-mini"), "The navigation panel  is Not minimized when hamburger button is clicked");
         System.out.println("The navigation panel  is  minimized when click on hamburger button");//check minimize
         
         
         driver.findElement(By.xpath("//header/nav[1]/a[1]")).click(); 
         Thread.sleep(1000);
       	 WebElement bodyElement2 = driver.findElement(By.tagName("body"));  
         // Get the class attribute value of the body element
         String classAttributeValue2 = bodyElement2.getAttribute("class");
         
         softAssert.assertTrue(classAttributeValue2.contains("skin-blue sidebar-mini sidebar-collapse"), "The navigation panel  is Not maximized when hamburger button is clicked");
         System.out.println("The navigation panel  is  maximized when click on hamburger button"); //check maximize 
    	 
    	 
    	 driver.findElement(By.xpath("//header/nav[1]/div[1]/ul[1]/li[2]/a[1]")).click(); 
    	 Thread.sleep(1000);
    	 WebElement title= driver.findElement(By.xpath("//header/nav[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/img[1]"));
    	  
    	  	if(title.isDisplayed())
    	  	{
    		  System.out.println("Sucessfully click the settings button "); 
    	  	}   	  
    	  	else
    	  	{
    		  System.out.println("User can not able to click the settings button"); 
    	  	}
    	  
    	  
    	 driver.findElement(By.xpath("//header/nav[1]/div[1]/ul[1]/li[1]/a[1]")).click();
    	 Thread.sleep(1000);
    	 
    	  	if(title.isDisplayed())
    	  	{
    		  System.out.println("Sucessfully click the  DECKLINE button "); 
    	  	}
    	    else
    	  	{
    		  System.out.println("User can not able to click the DECKLINE button"); 
    	  	}
    	  	
    	  	
    	  
       }
       
       
       


       public void before()
       {
       driver.findElement(By.name("username")).sendKeys("Deckline23");
       driver.findElement(By.name("password")).sendKeys("dckl@23");
       driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
       }
}
