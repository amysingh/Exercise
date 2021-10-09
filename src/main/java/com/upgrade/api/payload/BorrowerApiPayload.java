package com.upgrade.api.payload;

import com.upgrade.api.apiutils.ConfigManager;

/**
 *
 * This class will be responsible for generating Payload .
 * if boolean value will be true , it will generate payload with correct values .
 * If boolean value will be false then it will  generate load with wrong LoanApp-uuid
 */

public class BorrowerApiPayload {

  public static BorrowerApiPayLoadBuilder getPayLoad(boolean correctLoanId){

    return correctLoanId == true ? BorrowerApiPayLoadBuilder.builder()
        .loanAppUuid(ConfigManager.getInstance().getCorrectLoanId())
        .skipSideEffects(true)
        .build() : BorrowerApiPayLoadBuilder.builder()
        .loanAppUuid(ConfigManager.getInstance().getWrongLoanId())
        .skipSideEffects(true)
        .build();

  }
}
