package com.funkyhacker.japanweather.model;

import java.util.Calendar;

public class Forecast {
  private Calendar date;
  private String dateLabel;
  private String telop;
  private Image image;
  private Temperature temperature;

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public String getDateLabel() {
    return dateLabel;
  }

  public void setDateLabel(String dateLabel) {
    this.dateLabel = dateLabel;
  }

  public String getTelop() {
    return telop;
  }

  public void setTelop(String telop) {
    this.telop = telop;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public Temperature getTemperature() {
    return temperature;
  }

  public void setTemperature(Temperature temperature) {
    this.temperature = temperature;
  }
}
