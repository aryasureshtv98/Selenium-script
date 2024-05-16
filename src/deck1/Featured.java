package deck1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Featured {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.woztiinfotech.com/Deckline_demo/login/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("Deckline23");
	    driver.findElement(By.name("password")).sendKeys("dckl@23");
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();   //login
		
	    System.out.println("Check the Featured products page");
	    System.out.println("\n");
	    
	    Actions hover=new Actions(driver);
	    
	    driver.findElement(By.xpath("//body[1]/div[1]/aside[1]/section[1]/ul[1]/li[3]/a[1]")).click(); //Featured products button
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//body/div[1]/aside[1]/section[1]/ul[1]/li[3]/ul[1]/li[1]/a[1]")).click();   //product category
	    Thread.sleep(1000);
	    WebElement srch=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/label[1]/input[1]"));
	    srch.sendKeys("CURTAINS AND DRAPES");
	    srch.sendKeys(Keys.ENTER);
	    //search bar
	    Thread.sleep(1000);
	   WebElement dd= driver.findElement(By.xpath("//*[@id=\"navi\"]/li[3]/ul/li[2]/a/i")); //manage products
	  hover.moveToElement(dd).click().perform();
	  Thread.sleep(3000);
	  WebElement element = driver.findElement(By.xpath("//body[1]/div[1]/aside[1]/section[1]/ul[1]/li[3]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]")); //curtain and drapes
	  driver.executeScript("arguments[0].click();", element);
	  
	  
	  driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
	  
	  WebElement title2= driver.findElement(By.xpath("//b[contains(text(),'Products-Curtains & Drapes')]"));
	  //hover.moveToElement(title2).build().perform();
	  String stg=title2.getText();
		
		if(stg.contentEquals(" Products-Curtains & Drapes"))
	  	{
		  System.out.println("Sucessfully click the add new button "); 
	  	}   	  
	  	else
	  	{
		  System.out.println("User can not able to click the add new  button"); 
	  	}

		FileInputStream excel=new FileInputStream("C:\\selenium\\Excel sheet\\DeckLine\\Fea products.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(excel);
		XSSFSheet sh=wb.getSheet("Sheet1");
		
	  for(int i=1;i<=7;i++) {
		  
	  
	  WebElement drop1=driver.findElement(By.id("cat_id_fk")); //category
			Select sel=new Select(drop1);
			sel.selectByIndex(0);
			
	  WebElement pcode=driver.findElement(By.id("product_code"));
	  hover.moveToElement(pcode).click().sendKeys(sh.getRow(i).getCell(0). getStringCellValue()).perform();
	  
	  driver.findElement(By.id("product_name")).sendKeys(sh.getRow(i).getCell(1). getStringCellValue());
			
			
			
	  }
	
	}
	
	

}
