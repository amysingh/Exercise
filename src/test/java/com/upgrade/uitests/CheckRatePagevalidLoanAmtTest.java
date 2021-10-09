package com.upgrade.uitests;

import com.upgrade.ui.constants.AppConstants;
import com.upgrade.ui.constants.UpgradeAppErrorSuccess;
import com.upgrade.ui.pages.BasicInfoPage;
import com.upgrade.ui.pages.CheckRatePage;
import com.upgrade.ui.utils.TestDataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class will test for valid Loan amount Test with valid Loan purpose
 * Test will read data from excel sheet
 */

public class CheckRatePagevalidLoanAmtTest extends BaseTest {

  protected CheckRatePage checkRatePage;
  protected BasicInfoPage basicInfoPage;



  @BeforeClass
  public void testSetup(){
    checkRatePage =  page.getInstance(CheckRatePage.class);
    basicInfoPage =  page.getInstance(BasicInfoPage.class);

  }

  @DataProvider
  public Object[][] getBasicInfoData() {
    return TestDataProviderUtils.getTestData(AppConstants.CHECK_RATE_WITH_VALID_LOAN_AMT);
  }

  @Test(dataProvider = "getBasicInfoData")
  public void checkRateTest(String loanAmount , String loanPurpose) throws InterruptedException {
    checkRatePage.setLoanAmount(loanAmount);
    checkRatePage.setLoanPurpose(loanPurpose);
    checkRatePage.clickRateButton();
    if(loanPurpose.equalsIgnoreCase("Business")){
      basicInfoPage.clickOnNoThankYou();
    }
    Assert.assertEquals(basicInfoPage.getTextFromBasicPage() , UpgradeAppErrorSuccess.VALID_LOAN_AMOUNT_SUCCESS);
    checkRatePage.moveToMainPage();
    logger.info("Test completed successfully");

  }
}
