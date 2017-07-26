package com.funkyhacker.japanweather;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import com.funkyhacker.japanweather.databinding.ActivityMainBinding;
import com.funkyhacker.japanweather.model.JapanWeatherResponse;
import com.funkyhacker.japanweather.network.ApiManager;
import com.funkyhacker.japanweather.network.JapanWeatherRepository;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import timber.log.Timber;

public class MainActivity extends RxAppCompatActivity {

  private static final Map<String, String> CITY_MAP = setCityMap();

  private ActivityMainBinding binding;
  private JapanWeatherRepository repository;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setActivity(this);
    repository = ApiManager.getInstance().getJapanWeatherRepository();
  }

  public void onClickShowButton(View view) {
    String selectedValue = binding.citySpinner.getSelectedItem().toString();
    String selectedId = getId(selectedValue);
    //Send Request
    repository.getJapanWeather(selectedId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<JapanWeatherResponse>() {
          @Override public void onSubscribe(@NonNull Disposable d) {
            Timber.d(d.toString());
          }

          @Override public void onNext(@NonNull JapanWeatherResponse response) {
            setTitle(response.getTitle());
            binding.resultText.setText(response.getDescription().getText());
          }

          @Override public void onError(@NonNull Throwable e) {
            Timber.d(e.getMessage());
          }

          @Override public void onComplete() {
            Timber.d("onComplete");
          }
        });

  }

  private String getId(String selected){
    for (Iterator<String> i = CITY_MAP.keySet().iterator(); i.hasNext();) {
      String key = i.next();
      String value = CITY_MAP.get(key);
      if (value.equals(selected)) {
        return key;
      }
    }
    return "0";
  }

  private static Map<String, String> setCityMap() {
    Map<String,String> map = new HashMap<>();
    map.put("011000" ,"稚内");
    map.put("012010" ,"旭川");
    map.put("012020" ,"留萌");
    map.put("013010" ,"網走");
    map.put("013020" ,"北見");
    map.put("013030" ,"紋別");
    map.put("014010" ,"根室");
    map.put("014020" ,"釧路");
    map.put("014030" ,"帯広");
    map.put("015010" ,"室蘭");
    map.put("015020" ,"浦河");
    map.put("016010" ,"札幌");
    map.put("016020" ,"岩見沢");
    map.put("016030" ,"倶知安");
    map.put("017010" ,"函館");
    map.put("017020" ,"江差");
    map.put("020010" ,"青森");
    map.put("020020" ,"むつ");
    map.put("020030" ,"八戸");
    map.put("030010" ,"盛岡");
    map.put("030020" ,"宮古");
    map.put("030030" ,"大船渡");
    map.put("040010" ,"仙台");
    map.put("040020" ,"白石");
    map.put("050010" ,"秋田");
    map.put("050020" ,"横手");
    map.put("060010" ,"山形");
    map.put("060020" ,"米沢");
    map.put("060030" ,"酒田");
    map.put("060040" ,"新庄");
    map.put("070010" ,"福島");
    map.put("070020" ,"小名浜");
    map.put("070030" ,"若松");
    map.put("080010" ,"水戸");
    map.put("080020" ,"土浦");
    map.put("090010" ,"宇都宮");
    map.put("090020" ,"大田原");
    map.put("100010" ,"前橋");
    map.put("100020" ,"みなかみ");
    map.put("110010" ,"さいたま");
    map.put("110020" ,"熊谷");
    map.put("110030" ,"秩父");
    map.put("120010" ,"千葉");
    map.put("120020" ,"銚子");
    map.put("120030" ,"館山");
    map.put("130010" ,"東京");
    map.put("130020" ,"大島");
    map.put("130030" ,"八丈島");
    map.put("130040" ,"父島");
    map.put("140010" ,"横浜");
    map.put("140020" ,"小田原");
    map.put("150010" ,"新潟");
    map.put("150020" ,"長岡");
    map.put("150030" ,"高田");
    map.put("150040" ,"相川");
    map.put("160010" ,"富山");
    map.put("160020" ,"伏木");
    map.put("170010" ,"金沢");
    map.put("170020" ,"輪島");
    map.put("180010" ,"福井");
    map.put("180020" ,"敦賀");
    map.put("190010" ,"甲府");
    map.put("190020" ,"河口湖");
    map.put("200010" ,"長野");
    map.put("200020" ,"松本");
    map.put("200030" ,"飯田");
    map.put("210010" ,"岐阜");
    map.put("210020" ,"高山");
    map.put("220010" ,"静岡");
    map.put("220020" ,"網代");
    map.put("220030" ,"三島");
    map.put("220040" ,"浜松");
    map.put("230010" ,"名古屋");
    map.put("230020" ,"豊橋");
    map.put("240010" ,"津");
    map.put("240020" ,"尾鷲");
    map.put("250010" ,"大津");
    map.put("250020" ,"彦根");
    map.put("260010" ,"京都");
    map.put("260020" ,"舞鶴");
    map.put("270000" ,"大阪");
    map.put("280010" ,"神戸");
    map.put("280020" ,"豊岡");
    map.put("290010" ,"奈良");
    map.put("290020" ,"風屋");
    map.put("300010" ,"和歌山");
    map.put("300020" ,"潮岬");
    map.put("310010" ,"鳥取");
    map.put("310020" ,"米子");
    map.put("320010" ,"松江");
    map.put("320020" ,"浜田");
    map.put("320030" ,"西郷");
    map.put("330010" ,"岡山");
    map.put("330020" ,"津山");
    map.put("340010" ,"広島");
    map.put("340020" ,"庄原");
    map.put("350010" ,"下関");
    map.put("350020" ,"山口");
    map.put("350030" ,"柳井");
    map.put("350040" ,"萩");
    map.put("360010" ,"徳島");
    map.put("360020" ,"日和佐");
    map.put("370000" ,"高松");
    map.put("380010" ,"松山");
    map.put("380020" ,"新居浜");
    map.put("380030" ,"宇和島");
    map.put("390010" ,"高知");
    map.put("390020" ,"室戸岬");
    map.put("390030" ,"清水");
    map.put("400010" ,"福岡");
    map.put("400020" ,"八幡");
    map.put("400030" ,"飯塚");
    map.put("400040" ,"久留米");
    map.put("410010" ,"佐賀");
    map.put("410020" ,"伊万里");
    map.put("420010" ,"長崎");
    map.put("420020" ,"佐世保");
    map.put("420030" ,"厳原");
    map.put("420040" ,"福江");
    map.put("430010" ,"熊本");
    map.put("430020" ,"阿蘇乙姫");
    map.put("430030" ,"牛深");
    map.put("430040" ,"人吉");
    map.put("440010" ,"大分");
    map.put("440020" ,"中津");
    map.put("440030" ,"日田");
    map.put("440040" ,"佐伯");
    map.put("450010" ,"宮崎");
    map.put("450020" ,"延岡");
    map.put("450030" ,"都城");
    map.put("450040" ,"高千穂");
    map.put("460010" ,"鹿児島");
    map.put("460020" ,"鹿屋");
    map.put("460030" ,"種子島");
    map.put("460040" ,"名瀬");
    map.put("471010" ,"那覇");
    map.put("471020" ,"名護");
    map.put("471030" ,"久米島");
    map.put("472000" ,"南大東");
    map.put("473000" ,"宮古島");
    map.put("474010" ,"石垣島");
    map.put("474020" ,"与那国島");
    return map;
  }
}
