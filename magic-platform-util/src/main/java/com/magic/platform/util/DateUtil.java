package com.magic.platform.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-18 09:09
 * @Modified By:
 */
public class DateUtil {

  public static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd";
  public static final String DEFAULT_FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String DEFAULT_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

  public static String formatDate(Long time, String format) throws Exception {
    return formatDate(time, format, Locale.getDefault());
  }

  public static String formatDate(Long time, String format, Locale locale) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
    return sdf.format(new Date(time));
  }

  public static String formatDate(Date date, String format) throws Exception {
    return formatDate(date, format, Locale.getDefault());
  }

  public static String formatDate(Date date, String format, Locale locale) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
    return sdf.format(date);
  }

  public static String formatDate(Date date) throws Exception {
    return formatDate(date, DateUtil.DEFAULT_FORMAT_DATETIME);
  }

  public static Date parseDate(String time) throws Exception {
    return parseDate(time, DateUtil.DEFAULT_FORMAT_DATETIME);
  }

  public static Date parseDate(String time, String format) throws Exception {
    return parseDate(time, format, Locale.getDefault());
  }

  public static Date parseDate(String time, String format, Locale locale) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
    return sdf.parse(time);
  }

  /**
   * 获取指定日期日开始
   * @param date
   * @return
   */
  public static Date getDateBegin(Date date){
    SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DEFAULT_FORMAT_DATE);
    try {
      date = sdf.parse(sdf.format(date));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  /**
   * 获取指定日期的前一天
   * @param date
   * @return
   */
  public static Date getYesterday(Date date){
    Calendar calendar = Calendar.getInstance(); //得到日历
    calendar.setTime(date);
    calendar.add(Calendar.DATE, -1);
    return calendar.getTime();
  }

  /**
   * 获取指定日期的上个月今天
   * @param date
   * @return
   */
  public static Date getLastMonthToday(Date date){
    Calendar calendar = Calendar.getInstance(); //得到日历
    calendar.setTime(date);
    calendar.add(Calendar.MONTH, -1);
    return calendar.getTime();
  }
}
