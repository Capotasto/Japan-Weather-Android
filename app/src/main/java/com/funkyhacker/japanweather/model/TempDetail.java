package com.funkyhacker.japanweather.model;

import android.text.TextUtils;

public class TempDetail {
  private String celsius;
  private String fahrenheit;

  public String getCelsius() {
    if (TextUtils.isEmpty(celsius)) {
      return "-";
    }
    return celsius;
  }

  public void setCelsius(String celsius) {
    this.celsius = celsius;
  }

  public String getFahrenheit() {
    if (TextUtils.isEmpty(fahrenheit)) {
      return "-";
    }
    return fahrenheit;
  }

  public void setFahrenheit(String fahrenheit) {
    this.fahrenheit = fahrenheit;
  }
}
