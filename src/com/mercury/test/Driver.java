package com.mercury.test;

import java.awt.AWTException;
import java.io.IOException;

import org.sikuli.script.FindFailed;





public class Driver {

	public static void main(String[] args) throws  AWTException, InterruptedException, IOException, FindFailed
	{
		
		MR1 mr1 = new MR1();
	//	mr1.browserAppLaunch();
		
		//mr1.logIn();
		
		//mr1.sikuliPractice();
		
		//mr1.autoitPractice();
		
		//mr1.sikuliPracticelogin();
		
		//mr1.loginWithParameters("dasd", "dasd");
		
		//mr1.verifyValidLogin();
		
		mr1.frameHandling();
		
	//	MR1.browserCloseStatic();
		
	}

}
