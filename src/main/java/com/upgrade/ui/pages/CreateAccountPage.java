package com.upgrade.ui.pages;

import com.upgrade.ui.utils.ActionUtils;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {

  private static final String AGREEMENT_CHECKBOX =
      "//input[@name='agreements' and @type='checkbox']";


  public CreateAccountPage(WebDriver driver) {
    super(driver);
  }

  public void clickAgreementCheckBox() {
    ActionUtils.mouseOverAndClickOnButton(getDriver(), AGREEMENT_CHECKBOX);
  }

  public void gotToOfferPage(String userName , String password){

    setUsername(userName);
    setPassword(password);
    clickAgreementCheckBox();
    clickRateButton();
  }

}
