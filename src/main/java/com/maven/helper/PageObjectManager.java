package com.maven.helper;

import org.openqa.selenium.WebDriver;

import com.maven.pom.HomePage;
import com.maven.pom.SignInPage;

public class PageObjectManager {
	
	  public WebDriver driver;
	  public HomePage hp;
	  public SignInPage sp;
	  
	public HomePage getHp() {
		if (hp==null) {
			hp=new HomePage(driver);
		}
		return hp;
	}
	
	public SignInPage getSp() {
		if (sp==null) {
			sp=new SignInPage(driver);
		}
		return sp;
	}
	  
	public PageObjectManager(WebDriver mdriver) {
              
		this.driver=mdriver;
	}

}
