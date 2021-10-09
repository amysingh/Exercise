package com.upgrade.ui.pages;

import com.upgrade.api.pojos.BorrowerAPIResponse;

import java.sql.Struct;
import java.util.Comparator;

public class PracticeClass {

  static BorrowerAPIResponse borrowerAPIResponse1;
  static  BorrowerAPIResponse borrowerAPIResponse2;

  public static void main(String[] args) {

    Runnable runnable = () -> System.out.println("hello runnable");

    new Thread(runnable).start();

    Comparator<BorrowerAPIResponse> comparator = (i , k ) -> i.compareTo(k);

    System.out.println( comparator.compare(borrowerAPIResponse1,borrowerAPIResponse2));
  }
}
