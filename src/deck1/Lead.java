package deck1;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Lead {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.woztiinfotech.com/Deckline_demo/login/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("Deckline23");
	    driver.findElement(By.name("password")).sendKeys("dckl@23");
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();   //login
		
	    System.out.println("Check the lead details page");
	    System.out.println("\n");
	    
	    driver.findElement(By.xpath("//body/div[1]/aside[1]/section[1]/ul[1]/li[4]/a[1]")).click(); //lead details btn
	   
	   WebElement title= driver.findElement(By.xpath("//body/div[1]/aside[1]/section[1]/ul[1]/li[4]/a[1]"));// element present
	   if(title.isDisplayed()) 
	   {
		   System.out.println("Navigate to lead page");
	   }
	   else
	   {
		   System.out.println("Not Navigate to lead page");
	   }

	    WebElement dd=driver.findElement(By.id("cust_status")); //staus
		Select sel=new Select(dd);
		sel.selectByIndex(2);
		
		driver.findElement(By.id("phone")).sendKeys("9090890898"); //ph.no
		Thread.sleep(1000);
		driver.findElement(By.id("search")).click(); //search
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]")).click();  //refresh
		driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[3]/div[1]/a[2]")).click(); //add lead btn
		
		WebElement title2=driver.findElement(By.xpath("//h1[contains(text(),'Inquiry')]"));
		if(title2.isDisplayed()) 
		   {
			   System.out.println("Navigate to add lead page");
		   }
		   else
		   {
			   System.out.println("Not Navigate to add lead page");
		   }
		
		Actions hover=new Actions(driver);
		
		FileInputStream excel=new FileInputStream("C:\\selenium\\Excel sheet\\DeckLine\\Lead.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(excel);
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		 for(int i=1;i<=8;i++)
		 {
			   
			String numericValue1 = String.valueOf((int)sh.getRow(i).getCell(0).getNumericCellValue()); //id
			WebElement id=driver.findElement(By.name("enquiry_id"));
			hover.moveToElement(id).click().sendKeys(numericValue1).perform();
			  
			WebElement dd1=driver.findElement(By.id("customer_prefix")); //customer type
			Select sel2=new Select(dd1);
			sel2.selectByIndex(1); 
			
			 WebElement cname=driver.findElement(By.name("customername"));  // cust.name
			 hover.moveToElement(cname).click().sendKeys(sh.getRow(i).getCell(1). getStringCellValue()).perform();
			
			 String numericValue2 = String.valueOf((int)sh.getRow(i).getCell(2).getNumericCellValue()); //mob
			 WebElement mob=driver.findElement(By.name("mobile1"));
			 hover.moveToElement(mob).click().sendKeys(numericValue2).perform();
			 
			 WebElement mob22=driver.findElement(By.name("alternate"));
			 hover.moveToElement(mob22).click().perform();
			 driver.switchTo().alert().accept();
				
			 
			 String numericValue3 = String.valueOf((int)sh.getRow(i).getCell(3).getNumericCellValue()); //alternative ph no
			 WebElement mob2=driver.findElement(By.name("alternate"));
			 hover.moveToElement(mob2).click().sendKeys(numericValue3).perform();
			 
			 WebElement email=driver.findElement(By.name("email"));  // email id
			 hover.moveToElement(email).click().sendKeys(sh.getRow(i).getCell(4). getStringCellValue()).perform();
			
			 
			 WebElement address=driver.findElement(By.name("address"));  // address
			 hover.moveToElement(address).click().sendKeys(sh.getRow(i).getCell(5). getStringCellValue()).perform();
			 
			 WebElement dd2=driver.findElement(By.id("lead_source")); //lead source
			 Select sel3=new Select(dd2);
			 sel3.selectByIndex(1); 
			 

			 WebElement dd3=driver.findElement(By.id("enquiry_assigned_user")); //lead source
			 Select sel4=new Select(dd3);
			 sel4.selectByIndex(3); 
			 
			 WebElement remark=driver.findElement(By.name("customer_remark"));  // remark
			 hover.moveToElement(remark).click().sendKeys(sh.getRow(i).getCell(6). getStringCellValue()).perform();
			 
			 driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();  //submit
			 
			 WebElement title3=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]"));
				if(title3.isDisplayed()) 
				   {
					   System.out.println("Sucessfully add the lead");
				   }
				   else
				   {
					   System.out.println("Lead entry is failed");
				   }
				
		
			
				
				
					 WebElement update=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/ul[1]/li[3]/a[1]"));
					 hover.moveToElement(update).build().perform();
					 update.click();
			
					 Boolean isButtonClicked = (Boolean) ((JavascriptExecutor) driver)
							    .executeScript("return buttonClickedCondition();");

							Assert.assertSame("Button should be clicked", isButtonClicked);
		  
		 
		 
		 }
	}

}
