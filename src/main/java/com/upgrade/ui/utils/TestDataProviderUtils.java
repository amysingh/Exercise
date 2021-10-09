package com.upgrade.ui.utils;

import com.upgrade.ui.constants.AppConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDataProviderUtils {

  /**
   * This class will contain method to read from Excel file
   */


  public static Workbook book;
  public static Sheet sheet;


  public static String TESTDATA_SHEET_PATH =
      System.getProperty("user.dir") + AppConstants.XLS_DATA_PROVIDER_FILE_PATH;


  public static Object[][] getTestData(String sheetName) {

    FileInputStream file = null;
    try {
      file = new FileInputStream(TESTDATA_SHEET_PATH);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      book = WorkbookFactory.create(file);
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    sheet = book.getSheet(sheetName);

    //two dim array:
    Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

    for (int i = 0; i < sheet.getLastRowNum(); i++) {
      for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
        data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
      }
    }

    return data;
  }
}

