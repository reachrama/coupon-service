package com.aerospace.config;

import java.util.Map;

import lombok.Data;

@Data
public class Patron {

  private Map<String, String> eddId;
  private Map<String, String> crossPartnerId;
}
