package deck1;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Main {
	
	

	public static void main(String[] args) throws InterruptedException , IOException
	{
		
		ChromeDriver maindriver=new ChromeDriver();
		maindriver.get("https://www.woztiinfotech.com/Deckline_demo/login/");
		maindriver.manage().window().maximize();
		Thread.sleep(1000);
		
		
		
		 // Login obj1=new Login(maindriver);
		  //obj1.loginpage();
		 
		Header obj2=new Header(maindriver);
		obj2.before();
		//obj2.header();
		
		
		  //Dashboard obj3=new Dashboard(maindriver);
		  //obj3.dashboard();
		
		
		
		Settings obj4=new Settings(maindriver);
		obj4.settings();
		
		//Financialyear obj5= new Financialyear (maindriver);
		//obj5.fyear();
		
	}

}

