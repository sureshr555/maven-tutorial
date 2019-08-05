package com.mavencucumber.stepdefinition;

import junit.framework.Assert;
import junit.textui.TestRunner;

import org.openqa.selenium.WebDriver;

import com.maven.baseclass.BaseClass;
import com.maven.helper.PageObjectManager;
import com.maven.pom.HomePage;
import com.maven.pom.SignInPage;
import com.mavencucumber.testrunner.AuPracticeTestRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuPracticeStepDefinition extends BaseClass {
	
	public static WebDriver driver=AuPracticeTestRunner.driver;
	  public static PageObjectManager pom=new PageObjectManager(driver);
	
	@Given("^User launched the automationpratice\\.com  application$")
	public void user_launched_the_automationpratice_com_application() throws Throwable {
	    getUrl("http://automationpractice.com/index.php");  
	}
	      
	@When("^User clicks on signin button in the header$")
	public void user_clicks_on_signin_button_in_the_header() throws Throwable {
	   
	    clickWebelement(pom.getHp().getSignIn());	    
	}

	@When("^User enters email id in signin page$")
	public void user_enters_email_id_in_signin_page() throws Throwable {
		//highlightWebElement(sp.getEmailField());
		//Thread.sleep(2000);
        inputValuesToWebelement(pom.getSp().getEmailField(), "kkgan@gmail.com");
           
        System.out.println(pom.getSp().getEmailField());
	}

	@When("^User enters password in signin page$")
	public void user_enters_password_in_signin_page() throws Throwable {
		
		 inputValuesToWebelement(pom.getSp().getPasswdField(), "qwerty");
		 System.out.println(pom.getSp().getPasswdField());
	}

	@When("^User clicks signin button in signin page$")
	public void user_clicks_signin_button_in_signin_page() throws Throwable {
		
		  clickWebelement(pom.getSp().getLoginField());
		    
	    
	}

	@Then("^User verify the username in the header$")
	public void user_verify_the_username_in_the_header() throws Throwable {
	    
	    
	}

	@When("^User clicks on search box$")
	public void user_clicks_on_search_box() throws Throwable {
	    
	    
	}

	@When("^User enters product name$")
	public void user_enters_product_name() throws Throwable {
	    
	    
	}

	@When("^User clicks search button$")
	public void user_clicks_search_button() throws Throwable {
	    
	    
	}

	@Then("^User verify the product name$")
	public void user_verify_the_product_name() throws Throwable {
	    
	    
	}

	@When("^User clicks on the necessary product$")
	public void user_clicks_on_the_necessary_product() throws Throwable {
	    
	    
	}

	@Then("^User verify is in add to cart page$")
	public void user_verify_is_in_add_to_cart_page() throws Throwable {
	    
	    
	}

	@When("^User clicks on the desired quantity$")
	public void user_clicks_on_the_desired_quantity() throws Throwable {
	    
	    
	}

	@When("^User clicks on the desired colour$")
	public void user_clicks_on_the_desired_colour() throws Throwable {
	    
	    
	}

	@When("^User clicks on Add To Cart$")
	public void user_clicks_on_Add_To_Cart() throws Throwable {
	    
	    
	}

	@Then("^User verify product is added to cart$")
	public void user_verify_product_is_added_to_cart() throws Throwable {
	    
	    
	}

	@When("^User clicks on the desired category of the dress$")
	public void user_clicks_on_the_desired_category_of_the_dress() throws Throwable {
	    
	    
	}

	@Then("^User verify the product category is displayed$")
	public void user_verify_the_product_category_is_displayed() throws Throwable {
	    
	    
	}

	@When("^User clicks on desired dress$")
	public void user_clicks_on_desired_dress() throws Throwable {
	    
	    
	}

	@When("^User clicks on log out button$")
	public void user_clicks_on_log_out_button() throws Throwable {
	    
	    
	}

	@Then("^User verify header has signin$")
	public void user_verify_header_has_signin() throws Throwable {
	    
	    
	}

	

	@When("^User enter emailid '(.*)' in the signin page$")
	public void user_enter_emailid_kkgan_gmail_com_in_the_signin_page(String args) throws Throwable {
	    
	    inputValuesToWebelement(pom.getSp().getEmailField(), args);
	}

	@When("^User enter password '(.*)' in the signin page$")
	public void user_enter_password_qwerty_in_the_signin_page(String args) throws Throwable {
		 
		 inputValuesToWebelement(pom.getSp().getPasswdField(), args);
	}

	@Then("^User verify username '(.*)' displayed in the header$")
	public void user_verify_username_kakkaak_dadaefa_displayed_in_the_header(String args) throws Throwable {
	    
	    String text = pom.getSp().getCheckAccount().getText();
	    Assert.assertEquals(args, text);
	    
	}



}
