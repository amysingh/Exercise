package com.upgrade.ui.pages;

import com.upgrade.ui.enums.IncomeInfo;
import com.upgrade.ui.utils.ActionUtils;
import org.openqa.selenium.WebDriver;

public class IncomePage extends BasePage {

  private static final String HOW_MUCH_INCOME_MESSAGE =
      "//h1[contains(text(),'How much money do you make in a year?')]";

  public IncomePage(WebDriver driver) {
    super(driver);
  }

  public String getHowMuchIncomeMessage() {
    return ActionUtils.getTextByXpath(getDriver(), HOW_MUCH_INCOME_MESSAGE);
  }

  public void setIndividualIncome(String incomeField, String incomeXpath) {
    ActionUtils.sendValuesByXpath(incomeField, getDriver(), incomeXpath);
  }

  public void setAdditionalIncome(String incomeField, String incomeXpath) {
    ActionUtils.sendValuesByXpath(incomeField, getDriver(), incomeXpath);
  }

  public void gotToCreateAccountPage(String IndIncome , String additionalIncome){

    setIndividualIncome(IndIncome, IncomeInfo.IND_INCOME.getIncomeInfoLocator());
    setIndividualIncome(additionalIncome,
        IncomeInfo.ADDITIONAL_INCOME.getIncomeInfoLocator());
    clickOnContinueButton();
    clickOnContinueButton();
  }


}
