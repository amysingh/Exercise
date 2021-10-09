package com.upgrade.ui.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
  CODE_200(200, ""),
  CODE_201(201, ""),
  CODE_400(400, "Missing required field: name"),
  CODE_404(404, "Invalid  Loan App UUID"),
  CODE_500(500, "INTERNAL SERVER ERROR");
  private final int code;
  private  final String msg;

  StatusCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}

