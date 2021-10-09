package com.upgrade.ui.pages;

import com.upgrade.ui.utils.ActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage extends BasePage{

  private static final String PERSONAL_CREDIT_LINE = "//button[@data-auto='secondChanceOption1']";
  private static final String MENU_BAR = "//label[@aria-label ='Open Site Menu']";
  private static final String SIGN_OUT =  "//a[contains(text() ,'Sign Out')]";


  public OfferPage(WebDriver driver) {
    super(driver);
  }

  public void selectUpgradeCard(){

    waitForElementPresent(PERSONAL_CREDIT_LINE);
    driver.findElement(By.xpath(PERSONAL_CREDIT_LINE)).click();
    //ActionUtils.clickOnButton(getDriver(), PERSONAL_CREDIT_LINE);
  }

  public void clickOnMenu(){
    waitForElementPresent(MENU_BAR);
    ActionUtils.clickOnButton(getDriver(), MENU_BAR);
  }

  public void clickOnSignOut(){
    waitForElementPresent(SIGN_OUT);
    ActionUtils.clickOnLink(getDriver(), SIGN_OUT);
  }



}
