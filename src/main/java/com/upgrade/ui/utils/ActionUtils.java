package com.upgrade.ui.utils;

import lombok.experimental.UtilityClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@UtilityClass
public class ActionUtils {

  Logger logger = Logger.getLogger(ActionUtils.class);


  /**
   * This class will contain all the actions by Webdriver
   */


  public WebElement getElementByXpath(String xpath, WebDriver driver) {
    WebElement element = null;
    try {
      element = driver.findElement(By.xpath(xpath));
    } catch (Exception e) {
      logger.info("element not found " + e.getMessage());
    }
    return element;
  }

  public void sendValuesByXpath(String value, WebDriver driver, String xpath) {
    try {
      getElementByXpath(xpath, driver).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
      getElementByXpath(xpath, driver).sendKeys(value);

    } catch (Exception e) {
      logger.info("element not found " + e.getMessage());
    }
  }

  public void selectDropdownByVisibleText(String text, WebDriver driver, String xpath) {

    try {
      Select dropdown = new Select(getElementByXpath(xpath, driver));
      dropdown.selectByVisibleText(text);
    } catch (Exception e) {
      logger.info("element not found " + e.getMessage());
    }
  }

  public void clickOnButton(WebDriver driver, String xpath) {
    driver.findElement(By.xpath(xpath)).click();

  }

  public void mouseOverAndClickOnButton(WebDriver driver, String xpath) {
    Actions actions = new Actions(driver);
    actions.moveToElement(getElementByXpath(xpath, driver)).click().perform();

  }

  public String getTextByXpath(WebDriver driver, String xpath) {

    return getElementByXpath(xpath, driver).getText();
  }

  public void clickBackButton(WebDriver driver) {
    driver.navigate().back();
  }

  public static void clickOnLink(WebDriver driver, String xpath) {
    getElementByXpath(xpath, driver).click();

  }

  public void clickORadioButton(WebDriver driver, String xpath) {

    Actions actions = new Actions(driver);
    actions.moveToElement(getElementByXpath(xpath, driver)).click().perform();
  }

  public void moveWindowsToLeft(WebDriver driver) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(1000,0)");
  }

  public void moveWindowsToTop(WebDriver driver) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,-1000)");
  }

  public void moveWindowsToRight(WebDriver driver) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(-1000,0)");
  }

  public void moveWindowsToBottom(WebDriver driver) {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000)");
  }
}
