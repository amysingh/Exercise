package com.upgrade.api.pojos;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class BorrowerResumptionInfo {

  private String firstName;
  private String maskedEmail;
  private boolean ssnRequired;
  private String state;
  private String email;
}
