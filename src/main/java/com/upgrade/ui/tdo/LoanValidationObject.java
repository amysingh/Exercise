package com.upgrade.ui.tdo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class LoanValidationObject {

  private String loanAmount ;
  private String  apr ;
  private String loanTerm;
  private String monthlyPayment;
}
