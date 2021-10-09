package com.upgrade.api.payload;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BorrowerApiPayLoadBuilder {

  public String loanAppUuid;
  public boolean skipSideEffects;
}
