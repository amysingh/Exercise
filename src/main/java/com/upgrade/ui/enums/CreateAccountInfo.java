package com.upgrade.ui.enums;

public enum CreateAccountInfo {

  EMAIL("username"),
  PASSWORD("password");


  private String locator;
  private static final String CREATE_ACCOUNT_INFO_XPATH_LOCATOR = "//input[@name='%s']";

   CreateAccountInfo(String locator) {
    this.locator = locator;
  }

  public String getCreateAccountInfoLocator() {
    return String.format(CREATE_ACCOUNT_INFO_XPATH_LOCATOR, locator);
  }
}

