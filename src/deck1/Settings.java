package deck1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Settings {
	 ChromeDriver driver;

	public Settings(ChromeDriver maindriver)
	{
		this.driver=maindriver;
	}
	
	public void settings() throws IOException, InterruptedException
	{
		System.out.println("\n");
		System.out.println("Check the settings page");
		driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();  //settings button
		Thread.sleep(1000);
		
		Actions hover=new Actions(driver);
		WebElement btn1=driver.findElement(By.xpath("//span[contains(text(),'Basic Information')]")); //basic informtion button
		hover.moveToElement(btn1).click().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/section[1]/ol[1]/li[1]/a[1]")).click();  // home  button
		WebElement title0= driver.findElement(By.xpath("//h3[contains(text(),'Reminder')]"));
		if(title0.isDisplayed())
	  	{
		  System.out.println("Sucessfully click the home button "); 
	  	}   	  
	  	else
	  	{
		  System.out.println("User can not able to click the home button"); 
	  	}
		
		
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();  //settings button
		WebElement btn2=driver.findElement(By.xpath("//span[contains(text(),'Basic Information')]")); //basic informtion button
		hover.moveToElement(btn2).click().perform();
		Thread.sleep(1000);
		
		
		
		WebElement title= driver.findElement(By.xpath("//h1[contains(text(),'Basic Information')]"));
		
		if(title.isDisplayed())
	  	{
		  System.out.println("Sucessfully click the basic information button "); 
	  	}   	  
	  	else
	  	{
		  System.out.println("User can not able to click the basic information  button"); 
	  	}
		
		
		
		
		
		
		
		
		
		WebElement dd=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]/select[1]"));
	    Select sel=new Select(dd);
	    sel.selectByIndex(1);
		
	    //excel download button...
	
		  WebElement downloadButton = driver.findElement(By.xpath( "//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[2]" ));
		  //excel btn 
		  hover.moveToElement(downloadButton).click().perform();
		  String downloadPath = "Downloads";
		  File downloadedFile = new File(downloadPath + "DECKLINE INTERIORS.xlsx"); // Provide the file name and extension 
		  SoftAssert softAssert = new SoftAssert();
	      softAssert.assertEquals(downloadedFile.exists(), "excel file is not downloaded");
	      System.out.println("excel file is  downloaded");  
		 
	    
	      //pdf download button...
	  	
		  WebElement downloadButton2 = driver.findElement(By.xpath( "//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[3]" ));
		  hover.moveToElement(downloadButton2).click().perform();
		  String downloadPath2 = "Downloads";
		  File downloadedFile2 = new File(downloadPath + "DECKLINE INTERIORS.pdf"); // Provide the file name and extension  
	      softAssert.assertEquals(downloadedFile2.exists(), "pdf is not downloaded");
	      System.out.println("pdf file is  downloaded");  
	    
	    
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();  //add company
		WebElement title2= driver.findElement(By.xpath("//b[contains(text(),'Company Details')]"));
		
		if(title2.isDisplayed())
	  	{
		  System.out.println("Sucessfully click the add company button "); 
	  	}   	  
	  	else
	  	{
		  System.out.println("User can not able to click the add company  button"); 
	  	}
		
		
		FileInputStream excel=new FileInputStream("C:\\selenium\\Excel sheet\\DeckLine\\Addcompany.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(excel);
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		
		  for(int i=1;i<=14;i++) {
			  
			 
			  
		  driver.findElement(By.name("name")).sendKeys(sh.getRow(i).getCell(0). getStringCellValue());
		  driver.findElement(By.name("address")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
		  
		  String numericValue = String.valueOf((int) sh.getRow(i).getCell(2).getNumericCellValue());
		  
		  WebElement ph1=driver.findElement(By.name("fphone"));
		  hover.moveToElement(ph1).click().perform();
		  hover.sendKeys(numericValue).perform();
		  
		  String numericValue2 = String.valueOf((int)sh.getRow(i).getCell(3).getNumericCellValue()); 
		  WebElement ph2=driver.findElement(By.name("sphone"));
		  hover.moveToElement(ph2).click().sendKeys(numericValue2).perform();
		  
		  WebElement email1=driver.findElement(By.name("femail"));
		  hover.moveToElement(email1).click().sendKeys(sh.getRow(i).getCell(4). getStringCellValue());
		  
		  WebElement email2=driver.findElement(By.name("semail"));
		  hover.moveToElement(email2).click().sendKeys(sh.getRow(i).getCell(5). getStringCellValue()).perform();
		  
		  WebElement website=driver.findElement(By.name("webiste"));
		  hover.moveToElement(website).click().sendKeys(sh.getRow(i).getCell(6). getStringCellValue()).perform();
		  
		  String numericValue3 = String.valueOf((int)sh.getRow(i).getCell(7).getNumericCellValue());
		  WebElement gst=driver.findElement(By.xpath( "//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/input[1]" ));
		  hover.moveToElement(gst).click().sendKeys(numericValue3).perform();
		  
		  driver.findElement(By.id("logo")).sendKeys("D:\\Screenshots\\Screenshot (2).png");
		  
		 WebElement sbt= driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));  //submit button
		 hover.moveToElement(sbt).click().perform(); 
		 
		 
		 WebElement btn = driver.findElement(By.xpath("//body/div[1]/div[1]/section[1]/ol[1]/li[2]/a[1]"));
		String btntext= btn.getText();
		 if (btntext.contentEquals(" Back To List")) {
		     driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click(); // add company

		     System.out.println("Successfully add the company ");

		     // Rest of the code for adding the company

		 } else {
		     System.out.println("Button not displayed");
		     WebElement cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));// cancel btn
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", cancel);
		 }

		  
			  /*WebElement body=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]"));
			  String var=body.getText();
			  if(body.isDisplayed())
			  {
				  System.out.println("A warning message for leaving  field blank is displayed");
				  driver.navigate().refresh();
			  }
			  else
			  {
				  System.out.println("A warning message for leaving company name field blank is not  displayed");
			  }*/
			  
	  }
		  
		 
		  
		  }
		  
 
		  
		
		
		
	
	}	
	
	

	
	