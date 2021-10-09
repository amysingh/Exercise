package com.upgrade.uitests;

import com.upgrade.ui.constants.AppConstants;
import com.upgrade.ui.constants.UpgradeAppErrorSuccess;
import com.upgrade.ui.pages.CheckRatePage;
import com.upgrade.ui.utils.TestDataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class will test for invalid amount Test with valid Loan purpose
 * Test will read data from excel sheet
 */

public class CheckRatePageInvalidLoanAmtTest extends BaseTest {

  protected CheckRatePage checkRatePage;

  @BeforeClass
  public void testSetup(){
    checkRatePage =  page.getInstance(CheckRatePage.class);
  }

  @DataProvider
  public Object[][] getBasicInfoData() {
    return TestDataProviderUtils.getTestData(AppConstants.CHECK_RATE_WITH_INVALID_LOAN_AMT);
  }

  @Test(dataProvider = "getBasicInfoData")
  public void checkRateTest(String loanAmount , String loanPurpose)  {
    checkRatePage.setLoanAmount(loanAmount);
    checkRatePage.setLoanPurpose(loanPurpose);
    checkRatePage.clickRateButton();
    Assert.assertEquals(checkRatePage.getErrorForInvalidLoanAmount() , UpgradeAppErrorSuccess.INVALID_LOAN_AMOUNT_ERROR);
    logger.info("Test completed successfully" +CheckRatePageInvalidLoanAmtTest.class);

  }
}
