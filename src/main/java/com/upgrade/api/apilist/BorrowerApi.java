package com.upgrade.api.apilist;

import static io.restassured.RestAssured.given;

import com.upgrade.api.apiutils.ConfigManager;
import com.upgrade.api.headers.BorrowerApiHeaders;
import com.upgrade.api.specbuilder.SpecBuilder;
import com.upgrade.api.payload.BorrowerApiPayLoadBuilder;
import io.restassured.response.Response;
import java.util.Map;

/**
 *
 * This class contain 2 post overloaded methods
 */

public class BorrowerApi {

  // This method will accept payload builder and Status code
  public static Response post(BorrowerApiPayLoadBuilder borrowerApiPayLoadBuilder ,
                              int statusCode) {


    return given(SpecBuilder.getRequestSpecification())
        .body(borrowerApiPayLoadBuilder)
        .headers(BorrowerApiHeaders.getHeaders())
        .when().post(ConfigManager.getInstance().getEndPoint())
        .then().spec(SpecBuilder.getResponseSpecification(statusCode))
        .extract().response();

  }

  // This will be used for invalid headers , hence Map can be sent  along in parameter form test.
  public static Response post(BorrowerApiPayLoadBuilder borrowerApiPayLoadBuilder,
                              int statusCode, Map<String , String> map) {


    return given(SpecBuilder.getRequestSpecification())
        .body(borrowerApiPayLoadBuilder)
        .headers(map)
        .when().post(ConfigManager.getInstance().getEndPoint())
        .then().spec(SpecBuilder.getResponseSpecification(statusCode))
        .extract().response();

  }


}
