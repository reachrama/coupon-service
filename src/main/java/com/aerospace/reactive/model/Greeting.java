package com.aerospace.reactive.model;

import lombok.Data;

@Data
public class Greeting {
  private String msg;

  public Greeting(String msg) {
    this.msg = msg;
  }
}
