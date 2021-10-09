package com.upgrade.ui.enums;

import lombok.Getter;

@Getter
public enum BasicInfo {

  FIRST_NAME("borrowerFirstName"),
  LAST_NAME("borrowerLastName"),
  STREET("borrowerStreet"),
  CITY("borrowerCity"),
  STATE("borrowerState"),
  ZIP_CODE("borrowerZipCode"),
  DOB("borrowerDateOfBirth"),
  CO_FIRSTNAME("coBorrowerFirstName"),
  CO_LASTNAME("coBorrowerLastName"),
  CO_DOB("coBorrowerDateOfBirth");

  private String locator;
  private static final String BASIC_INFO_XPATH_LOCATOR = "//input[@name='%s']";


   BasicInfo(String locator) {
    this.locator = locator;
  }

  public String getBasicInfoLocator() {
    return String.format(BASIC_INFO_XPATH_LOCATOR, locator);
  }
}
