package com.PostTracking.Tests;

import org.junit.Test;
import org.junit.Before;
import org.hibernate.sql.Select;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
public class AddVehicleTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Support\\chromedriver.exe");
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
        driver.findElement(By.id("txtDescription")).click();
        driver.findElement(By.id("txtDescription")).sendKeys("DragaoBaoBao");
        driver.findElement(By.id("txtMaxVolume")).sendKeys("5000");
        driver.findElement(By.id("txtMaxWeight")).sendKeys("5000");
        WebElement selectAvailable =  driver.findElement(By.id("selectAvailable"));
        org.openqa.selenium.support.ui.Select sSelectAvailable = new org.openqa.selenium.support.ui.Select(selectAvailable);
        sSelectAvailable.selectByIndex(0);
        driver.findElement(By.id("SaveVehicle")).click();
        
        Thread.sleep(4000);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
  }
}
