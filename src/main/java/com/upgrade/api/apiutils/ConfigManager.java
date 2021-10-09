package com.upgrade.api.apiutils;

import com.upgrade.common.PropertyUtils;
import com.upgrade.ui.constants.AppConstants;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * This class is responsible for reading  API Properties file form the given path
 */

public class ConfigManager {
  private final Properties properties;
  private static ConfigManager configManager;
  Logger logger = Logger.getLogger(ConfigManager.class);

  private ConfigManager() {
    properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + AppConstants.PROPERTY_FILE_PATH_API);
  }

  public static ConfigManager getInstance() {
    if (configManager == null) {
      configManager = new ConfigManager();
    }
    return configManager;
  }

  public String getCorrectLoanId() {
    return properties.getProperty("correctLoanAppUuid");
  }

  public String getWrongLoanId() {
    return properties.getProperty("wrongLoanAppUuid");
  }

  public String getBaseUrl() {
    return properties.getProperty("baseUri");
  }

  public String getBasePath() {
    return properties.getProperty("basePath");
  }

  public String getEndPoint() {
    return properties.getProperty("endPoint");

  }
}

