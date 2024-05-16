package deck1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {

		public static void main(String[] args) throws InterruptedException, IOException {
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.woztiinfotech.com/Deckline_demo/login/");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			
			driver.findElement(By.name("username")).sendKeys("Deckline23");
		    driver.findElement(By.name("password")).sendKeys("dckl@23");
		    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();   //login
			
		    System.out.println("Check the logout  page");
		    System.out.println("\n");
		    
		    driver.findElement(By.xpath("//span[contains(text(),'DECKLINE23')]")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		    
		    WebElement logout=driver.findElement(By.xpath("//button[contains(text(),'login')]"));
		    
		    if(logout.isDisplayed())
		    {
		    	 System.out.println("Sucessfully logout");
		    }
		    else
		    {
		    	 System.out.println("Logout Failed");
		    }
	}

}
