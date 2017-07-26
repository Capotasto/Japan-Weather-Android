package com.funkyhacker.japanweather.network;

import com.funkyhacker.japanweather.model.JapanWeatherResponse;
import io.reactivex.Observable;
import retrofit2.Retrofit;

public class JapanWeatherRepository {

  private ApiManager.LiveDoorWeatherApi liveDoorWeatherApi;

  public JapanWeatherRepository(Retrofit retrofit) {
    this.liveDoorWeatherApi = retrofit.create(ApiManager.LiveDoorWeatherApi.class);
  }

  public Observable<JapanWeatherResponse> getJapanWeather(String cityNumber) {
    return liveDoorWeatherApi.getWeather(cityNumber);
  }

}
