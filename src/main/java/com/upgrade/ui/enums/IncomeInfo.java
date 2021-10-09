package com.upgrade.ui.enums;

public enum IncomeInfo {

  IND_INCOME("borrowerIncome"),
  ADDITIONAL_INCOME("borrowerAdditionalIncome");


  private String locator;
  private static final String INCOME_INFO_XPATH_LOCATOR = "//input[@name='%s']";

   IncomeInfo(String locator) {
    this.locator = locator;
  }

  public String getIncomeInfoLocator() {
    return String.format(INCOME_INFO_XPATH_LOCATOR, locator);
  }
}
