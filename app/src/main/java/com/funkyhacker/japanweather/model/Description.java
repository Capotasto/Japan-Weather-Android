package com.funkyhacker.japanweather.model;

import java.util.Calendar;

public class Description {

  private String text;
  private Calendar publicTime;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Calendar getPublicTime() {
    return publicTime;
  }

  public void setPublicTime(Calendar publicTime) {
    this.publicTime = publicTime;
  }
}
