package com.maven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	       public WebDriver driver;
	       
	       public SignInPage(WebDriver ldriver) {
                  this.driver=ldriver;
                  PageFactory.initElements(driver, this);
	       }
	       
	   	@FindBy(id="email")
	    private WebElement emailField;
		
		@FindBy(id="passwd")
		private WebElement passwdField;
		
		@FindBy(id="SubmitLogin")
		private WebElement loginField;
		
		@FindBy(xpath="//h1[text()='My account']")
	     private WebElement titleText;
		
		@FindBy(xpath="//span[text()='kakkaak dadaefa']")
		private WebElement checkAccount;
		
		public WebElement getTitleText() {
			return titleText;
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getEmailField() {
			return emailField;
		}

		public WebElement getPasswdField() {
			return passwdField;
		}

		public WebElement getLoginField() {
			return loginField;
		}

		public WebElement getCheckAccount() {
			return checkAccount;
		}
		
		
		
}
