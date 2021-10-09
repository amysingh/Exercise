package com.upgrade.ui.pages;

import com.upgrade.ui.utils.ActionUtils;
import com.upgrade.ui.utils.ConfigManager;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private static final String SIGN_IN_BUTTON = "//button[@data-auto='login']";


  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void navigateToLoginPage(String loginUrl) {

    getDriver().get(loginUrl);
  }

  public void clickSigIn() {
    ActionUtils.clickOnButton(getDriver(), SIGN_IN_BUTTON);
  }

  public void  logInAndLogout(String userName , String password){

    navigateToLoginPage(ConfigManager.getInstance().getLoginUrl());
    setUsername(userName);
    setPassword(password);
    clickSigIn();
  }
}
