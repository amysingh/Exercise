package com.upgrade.ui.pages;

import com.upgrade.ui.utils.ActionUtils;
import org.openqa.selenium.WebDriver;


public class CheckRatePage extends BasePage {

  private static final String LOAN_AMOUNT =
      "//*[contains(text(),'Loan Amount')]//preceding-sibling::input[@type ='tel']";
  private static final String LOAN_PURPOSE =
      "//select[contains(@aria-label,'Loan Purpose')]";

  private static final String INVALID_LOAN_AMOUNT_ERROR =
      "//div[contains(text() ,'Please enter loan amount between')]";


  public CheckRatePage(WebDriver driver) {
    super(driver);
  }

  public void setLoanAmount(String loanAmount) {
    ActionUtils.sendValuesByXpath(loanAmount, getDriver(), LOAN_AMOUNT);
  }

  public void setLoanPurpose(String loanPurpose) {
    ActionUtils.selectDropdownByVisibleText(loanPurpose, getDriver(), LOAN_PURPOSE);
  }

  public String getErrorForInvalidLoanAmount() {
    return ActionUtils.getTextByXpath(getDriver(), INVALID_LOAN_AMOUNT_ERROR);
  }

  public void goToBasicInfoPage(String loanAmount, String loanPurpose) {

    setLoanAmount(loanAmount);
    setLoanPurpose(loanPurpose);
    clickRateButton();
  }
}
