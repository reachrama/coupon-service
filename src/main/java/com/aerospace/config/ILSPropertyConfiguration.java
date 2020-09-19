package com.aerospace.config;


import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import lombok.Data;

@ConfigurationProperties(prefix = "ils")
@Data
@Component
public class ILSPropertyConfiguration {

  private Map<String, String> url;
  private final Operator operator = new Operator();
  private final BibData bibData = new BibData();
  private final Nypl nypl = new Nypl();


  @Data
  public static class Operator {
    private Map<String, String> userId;
    private Map<String, String> password;
    private Map<String, String> location;
  }

  @Data
  public static class BibData {
    private Map<String, String> url;
    private Map<String, String> parameter;
  }

  @Data
  public static class Nypl extends InstituteConfig {

  }




}
