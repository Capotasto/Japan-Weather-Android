package com.funkyhacker.japanweather.model;

public class Temperature {

  private TempDetail min;
  private TempDetail max;

  public TempDetail getMin() {
    return min;
  }

  public void setMin(TempDetail min) {
    this.min = min;
  }

  public TempDetail getMax() {
    return max;
  }

  public void setMax(TempDetail tempDetail) {
    this.max = tempDetail;
  }
}
