package com.mercury.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.google.common.io.Files;

public class MR2 {
	
	WebDriver driver;
	
	WebDriver driver1;
	
	public void appBrowserLaunch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	}
	
	public void validlogin() throws InterruptedException
	{
		WebElement username= driver.findElement(By.xpath("//input[@name='txtUsername']"));
		
		username.sendKeys("admin");
		
		Thread.sleep(3000);
		
		
		WebElement password= driver.findElement(By.xpath("//input[@name='txtPassword']"));
		
		password.sendKeys("admin123");
		
		Thread.sleep(3000);
		
		WebElement login= driver.findElement(By.xpath("//input[@name='Submit']"));
		
		login.click();
		
		
		
		
	}
	
	
	public void invalidlogin() throws InterruptedException, IOException
	{
		WebElement username= driver.findElement(By.xpath("//input[@name='txtUsername']"));
		
		username.sendKeys("deya");
		
		Thread.sleep(3000);
		
		
		WebElement password= driver.findElement(By.xpath("//input[@name='txtPassword']"));
		
		password.sendKeys("deya");
		
		Thread.sleep(3000);
		
		WebElement login= driver.findElement(By.xpath("//input[@name='Submit']"));
		
		login.click();
		
		
		try{
			
			WebElement errormessage= driver.findElement(By.xpath("//span[@id='spanMessage']"));
			
			System.out.println(errormessage.getText());   ;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getClass().getName());
			System.out.println("Login Successful");
		}
		
		finally
		{
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(src,new File("./screenshots/snap.png"));
		}
		
		
	}
	
	public void emptyUsername() throws AWTException, InterruptedException,IOException
	{
		Robot r1= new Robot();
		
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		
		
		
		//r1.keyPress(KeyEvent.VK_TAB);
		
		WebElement password= driver.findElement(By.xpath("//input[@name='txtPassword']"));
		
		password.sendKeys("deya");
		
		/*r1.keyPress(KeyEvent.VK_D);
		
		r1.keyPress(KeyEvent.VK_E);
		
		r1.keyPress(KeyEvent.VK_Y);
		
		r1.keyPress(KeyEvent.VK_A);*/
		
		Thread.sleep(3000);
		
		
		WebElement login= driver.findElement(By.xpath("//input[@name='Submit']"));
		
		
		login.click();
		
		Thread.sleep(3000);
		
		try
		{
			WebElement errormssg=driver.findElement(By.xpath("//span[@id='spanMessage']"));
			
			System.out.println(errormssg.getText());
		}
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Login Successful");
		}
		
		finally
		{
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(src, new File("./screenshots/snap.png"));
		}
	}
	
	public void emptyPasswword() throws  InterruptedException,AWTException,IOException
	{
		WebElement username= driver.findElement(By.xpath("//input[@name='txtUsername']"));
		
		username.sendKeys("deya");
		
		Thread.sleep(3000);
		
		Robot r1= new Robot();
		
		r1.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
WebElement login= driver.findElement(By.xpath("//input[@name='Submit']"));
		
		
		login.click();
		
		try
		{
WebElement errormssg=driver.findElement(By.xpath("//span[@id='spanMessage']"));
			
			System.out.println(errormssg.getText());
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Login Successful");
		}
	}
	public void printScreen() throws IOException
	{	
		
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(src, new File("./screenshots/snap.png"));
			
			
		}

		public void sikuliPracticelogin() throws FindFailed, InterruptedException
	{
		
		System.out.println("Tested");
		
		Thread.sleep(3000);
		Screen screen1= new Screen();
		

		Pattern username = new Pattern("./sikulifiles/username_orange.JPG");
		
		Thread.sleep(3000);
		
		System.out.println("Tested1");
		//screen1.wait(3000);
		Thread.sleep(3000);
		screen1.type(username, "Admin");
		
		
		//screen1.wait(3000);
		Thread.sleep(3000);
		
		Pattern password = new Pattern("./sikulifiles/password_orange.jpg");
		Thread.sleep(3000);
		
		
		screen1.type(password,"admin123");
		
		
		Thread.sleep(3000);
		Pattern btnLogin = new Pattern("./sikulifiles/Login_orange.jpg");
		Thread.sleep(3000);
		
		screen1.click(btnLogin);
		
		Thread.sleep(3000);
		
		Pattern welcome = new Pattern("./sikulifiles/WelcomeAdmin.JPG");
		
		Thread.sleep(3000);
		
		screen1.click(welcome);
		
		Thread.sleep(3000);
		
		Pattern logout= new Pattern("./sikulifiles/Logout_orange1.jpg");
		screen1.click(logout);
		
		
		
	}
	
	public void autoitPractice() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		 driver1= new ChromeDriver();
		
		 driver1.manage().window().maximize();
		 
		 driver1.get("http://imgbb.com/");
		 
		 Thread.sleep(3000);
		 
