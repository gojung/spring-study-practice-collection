package com.gojung.designpattern.state_pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherTest {


  @Test
  void ifSunny() {
    Frog frog = new Frog();
    String res = frog.said(Weather.Sunny);
    assertEquals(Weather.Sunny.message, res);
  }
}