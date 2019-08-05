package com.mavencucumber.testrunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.maven.baseclass.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\java\\com\\mavencucumber\\feature\\",
		glue="com.mavencucumber.stepdefinition",
		tags="@LogInWithExampleKeyword", 
		strict=true,
		dryRun=false,
		monochrome=true
		)

public class AuPracticeTestRunner {
	
	public static WebDriver driver;
	@BeforeClass
	public static void setUp() throws Exception {
           driver = BaseClass.getBrowser("chrome");
         
	}
	@AfterClass
	public static void driverQuit() {
           driver.quit();
	}
	
	
}


