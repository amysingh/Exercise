package com.upgrade.uitests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.upgrade.ui.constants.AppConstants;
import com.upgrade.ui.listeners.UpgradeEventListener;
import com.upgrade.ui.pages.BasePage;
import com.upgrade.ui.pages.Page;
import com.upgrade.ui.utils.ConfigManager;
import com.upgrade.ui.utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

  protected WebDriver driver;
  protected Page page;
  protected  Properties properties;
  protected ExtentReports extent;
  protected ExtentTest extentTest;
  Logger logger = Logger.getLogger(BaseTest.class);

  @BeforeClass
  public void setupBrowser() {

  if (ConfigManager.getInstance().getBrowser().equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();

    } else if (ConfigManager.getInstance().getBrowser().equalsIgnoreCase("ff")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else {
      logger.warn("No browser is setup ");
    }
    EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
    UpgradeEventListener upgradeEventListener = new UpgradeEventListener();
    eventFiringWebDriver.register(upgradeEventListener);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(TestUtils.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    driver.get(ConfigManager.getInstance().getMainUrl());
    page = new BasePage(driver);
  }


  @AfterMethod
  public void extentEnd(ITestResult result) throws IOException{

    extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
    extent.addSystemInfo("Environment", "QA");

    extentTest = extent.startTest(result.getTestName());


    if(result.getStatus()==ITestResult.FAILURE){

      extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
      extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report

      String screenshotPath = TestUtils.getScreenshot(driver, result.getName());
      extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
      logger.info("Test case Failed "+result.getName());
    }
    else if(result.getStatus()==ITestResult.SKIP){
      extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
    }
    else if(result.getStatus()==ITestResult.SUCCESS){
      extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

    }
    extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
  }

  @AfterClass
  public void endExtent(){
    extent.flush();
    extent.close();
    driver.quit();

  }

}
