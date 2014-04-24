package com.incito.base.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * */
public class DateUtil {
  public static DateFormat formart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static DateFormat formart1 = new SimpleDateFormat("yyyy-MM-dd");

  public static DateFormat formart2 = new SimpleDateFormat("HH:mm:ss");

  /**
   * 获取当前时间后 datenum 天
   * */
  public static Date getCalendarDate(int datenum) {
    Calendar calendar1 = Calendar.getInstance(); // 获得一个日历
    calendar1.setTime(new Date());
    calendar1.add(Calendar.DAY_OF_MONTH, datenum);
    return calendar1.getTime();
  }

  /**
   * 获取当前时间后 datenum 天 的时间字符串格式
   * */
  public static String getCalendarStr(int datenum) {
    return formart.format(getCalendarDate(datenum));
  }

  /**
   * 算时间相差的天数
   * 
   * @param startDate
   * @param endDate
   * @return
   */
  public static int getDayNumForDate(Date startDate, Date endDate) {
    int day = 0;
    try {
      Date start = formart.parse(formart.format(startDate));
      Date end = formart.parse(formart.format(endDate));
      day = Integer.parseInt(String.valueOf((end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000)));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return day;
  }

  /**
   * 算时间相差的天数
   * 
   * @param startDate
   * @param endDate
   * @return
   */
  public static int getDayNumForDate(String myDate) {
    int day = 0;
    try {
      Date now = formart.parse(formart.format(new Date()));
      Date my = formart.parse(myDate);
      long time = my.getTime() - now.getTime();
      if (time < 0) {
        day = -1;
      } else {
        day = Integer.parseInt(String.valueOf(time / (24 * 60 * 60 * 1000)));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return day;
  }

}
