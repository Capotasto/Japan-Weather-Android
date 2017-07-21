package com.funkyhacker.japanweather.model;

import java.util.List;

public class Copyright {
  private String title;
  private String link;
  private Image image;
  private List<Provider> provider;

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

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public List<Provider> getProvider() {
    return provider;
  }

  public void setProvider(List<Provider> provider) {
    this.provider = provider;
  }
}
