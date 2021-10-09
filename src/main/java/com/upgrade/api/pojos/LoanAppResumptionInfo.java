package com.upgrade.api.pojos;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class LoanAppResumptionInfo {
  private int loanAppId;
  public String loanAppUuid;
  private String referrer;
  private String status;
  private String productType;
  private String sourceSystem;
  private int desiredAmount;
  private BorrowerResumptionInfo borrowerResumptionInfo;
  private Object coBorrowerResumptionInfo;
  private boolean turnDown;
  private boolean hasLogin;
  private List<Object> availableAppImprovements;
  private Object cashOutAmount;
  private boolean canAddCollateral;
  private Object rewardProgramId;
  private Object rewardProgramCode;
  private Object addon;
  private Object isMobileDiscountApplied;
  private boolean checkingDiscountAvailable;
}
