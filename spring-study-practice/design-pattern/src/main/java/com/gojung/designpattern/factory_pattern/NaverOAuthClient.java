package com.gojung.designpattern.factory_pattern;

public class NaverOAuthClient implements OAuthClient {

  @Override
  public OAuthType getOAuthType() {
    return OAuthType.NAVER;
  }

  @Override
  public void authorization() {
    System.out.println("here's NOODLE");
  }
}
