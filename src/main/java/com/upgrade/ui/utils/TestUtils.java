package com.upgrade.ui.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class TestUtils {

  /**
   * This class will contain  supporting util methods  for any application to be used .
   */

  public final int IMPLICIT_TIMEOUT = 20;


  public Long generateRandomNumber() {

    long leftLimit = 1L;
    long rightLimit = 10000L;
    return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
  }

  public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String destination =
        System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
        + ".png";
    File finalDestination = new File(destination);
    FileUtils.copyFile(source, finalDestination);
    return destination;

  }
}
