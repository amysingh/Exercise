package com.upgrade.api.pojos;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class BorrowerAPIResponse implements Comparable{

  private LoanAppResumptionInfo loanAppResumptionInfo;
  private List<Object> offers;
  private Object selectedOffer;
  private List<Object> requiredAgreements;
  private List<String> resetOptions;
  private Object originalLoanApp;
  private int type;

  @Override
  public int compareTo(Object o) {
    return  2 - 1;
  }
}
