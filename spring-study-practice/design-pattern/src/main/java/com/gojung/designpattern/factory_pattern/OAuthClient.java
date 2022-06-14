package com.gojung.designpattern.factory_pattern;

import org.springframework.stereotype.Service;

@Service
public interface OAuthClient {
  OAuthType getOAuthType();
  void authorization();
}
