package com.upgrade.ui.pages;

import com.upgrade.ui.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

  protected WebDriver driver;
  protected WebDriverWait wait;

  public Page(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(this.driver, TestUtils.IMPLICIT_TIMEOUT);
  }

  public abstract String getPageTitle();

  public abstract String getPageHeader(String xpath);

  public abstract void waitForPageTitle(String title);

  public WebDriver getDriver() {
    return this.driver;
  }

  //This will return instance of any child class with same webdriver instance.
  public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
    TPage childPage = null;
    try {


      childPage = pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
    } catch (Exception e) {
      System.out.println("Exception occurred " + e.getMessage());
    }
    return childPage;
  }
}


