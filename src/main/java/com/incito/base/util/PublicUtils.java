package com.incito.base.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PublicUtils {
  public static DateFormat formart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static DateFormat formart1 = new SimpleDateFormat("yyyy-MM-dd");

  public static DateFormat formart2 = new SimpleDateFormat("HH:mm:ss");

  // 在当前时间戳的基础上加入当前最大值构成编号
  public static String createSequence(String goodNum, int max) {
    // 获取时间字符串
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
    String timestampString = dateFormat.format(new Date());
    // 格式化6位数量编号
    DecimalFormat numformat = new DecimalFormat("######");
    numformat.setMinimumIntegerDigits(6);
    String numString = numformat.format(max + 1);
    String sequenceString = goodNum + timestampString + numString;
    return sequenceString;
  }

  public static Date getCalendarDate(int datenum) {
    Calendar calendar1 = Calendar.getInstance(); // 获得一个日历
    calendar1.setTime(new Date());
    calendar1.add(Calendar.DAY_OF_MONTH, datenum);
    return calendar1.getTime();
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
    day = Integer.parseInt(String.valueOf((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000)));
    if (day < 0) {
      day = 0;
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
  public static int getDayNumForDate(Date startDate, String endDate) {
    int day = 0;
    try {
      day = Integer.parseInt(String.valueOf((formart.parse(endDate).getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000)));
      if (day < 0) {
        day = 0;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return day;
  }

  /**
   * date类型转换成 xxxx年 xx月 xx日 xx时 xx分 xx秒
   * 
   * @param date
   * @param type
   * @return
   */
  public static String getFormartDateForAll(Date date, int type) {
    if (1 == type) {
      return formart1.format(date);
    } else if (2 == type) {
      return formart2.format(date);
    } else {
      return formart.format(date);
    }
  }

  /**
   * date类型转换成 xxxx年 xx月 xx日 xx时 xx分 xx秒
   * 
   * @param date
   * @param type
   * @return
   */
  public static String getFormartDateForAll(String date, int type) {
    try {
      if (1 == type) {
        return formart1.format(formart1.parse(date));
      } else if (2 == type) {
        return formart2.format(formart2.parse(date));
      } else {
        return formart.format(formart.parse(date));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  public static String isNullFormart(Object o) {
    if (null != o) {
      return String.valueOf(o);
    } else {
      return "";
    }
  }
  
  // 计算积分
  public static Double credit(String num, String count, int size) {
    return Math.round((Integer.parseInt(String.valueOf(num)) / (Integer.parseInt(String.valueOf(count)) * size)) * 100) / 100.00;
  }
  
  /**
   * 静态公用方法， 判断字符串是否为null或空串
   * @description: 判断字符串是否为null或空串
   * @param str
   * @return 
   */
  public static boolean isEmpty(String str) {
      if (null == str || "".equals(str)) {
          return true;
      }
      return false;
  }
  
  
  /**
   * 静态公用方法，如果字符串为空，返回0 (处理数据库是double类型，不能为空)
   * @description: 
   * @param str
   * @return 
   */
  public static String DoubleDataDeal(String str){
	if (null == str || "".equals(str)) {
	  str = "0";
	}
	return str;
  } 

  public static void main(String[] args) {
    System.out.println(createSequence("DY", 6));
  }
}