WebElement btnUpload= driver1.findElement(By.xpath("//a[@class='btn btn-big blue']"));
		 
		 btnUpload.click();
		 
		 
		Runtime.getRuntime().exec("./autoitexe/autoitdeya2.exe"); 
		
		Thread.sleep(6000);
		
		
		 WebElement upload= driver1.findElement(By.xpath("//button[@class='btn btn-big green']"));
		 
		// System.out.println(upload.getText());
		 
		 Thread.sleep(3000);
		 
		 upload.click();
		 
		 
	}
	
	public void autoitPractice2() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://imgur.com/upload");
		
		driver.manage().window().maximize();
		
		WebElement browse= driver.findElement(By.xpath("//label[@class='browse-btn']"));
		
		Thread.sleep(3000);
		
		browse.click();
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("./autoitexe/autoitdeya3.exe");
		
		Thread.sleep(10000);
		
				
	
	}
	
	public void verifyLogIn()
	{
		String expectedURL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		
		String actURL=driver.getCurrentUrl();
		
		if (!(actURL.equals(expectedURL)))
				{
			System.out.println("Login Successful");
				}
		
		else
			System.out.println("Login UnSuccessful");
	}
	
	public void addfunctionality() throws FindFailed, IOException, InterruptedException
	{
		WebElement adminModule= driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
		
		Thread.sleep(3000);
		
		adminModule.click();
		
		Screen screen= new Screen();
		
		Pattern pattern= new Pattern("./sikulifiles/Add.jpg");
		
		Thread.sleep(3000);
		
		screen.click(pattern);
		
		/*File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(src,new File( "./screenshots/snap.jpg"));*/
		
		Thread.sleep(10000);
		
		Select userRole= new Select(driver.findElement(By.id("systemUser_userType")));
		
		Thread.sleep(6000);
		
		userRole.selectByVisibleText("Admin");
		
		Thread.sleep(3000);
		
		WebElement employeeName= driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']"));
		
		Thread.sleep(3000);
		
		employeeName.sendKeys("LinearApproach 2 FIRSTNAME LinearApproach 2 LASTNAME");
		
		Thread.sleep(6000);
		
		WebElement userName= driver.findElement(By.id("systemUser_userName"));
		
		Thread.sleep(6000);
		
		userName.sendKeys("Anirban");
		
		Thread.sleep(6000);
		
		Select status= new Select(driver.findElement(By.id("systemUser_status")));
		
		Thread.sleep(6000);
		
		status.selectByVisibleText("Enabled");
		
		Thread.sleep(6000);
		
		WebElement password= driver.findElement(By.xpath("//input[@id='systemUser_password']"));
		
		Thread.sleep(6000);
		
		password.sendKeys("Adrijit@123");
		
		Thread.sleep(6000);
		
WebElement confirmPassword= driver.findElement(By.id("systemUser_confirmPassword"));

Thread.sleep(6000);
		
confirmPassword.sendKeys("Adrijit@123");
		
		Thread.sleep(6000);
		
	WebElement save= driver.findElement(By.id("btnSave"));
	
	Thread.sleep(6000);
	
	save.click();
		
		
	}
	
	}
	
	
	


