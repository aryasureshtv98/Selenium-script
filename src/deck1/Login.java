package deck1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	ChromeDriver driver;
	
	public Login(ChromeDriver maindriver)
	{
		this.driver=maindriver;
	}

	public void loginpage() throws IOException, InterruptedException
	{
		
	
		FileInputStream excel=new FileInputStream("C:\\selenium\\Excel sheet\\DeckLine\\Login.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(excel);
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		
		for(int i=1;i<=3;i++)
		{
			driver.findElement(By.name("username")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(1000);
			driver.findElement(By.name("password")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
			
			  if(driver.getTitle().contentEquals("DECKLINE INTERIORS"))
			  {
				  sh.getRow(i).createCell(2).setCellValue("pass");
				  driver.findElement(By.xpath("//body/div[1]/aside[1]/section[1]/ul[1]/li[10]/a[1]")).click(); 
				  System.out.println("PASS");
			  }
			  else
			  {
				  sh.getRow(i).createCell(2).setCellValue("failed");
				  System.out.println("FAILED");
			  }
			    FileOutputStream result=new FileOutputStream("C:\\selenium\\Excel sheet\\DeckLine\\Login.xlsx");
				wb.write(result);
			 
		}
		
	

	}

}
