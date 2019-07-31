package com.PostTracking.Tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
public class AddVehicleTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	String os = System.getProperty("os.name").toLowerCase();
	if(os.contains("mac")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Support/chromedriver");
	} else {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Support\\chromedriver");
	}
	
	driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void addVehicle() {
    try {
    	driver.get("http://localhost:8080/");
        driver.manage().window().setSize(new Dimension(1296, 1000));
        driver.findElement(By.linkText("Vehicles")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn-secondary:nth-child(1)")).click();
        {
          WebElement element = driver.findElement(By.cssSelector(".btn-secondary:nth-child(1)"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("txtDescription")).sendKeys("DragaoBaoBao");
        Thread.sleep(1500);
        driver.findElement(By.id("txtMaxVolume")).sendKeys("5000");
        Thread.sleep(1500);
        driver.findElement(By.id("txtMaxWeight")).sendKeys("5000");
        Thread.sleep(1500);
        WebElement selectAvailable =  driver.findElement(By.id("selectAvailable"));
        Select sSelectAvailable = new Select(selectAvailable);
        sSelectAvailable.selectByIndex(0);
        Thread.sleep(1500);
        driver.findElement(By.id("SaveVehicle")).click();
        Thread.sleep(1500);
        String message = driver.findElement(By.id("ErrorMessage")).getText();
        assertEquals("Vehicle saved successfully", message);
        
        Thread.sleep(2000);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
