package com.maven.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	  public static WebDriver driver;
	
	  public static  WebDriver  getBrowser(String browserName) throws Exception {
		       try {
				if(browserName.equalsIgnoreCase("chrome")){
					   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resource\\com\\maven\\drivers\\chromedriver.exe");
					   driver= new ChromeDriver();
				   }
				   else if (browserName.equalsIgnoreCase("firefox")) {
					    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
					    driver=new FirefoxDriver();
				}
				   else if (browserName.equalsIgnoreCase("ie")) {
					    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
				}
				   else
					   throw new Exception("Browser Name is Invalid");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				return driver;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		       
                   		  }
	  
	  public static void getUrl(String Url) {
		    try {
				driver.get(Url);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
	}

	  public static String getText(WebElement element) {
             try {
				String text = element.getText();
				 return text;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
				
			}
	}
	  
	  public static boolean elementIsDisplayed(WebElement element) {
                  try {
					boolean displayed = element.isDisplayed();
					  return displayed;
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
					
				}
	}
	  public static boolean elementIsEnabled(WebElement element) {
               try {
				boolean enabled = element.isEnabled();
				   return enabled;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}	
	  }
	  public static void waitForElementVisibility(WebElement element) {
		  try {
			WebDriverWait wb=new WebDriverWait(driver, 40);
			  wb.until(ExpectedConditions.visibilityOf(element)); 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
			
		}
		  	}
	  
	  public static void inputValuesToWebelement(WebElement element,String value) {
		  try {
			waitForElementVisibility(element);
			  if (elementIsDisplayed(element)&&elementIsEnabled(element)) {
				  element.sendKeys(value);
				  
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
        
	}
	  public static void clickWebelement(WebElement element) {
         try {
			waitForElementVisibility(element);
			 if (elementIsDisplayed(element)) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	  
	  public static void selectDropDown(WebElement element,String option, String value) {
		  try {
			waitForElementVisibility(element);
			  Select sc= new Select(element);
			  if(option.equalsIgnoreCase("value")){
				  sc.selectByValue(value);
			  }
			  else if (option.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(value);
			}
			  else if (option.equalsIgnoreCase("index")) {
			    sc.selectByIndex(Integer.parseInt(value));			
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	  public static void takeScreenShot(String filename) throws IOException {
            try {
				File des=new File(System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png");
				TakesScreenshot ts=(TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, des);
			} catch (WebDriverException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
	}
	  
	  public static void mouseHover(WebElement element) {
          try {
        	 waitForElementVisibility(element); 
			 Actions ac=new Actions(driver);
			  ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	  
	  public static void scrollUsingElement(WebElement element, String option) {
           try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			   if (option.equalsIgnoreCase("down")) {
				   js.executeScript("arguments[0].scrollIntoView(false);", element);
			}
			   else if (option.equalsIgnoreCase("up")) {
				   js.executeScript("arguments[0].scrollIntoView(true);", element);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
				}
              }
	  
	  public static void scrollUsingCoordinates(String width,String height) {
            try {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("window.srollBy("+width+","+height+")");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
	}
	  public static void scrollToBottom() {
		  try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			  js.executeScript("window.scrollTo(0,document.body.scrollHeight)" );
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
            
	}
	  public static void scrollToTop() {
		  try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			  js.executeScript("window.scrollTo(0,-document.body.scrollHeight)" );
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
            
	}
	  public static void dragDrop(WebElement source,WebElement target) {
           try {
			Actions ac=new Actions(driver);
			   ac.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	  public static void alert(WebElement element,String option,String confirmOption, String promptOption) {
		waitForElementVisibility(element);
		  if (option.equalsIgnoreCase("simplealert")) {
			 element.click();
			  Alert alert = driver.switchTo().alert();
			  alert.accept();
			  driver.switchTo().defaultContent();
		}
		 else if (option.equalsIgnoreCase("confirmalert")) {
			  element.click();
			  if (confirmOption.equals("accept")) {
				  Alert alert = driver.switchTo().alert();
				  alert.accept();
				  driver.switchTo().defaultContent();
			}
			  else if (confirmOption.equalsIgnoreCase("dismiss")) {
				  Alert alert = driver.switchTo().alert();
				  alert.dismiss();
				  driver.switchTo().defaultContent();
			}
			  
			}
		 else if (option.equalsIgnoreCase("promptalert")) {
			 element.click();
			 if (promptOption.equalsIgnoreCase("accept")) {
				 Alert alert = driver.switchTo().alert();
				  alert.sendKeys("hello");
				  alert.accept();
				  driver.switchTo().defaultContent();
			}
			 else if (promptOption.equals("dismiss")) {
				 Alert alert = driver.switchTo().alert();
				  alert.dismiss();
				  driver.switchTo().defaultContent();
			}
			 
			
		}
		  
	}

	public  void highlightWebElement(WebElement element) {
		try {
			waitForElementVisibility(element);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;');",element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
			
		}
               		
	}
}
