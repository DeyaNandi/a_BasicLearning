package com.mercury.test;

import java.awt.AWTException;
import java.io.IOException;

import org.sikuli.script.FindFailed;

public class Driver2 {

	
	public static void main(String args[]) throws  AWTException, InterruptedException, IOException, FindFailed
	{
		MR2 mr2= new MR2();
		
		mr2.appBrowserLaunch();
		
		mr2.validlogin();
		
		mr2.verifyLogIn();
		
		mr2.addfunctionality();
	}
	
}
