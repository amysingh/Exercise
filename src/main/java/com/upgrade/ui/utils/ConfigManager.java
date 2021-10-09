package com.upgrade.ui.utils;

import com.upgrade.common.PropertyUtils;
import com.upgrade.ui.constants.AppConstants;
import org.apache.log4j.Logger;

import java.util.Properties;

public class ConfigManager {
  private final Properties properties;
  private static ConfigManager configManager;
  Logger logger = Logger.getLogger(ConfigManager.class);

  private ConfigManager() {
    properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + AppConstants.PROPERTY_FILE_PATH);
  }

  public static ConfigManager getInstance() {
    if (configManager == null) {
      configManager = new ConfigManager();
    }
    return configManager;
  }

  public String getBrowser() {
    return properties.getProperty("browser");
  }

  public String getLoginUrl() {
    return properties.getProperty("loginUrl");
  }

  public String getMainUrl() {
    return properties.getProperty("mainUrl");
  }

}

