package com.funkyhacker.japanweather.network;

import com.funkyhacker.japanweather.model.JapanWeatherResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiManager {

  private static class Holder {
    private static final ApiManager INSTANCE = new ApiManager();
  }

  private ApiManager() {
  }

  public static ApiManager getInstance() {
    return Holder.INSTANCE;
  }

  private static final String JAPAN_WEATHER_URL = "http://weather.livedoor.com/forecast/webservice/";
  private OkHttpClient okHttpClient;
  private Retrofit retrofit;
  private Gson gson;


  public JapanWeatherRepository getJapanWeatherRepository() {
    return new JapanWeatherRepository(provideRetrofit());
  }

  private OkHttpClient provideOkHttpClient() {
    if (okHttpClient != null) {
      return okHttpClient;
    }
    final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    okHttpClient = new OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor)
        .build();

    return okHttpClient;
  }

  private Retrofit provideRetrofit() {
    if (retrofit != null) {
      return retrofit;
    }
    retrofit = new Retrofit.Builder()
        .baseUrl(JAPAN_WEATHER_URL)
        .client(provideOkHttpClient())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(provideGson()))
        .build();

    return retrofit;
  }

  private Gson provideGson() {
    if (gson != null) {
      return gson;
    }
    gson = new GsonBuilder().setLenient()
        .registerTypeAdapter(Calendar.class, new DateTypeDeserializer())
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    return gson;
  }

  public interface LiveDoorWeatherApi {
    @GET("json/v1") Call<JapanWeatherResponse> getWeather(@Query("city") String cityNumber);
  }

  public class DateTypeDeserializer implements JsonDeserializer<Calendar> {
    private final String[] DATE_FORMATS = new String[]{
        //Add any format of data you want to parse
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        "yyyy-MM-dd'T'HH:mm:ss",
        "yyyy-MM-dd",
        "HH:mm"
    };

    @Override
    public Calendar deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context)
        throws JsonParseException {
      for (String format : DATE_FORMATS) {
        try {
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(new SimpleDateFormat(format, Locale.JAPAN).parse(jsonElement.getAsString()));
          return calendar;
        } catch (ParseException e) {
          //ignore and next
        }
      }
      //if there is no match, make this error
      throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
          + "\". Supported formats: \n" + Arrays.toString(DATE_FORMATS));
    }
  }

}
