package com.gojung.designpattern.state_pattern;

import org.springframework.stereotype.Component;

@Component
public class Frog {

  public String said(Weather weather) {
    return weather.action();
  }
}
