package deck1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Emplogin {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.woztiinfotech.com/Deckline_demo/login/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("Deckline23");
	    driver.findElement(By.name("password")).sendKeys("dckl@23");
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();   //login
		
	    System.out.println("Check the Employee login page");
	    System.out.println("\n");
	    driver.findElement(By.xpath("//body[1]/div[1]/aside[1]/section[1]/ul[1]/li[2]/a[1]")).click();  //settings button
	    Actions hover=new Actions(driver);
		WebElement emplog=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[2]/ul/li[4]/a")); //emp login  button
		hover.moveToElement(emplog).build().perform();
		emplog.click();
		
		WebElement title=driver.findElement(By.xpath("//h1[contains(text(),'Employee Login Details')]"));
		 
		 if(title.isDisplayed())
		 {
			 System.out.println("Sucessfully Navigated to  employee login page "); 
		 }   	  
	  	else
	  	{
	  		System.out.println("User can not Navigated to  employee login  page"); 
	  	}
		
		
		 
		driver.findElement(By.xpath("//th[contains(text(),'SlNO.')]")).click();  // check sort 1-row
		WebElement sort=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")); 
		hover.moveToElement(sort).perform();
		String text2=sort.getText();
		
		if(text2.equals("10"))
		{
			  System.out.println("Sort button is working ");
		}
		else
		{
			  System.out.println("Sort button is  not working ");
		}
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/a[1]")).click(); //add emp button
		WebElement title1=driver.findElement(By.xpath("//b[contains(text(),'Employee Details')]"));
		 
		 if(title1.isDisplayed())
		 {
			 System.out.println("Sucessfully Navigated to add employee page "); 
		 }   	  
 	  	else
 	  	{
 	  		System.out.println("User can not Navigated to add employee page"); 
 	  	}
		
		  
	       
		 	FileInputStream excel=new FileInputStream("C:\\selenium\\Excel sheet\\DeckLine\\addemp.xlsx");
		 	XSSFWorkbook wb=new XSSFWorkbook(excel);
			XSSFSheet sh=wb.getSheet("Sheet1");
			
		for(int i=1;i<=5;i++) {
				
			WebElement dd=driver.findElement(By.id("emp_id"));
			Select sel=new Select(dd);
			sel.selectByIndex(2);
			       
			 WebElement desig=driver.findElement(By.name("emp_designation1"));
			 hover.moveToElement(desig).click().sendKeys(sh.getRow(i).getCell(0). getStringCellValue()).perform();       
			       
			 WebElement uname=driver.findElement(By.name("user_name"));
			 hover.moveToElement(uname).click().sendKeys(sh.getRow(i).getCell(1). getStringCellValue()).perform(); 	
				
			 WebElement pass=driver.findElement(By.name("admin_password"));
			 hover.moveToElement(pass).click().sendKeys(sh.getRow(i).getCell(2). getStringCellValue()).perform(); 
			 
			 driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();  // submit btn 
			 
			 WebElement title3=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/a[1]"));
			 
			 if(title3.isDisplayed())
			 {
				 System.out.println("Sucessfully  add  the employee  "); 
			 }   	  
	 	  	else
	 	  	{
	 	  		System.out.println("User can not  add  the employee "); 
	 	  	}
			 driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
			}
		
		
	}

}
