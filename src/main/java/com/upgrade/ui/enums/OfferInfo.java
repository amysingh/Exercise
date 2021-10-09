package com.upgrade.ui.enums;

public enum OfferInfo {

  APR("apr"),
  MONTHLY_PAYMENT("monthlyPayment"),
  TERM("term");


  private final String locator;
  private static final String OFFER_INFO_XPATH_LOCATOR = "//div[@data-auto ='%s']";

   OfferInfo(String locator) {
    this.locator = locator;
  }

  public String getIncomeInfoLocator() {
    return String.format(OFFER_INFO_XPATH_LOCATOR, locator);
  }
}
