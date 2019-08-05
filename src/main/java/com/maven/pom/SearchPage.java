package com.maven.pom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver driver;
	 
	 public SearchPage(WebDriver ldriver) {
              this.driver=ldriver;
              PageFactory.initElements(driver, this);
	  }
	
	@FindBy(id="search_query_top")
	 private WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSearchField() {
		return searchField;
	}

}




