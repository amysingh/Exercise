package com.upgrade.apitest;

import static io.restassured.RestAssured.given;

import com.upgrade.api.apilist.BorrowerApi;
import com.upgrade.api.apiutils.ConfigManager;
import com.upgrade.api.headers.BorrowerApiHeaders;
import com.upgrade.api.payload.BorrowerApiPayload;
import com.upgrade.api.pojos.BorrowerAPIResponse;
import com.upgrade.api.specbuilder.SpecBuilder;
import com.upgrade.ui.constants.UpgradeAppErrorSuccess;
import com.upgrade.ui.enums.StatusCode;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;


/**
 * Test contain in this file
 * 1.Post API with valid Loan ID
 * 2. Post API with invalid Loan ID
 * 3. Invalid method (GET) instead of POST
 * 4. Invalid Headers with POST request
 * 5.POST request with No pay Load
 */

public class UpgradeApiTest extends BaseApiTest {

  @Test()
  public void upgradeAPIWithValidLoanAppIdTest() {

    BorrowerAPIResponse borrowerAPIResponse =
        BorrowerApi.post(BorrowerApiPayload.getPayLoad(true), StatusCode.CODE_200.getCode()).as(BorrowerAPIResponse.class);
    Assert.assertEquals(borrowerAPIResponse.getLoanAppResumptionInfo().getProductType(),
        "PERSONAL_LOAN", UpgradeAppErrorSuccess.API_LOAN_APP_ID_ERROR_MESSAGE);


  }

  @Test()
  public void upgradeAPIWithInValidLoanAppIdTest() {

    BorrowerApi.post(BorrowerApiPayload.getPayLoad(false), StatusCode.CODE_404.getCode());
  }


  @Test()
  public void upgradeAPIWithInvalidMethodTest() {

    given(SpecBuilder.getRequestSpecification())
        .headers(BorrowerApiHeaders.getHeaders())
        .body(BorrowerApiPayload.getPayLoad(true))
        .when().get(ConfigManager.getInstance().getEndPoint())
        .then()
        .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
  }

  @Test()
  public void upgradeAPIWithInvalidHeadersTest() {

    Map<String, String> apiHeaders = BorrowerApiHeaders.getHeaders("Wrong-coding-challenge" ,
        "12341232123223");
    BorrowerApi.post(BorrowerApiPayload.getPayLoad(true), StatusCode.CODE_500.getCode()
        , apiHeaders);
  }

  @Test()
  public void upgradeAPIWithNoPayLoadTest() {
    given(SpecBuilder.getRequestSpecification())
        .headers(BorrowerApiHeaders.getHeaders())
        .when().post(ConfigManager.getInstance().getEndPoint())

        .then()
        .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

  }
}

