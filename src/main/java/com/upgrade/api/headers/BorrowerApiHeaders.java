package com.upgrade.api.headers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This class  contain  two  overloaded  methods  , which will return headers needed for
 * resume API
 */

public class BorrowerApiHeaders {

  private static  Map<String, String> apiHeaders;

  public  static  Map<String,String> getHeaders(){

    String uuid = UUID.randomUUID().toString();
    apiHeaders = new HashMap<>();
    apiHeaders.put("x-cf-source-id", "coding-challenge");
    apiHeaders.put("x-cf-corr-id", uuid);
    apiHeaders.put("Content-Type", "application/json");

    return apiHeaders;
  }

  // This  over loaded method will be used to send Wrong headers
  public  static  Map<String,String> getHeaders(String wrongCfSource ,
                                                String wrongUUID ){

    String uuid = UUID.randomUUID().toString();
    apiHeaders = new HashMap<>();
    apiHeaders.put(wrongCfSource, "coding-challenge");
    apiHeaders.put(wrongUUID, uuid);
    apiHeaders.put("Content-Type", "application/json");
    return apiHeaders;

  }
}
