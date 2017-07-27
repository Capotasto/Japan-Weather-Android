package com.funkyhacker.japanweather.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtil {


  public static String calenderToString(Calendar calendar) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN);
    return format.format(calendar.getTime());
  }


}
