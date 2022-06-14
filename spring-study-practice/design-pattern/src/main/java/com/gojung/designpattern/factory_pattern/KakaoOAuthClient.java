package com.gojung.designpattern.factory_pattern;

import org.springframework.stereotype.Service;

@Service
public class KakaoOAuthClient implements OAuthClient {

  @Override
  public OAuthType getOAuthType() {
    return OAuthType.KAKAO;
  }

  @Override
  public void authorization() {
    System.out.println("here's BREAD");
  }
}
