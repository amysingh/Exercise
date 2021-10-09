package com.upgrade.uitests;

import com.upgrade.ui.constants.AppConstants;
import com.upgrade.ui.constants.UpgradeAppErrorSuccess;
import com.upgrade.ui.enums.BasicInfo;
import com.upgrade.ui.pages.BasicInfoPage;
import com.upgrade.ui.pages.CheckRatePage;
import com.upgrade.ui.pages.IncomePage;
import com.upgrade.ui.utils.TestDataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class will test positive flow for co-applicant form test
 */

public class BasicInfoCoJoinTest extends BaseTest{

  protected BasicInfoPage basicInfoPage;
  protected CheckRatePage checkRatePage;
  protected IncomePage incomePage;

  @BeforeClass
  public void testSetup(){
    checkRatePage =  page.getInstance(CheckRatePage.class);
    basicInfoPage =  page.getInstance(BasicInfoPage.class);
    incomePage =  page.getInstance(IncomePage.class);


  }

  @DataProvider
  public Object[][] getBasicInfoData(){
     return TestDataProviderUtils.getTestData(AppConstants.BASIC_INFO_CO_JOIN_SHEET_NAME);


  }

  @Test(dataProvider = "getBasicInfoData" )
  public void basicInfoCoJoinTest(String firstName , String lastName , String street , String city ,
                            String state , String zipCode , String dob , String coFirstName,
                            String coLastName, String coDob) {
    checkRatePage.setLoanAmount("10000");
    checkRatePage.setLoanPurpose("Debt Consolidation");
    checkRatePage.clickRateButton();
    basicInfoPage.clickCoJoinButton();
    basicInfoPage.setBasicInfoFieldValue(firstName , BasicInfo.FIRST_NAME.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(lastName , BasicInfo.LAST_NAME.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(street , BasicInfo.STREET.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(city , BasicInfo.CITY.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(state , BasicInfo.STATE.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(zipCode, BasicInfo.ZIP_CODE.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(dob , BasicInfo.DOB.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(coFirstName , BasicInfo.CO_FIRSTNAME.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(coLastName , BasicInfo.CO_LASTNAME.getBasicInfoLocator());
    basicInfoPage.setBasicInfoFieldValue(coDob , BasicInfo.CO_DOB.getBasicInfoLocator());
    basicInfoPage.clickOnContinueButton();
    Assert.assertEquals(incomePage.getHowMuchIncomeMessage() , UpgradeAppErrorSuccess.AFTER_BASIC_INFO_SUCCESS_MESSAGE);
    logger.info("Test completed successfully");

  }

}
