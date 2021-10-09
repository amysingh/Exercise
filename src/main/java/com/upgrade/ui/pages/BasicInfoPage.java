package com.upgrade.ui.pages;

import com.upgrade.ui.enums.BasicInfo;
import com.upgrade.ui.utils.ActionUtils;
import jdk.internal.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasicInfoPage extends BasePage {

  private static final String LETS_GET_STARTED =
      "//*[contains(text(),'get started with some basic information')]";
  private static final String NO_THANK_YOU =
      "//a[contains(text(),'No thanks, I would like to continue with Upgrade')]";
  private static final String CO_JOIN_RADIO_BUTTON =
      "//input[@name='jointApplicationToggle' and @value='true']";


  public BasicInfoPage(WebDriver driver) {
    super(driver);
  }

  public void setBasicInfoFieldValue(String fieldName, String fieldXpath) {
    ActionUtils.sendValuesByXpath(fieldName, getDriver(), fieldXpath);
  }

  public String getTextFromBasicPage() {
    return ActionUtils.getTextByXpath(getDriver(), LETS_GET_STARTED);
  }

  public void clickOnNoThankYou() throws InterruptedException {
    ActionUtils.clickOnButton(getDriver(), NO_THANK_YOU);
  }

  public void clickCoJoinButton() {
    ActionUtils.clickORadioButton(getDriver(), CO_JOIN_RADIO_BUTTON);
  }

  public void goToIncomePage(String firstName , String lastName , String street , String city ,
                             String state, String zipCode , String dob){


    setBasicInfoFieldValue(firstName, BasicInfo.FIRST_NAME.getBasicInfoLocator());
    setBasicInfoFieldValue(lastName, BasicInfo.LAST_NAME.getBasicInfoLocator());
    setBasicInfoFieldValue(street, BasicInfo.STREET.getBasicInfoLocator());
    setBasicInfoFieldValue(city, BasicInfo.CITY.getBasicInfoLocator());
    setBasicInfoFieldValue(state, BasicInfo.STATE.getBasicInfoLocator());
    setBasicInfoFieldValue(zipCode, BasicInfo.ZIP_CODE.getBasicInfoLocator());
    setBasicInfoFieldValue(dob, BasicInfo.DOB.getBasicInfoLocator());
    clickOnContinueButton();
  }
}
