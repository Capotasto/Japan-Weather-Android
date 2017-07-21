package com.funkyhacker.japanweather.model;

import java.util.Calendar;
import java.util.List;

public class JapanWeatherResponse {

  private Location location;
  private String title;
  private String link;
  private Calendar publicTime;
  private Description description;
  private List<Forecast> forecasts;
  private List<PinpointLocation> pinpointLocations;
  private Copyright copyright;

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Calendar getPublicTime() {
    return publicTime;
  }

  public void setPublicTime(Calendar publicTime) {
    this.publicTime = publicTime;
  }

  public Description getDescription() {
    return description;
  }

  public void setDescription(Description description) {
    this.description = description;
  }

  public List<Forecast> getForecasts() {
    return forecasts;
  }

  public void setForecasts(List<Forecast> forecasts) {
    this.forecasts = forecasts;
  }

  public List<PinpointLocation> getPinpointLocations() {
    return pinpointLocations;
  }

  public void setPinpointLocations(List<PinpointLocation> pinpointLocations) {
    this.pinpointLocations = pinpointLocations;
  }

  public Copyright getCopyright() {
    return copyright;
  }

  public void setCopyright(Copyright copyright) {
    this.copyright = copyright;
  }
}
