package com.upgrade.uitests;

import com.upgrade.ui.constants.AppConstants;
import com.upgrade.ui.enums.BasicInfo;
import com.upgrade.ui.enums.IncomeInfo;
import com.upgrade.ui.pages.BasicInfoPage;
import com.upgrade.ui.pages.CheckRatePage;
import com.upgrade.ui.pages.CreateAccountPage;
import com.upgrade.ui.pages.IncomePage;
import com.upgrade.ui.pages.LoginPage;
import com.upgrade.ui.pages.OfferPage;
import com.upgrade.ui.tdo.LoanValidationObject;
import com.upgrade.ui.utils.ConfigManager;
import com.upgrade.ui.utils.TestDataProviderUtils;
import com.upgrade.ui.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 1. This Test class contain End to End  Web Ui automation Task for positive Flow.
 * 2. Test will read data from Excel file .
 * 3. Negative scenarios can be easily  added
 */

public class EndToEndAccountValidationTest extends BaseTest {

  protected CheckRatePage checkRatePage;
  protected BasicInfoPage basicInfoPage;
  protected IncomePage incomePage;
  protected CreateAccountPage createAccountPage;
  protected OfferPage offerPage;
  protected LoginPage loginpage;

  @BeforeClass
  public void testSetup() {

    checkRatePage = page.getInstance(CheckRatePage.class);
    basicInfoPage = page.getInstance(BasicInfoPage.class);
    incomePage = page.getInstance(IncomePage.class);
    createAccountPage = page.getInstance(CreateAccountPage.class);
    offerPage = page.getInstance(OfferPage.class);
    loginpage = page.getInstance(LoginPage.class);

  }

  @DataProvider
  public Object[][] getBasicInfoData() {
    return TestDataProviderUtils.getTestData(AppConstants.CREATE_ACCOUNT);
  }

  @Test(dataProvider = "getBasicInfoData")
  public void endToEndQaChallengeTest(String loanAmount, String loanPurpose, String firstName,
                                      String lastName,
                                      String street, String city,
                                      String state, String zipCode, String dob, String IndIncome,
                                      String additionalIncome, String emailSuffix,
                                      String password) {

    checkRatePage.goToBasicInfoPage(loanAmount, loanPurpose);
    basicInfoPage.goToIncomePage(firstName,lastName,street,city,state,zipCode,dob);
    incomePage.gotToCreateAccountPage(IndIncome , additionalIncome);
    String userName = firstName + TestUtils.generateRandomNumber() + "@" + emailSuffix;
    createAccountPage.gotToOfferPage(userName , password);
    offerPage.selectUpgradeCard();
    LoanValidationObject loanValidationObjectBeforeSignIn = offerPage.getLoanInfoFromOfferPage();
    offerPage.clickOnMenu();
    offerPage.clickOnSignOut();
    loginpage.logInAndLogout(userName , password);
    LoanValidationObject loanValidationObjectAfterSignIn = loginpage.getLoanInfoFromOfferPage();
    Assert.assertTrue(loanValidationObjectAfterSignIn.equals(loanValidationObjectBeforeSignIn),
        "values does not match");
    logger.info("Test completed successfully "+EndToEndAccountValidationTest.class);

  }

}
