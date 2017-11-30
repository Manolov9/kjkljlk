package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Jj {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://dev.embodee.com/gbuilder/index.html?garment=881257&rules=temp";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJj() throws Exception {
    driver.get(baseUrl + "/gbuilder/index.html?garment=881257&rules=temp");
    assertEquals("Text", driver.findElement(By.id("Text")).getText());
    driver.findElement(By.id("Text")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("Text"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("Front Name", driver.findElement(By.xpath("//div[@id='heading_sel_4']/div/div/span")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='heading_front_upper_name']/div/div/span"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("Straight Name", driver.findElement(By.xpath("//div[@id='heading_front_upper_name']/div/div/span")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='heading_front_upper_name']/div/div/span"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div[@id='heading_front_upper_name']/div/div/span")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//ul[@id='subtabs_front_upper_name']/li/div"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("Name", driver.findElement(By.xpath("//ul[@id='subtabs_front_upper_name']/li/div")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
