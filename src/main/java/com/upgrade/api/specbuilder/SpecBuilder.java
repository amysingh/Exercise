package com.upgrade.api.specbuilder;


import com.upgrade.api.apiutils.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class SpecBuilder {

  public static RequestSpecification getRequestSpecification(){

    return  new RequestSpecBuilder()
        .setBaseUri(ConfigManager.getInstance().getBaseUrl())
        .setBasePath(ConfigManager.getInstance().getBasePath())
        .log(LogDetail.ALL).build();
  }

  public static ResponseSpecification getResponseSpecification(int statusCode){

    return new ResponseSpecBuilder()
        .expectContentType(ContentType.JSON)
        .expectStatusCode(statusCode)
        .log(LogDetail.ALL).build();
  }



}
