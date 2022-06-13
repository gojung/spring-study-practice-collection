package com.gojung.designpattern.state_pattern;

public enum Weather {
  Rainy("dont cry for me") {
    @Override
    public String action() {
      return Rainy.message;
    }
  },
  Sunny("nighty night") {
    @Override
    public String action() {
      return Sunny.message;
    }
  };

  public String message;

  Weather(String s) {
    this.message = s;
  }

  public abstract String action();
}
