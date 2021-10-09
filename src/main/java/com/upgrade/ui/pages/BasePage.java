package com.upgrade.ui.pages;

import com.upgrade.ui.enums.CreateAccountInfo;
import com.upgrade.ui.enums.OfferInfo;
import com.upgrade.ui.tdo.LoanValidationObject;
import com.upgrade.ui.utils.ActionUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * THis is Base page class , which contains all the common methods for child classes
 */

public class BasePage extends Page {

  Logger logger = Logger.getLogger(BasePage.class);
  private static final String CONTINUE_BUTTON = "//button[contains(text(),'Continue')]";
  private static final String CHECK_RATE_BUTTON =
      "//button[contains(text(),'Check')]";
  private static final String LOAN_AMOUNT = "//span[@data-auto ='amount']";


  public BasePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public String getPageTitle() {
    return getDriver().getTitle();
  }

  @Override
  public String getPageHeader(String xpath) {
    return ActionUtils.getElementByXpath(xpath, getDriver()).getText();
  }

  public void waitForElementPresent(String xpath) {
    try {

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    } catch (Exception e) {

      logger.info("element is not present " + e.getMessage());
    }
  }

  @Override
  public void waitForPageTitle(String title) {
    try {
      wait.until(ExpectedConditions.titleContains(title));
    } catch (Exception e) {
      logger.info("element is not present " + e.getMessage());
    }
  }

  public void moveToMainPage() {
    ActionUtils.clickBackButton(getDriver());
  }

  public void clickOnContinueButton() {
    waitForElementPresent(CONTINUE_BUTTON);
    ActionUtils.clickOnButton(getDriver(), CONTINUE_BUTTON);
  }

  public void clickRateButton() {
    ActionUtils.clickOnButton(getDriver(), CHECK_RATE_BUTTON);
  }

  public void setUsername(String userNameField) {
    ActionUtils.sendValuesByXpath(userNameField, getDriver(),
        CreateAccountInfo.EMAIL.getCreateAccountInfoLocator());
  }

  public void setPassword(String passwordField) {
    ActionUtils.sendValuesByXpath(passwordField, getDriver(),
        CreateAccountInfo.PASSWORD.getCreateAccountInfoLocator());
  }

  //This method will get all Loan amount info from UI
  public LoanValidationObject getLoanInfoFromOfferPage() {

    LoanValidationObject loanValidationObject = LoanValidationObject.builder()
        .loanAmount(ActionUtils.getTextByXpath(getDriver(), LOAN_AMOUNT))
        .apr(ActionUtils.getTextByXpath(getDriver(),
            OfferInfo.APR.getIncomeInfoLocator()))
        .loanTerm(ActionUtils.getTextByXpath(getDriver(), OfferInfo.TERM.getIncomeInfoLocator()))
        .monthlyPayment(ActionUtils.getTextByXpath(getDriver(),
            OfferInfo.MONTHLY_PAYMENT.getIncomeInfoLocator()))
        .build();

    return loanValidationObject;
  }


}
