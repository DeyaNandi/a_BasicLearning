package com.mercury.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.google.common.io.Files;




public class MR1 {

	static WebDriver driver;
	
	WebDriver driver1;

	// ===============================================================================

	public void browserAppLaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		
		Thread.sleep(10000);
	}

	//======================================================
	
	public void logIn() throws IOException,InterruptedException,AWTException
	{
		Robot r1=new Robot();
		for (int i=1;i<=11;i++)
		{
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(10000);
		}
	
		Thread.sleep(10000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_D);
		Thread.sleep(5000);
		r1.keyPress(KeyEvent.VK_A);
		Thread.sleep(5000);
		r1.keyPress(KeyEvent.VK_S);
		Thread.sleep(5000);
		r1.keyPress(KeyEvent.VK_D);
		
		Thread.sleep(5000);
		
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_D);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_A);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_S);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_D);
		
		

		//WebElement uName= driver.findElement(By.name("userName"));
		//WebElement uName= driver.findElement(By.xpath("//input[@name='userName']"));
		//uName.sendKeys("dasd");

		
		
		//WebElement pwd= driver.findElement(By.name("password"));
		//WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		//pwd.sendKeys("dasd");
		
		
		//WebElement login= driver.findElement(By.name("login"));
		//WebElement login=driver.findElement(By.xpath("//input[@alt='Sign-In']"));
		//login.click();
		
		//Robot r1=new Robot();
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_ENTER);
		
		
		//WebElement register=driver.findElement(By.xpath("//a[@href='mercuryregister.php']"));
		
		//WebElement register=driver.findElement(By.linkText("REGISTER"));
		
		//WebElement register=driver.findElement(By.xpath("//a[starts-with(text(),'REGIS')]"));
		
		//register.click();
		
	
		Thread.sleep(10000);						
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./screenshots/snap.png"));

		Thread.sleep(3000);
	}
	
	public void loginWithParameters(String uname, String password) throws InterruptedException
	{
		WebElement userName= driver.findElement(By.xpath("//input[@name='userName']"));
		userName.sendKeys(uname);
		
		Thread.sleep(2000);
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys(password);
		
		Thread.sleep(2000);
		WebElement login=driver.findElement(By.xpath("//input[@alt='Sign-In']"));
				login.click();
		
	}
	
	public void verifyValidLogin()
	{
		String expectedTitle="Find a Flight: Mercury Tours:";
		
		String actTitle=driver.getTitle();
		
		System.out.println(actTitle);
		
		if (actTitle.equals(expectedTitle))
		{
			System.out.println("Login Successful");
			//return true;
		}
		
		else 
			
			System.out.println("Login Failed");
			
			//return false;
		
	}
	
	public void frameHandling() throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		List<WebElement> ele= driver.findElements(By.tagName("iframe"));
		
		int no_of_frames=ele.size();
		
		System.out.println(no_of_frames);
		
		for (WebElement e: ele)
		{
			System.out.println("Frame id:"+ e.getAttribute("id"));
			
			System.out.println("Frame Name:"+ e.getAttribute("name"));
		}
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("a077aa5e");
		
		Thread.sleep(3000);
		
		WebElement btnclk= driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		
		btnclk.click();
		
		
		
	}
	
	
	public static void browserCloseStatic()
	{
		driver.close();
	}
//==========================================
	
	/*public void loginSikuli()
	{
		WebElement uName= driver.findElement(By.xpath("//input[@name='userName']"));
				uName.sendKeys("dasd");
	
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
				pwd.sendKeys("dasd");
				
				Screen screen= new Screen();
				
				Pattern btnLogin = new Pattern("'/sikulifiles/btnlogin.png");
				
			//	btnLogin.click();
		
}*/
	
/*	public void sikuliPractice() throws FindFailed, InterruptedException
	{
		WebElement uName= driver.findElement(By.xpath("//input[@name='userName']"));
		uName.sendKeys("dasd");
		
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("dasd");
		
		Thread.sleep(3000);
		Screen screen= new Screen();
		
		Pattern btnLogin = new Pattern("./sikulifiles/btnlogin.png");
		
		screen.click(btnLogin);
		
	}*/
	
	public void autoitPractice() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		 driver1= new ChromeDriver();
		
		 driver1.manage().window().maximize();
		 
		 driver1.get("http://imgbb.com/");
		 
		 
		 WebElement btnStartUpload= driver1.findElement(By.xpath("//a[@class='btn btn-big blue']"));
		 
		 btnStartUpload.click();
		 
		 Runtime.getRuntime().exec("./autoitexe/autoitscriptdeya.exe");
		 
		 
		 Thread.sleep(6000);
		 
		 		 
		 WebElement btnUpload= driver1.findElement(By.xpath("//button[@class='btn btn-big green']"));
		 
		 btnUpload.click();
		
	}
	
	public void sikuliPracticelogin() throws FindFailed, InterruptedException
	{
		
		Screen screen1= new Screen();
		

		Pattern username = new Pattern("./sikulifiles/username.jpg");
		screen1.type(username, "dasd");
		
		screen1.wait(username,3000);
		
		Pattern password = new Pattern("./sikulifiles/password.jpg");
		
		screen1.type(password,"dasd");
		
		
		screen1.wait(password,3000);
		Pattern btnLogin = new Pattern("./sikulifiles/btnlogin.png");
		
		screen1.click(btnLogin);
		
		screen1.wait(username,3000);
		
		screen1.click("./sikulifiles/signoff.jpg");
		
		
		
	}

}