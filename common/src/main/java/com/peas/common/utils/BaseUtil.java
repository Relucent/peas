/*
 * 版权所有 @2014 浙江双琪电子商务有限公司。保留所有权利
 * 双琪电商平台（sqec-plat-pub）
 */
package com.peas.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 请对该类型进行说明，说明它的作用原理及使用注意事项等。
 *
 * @author：Mr.X 2015年3月17日 上午9:22:37
 */
public class BaseUtil {

  private static final String EMPTY_TEXT = "";
  private static final String REGEX_MAIL = "^\\+?[A-Za-z0-9](([-+.]|[_]+)?[A-Za-z0-9]+)*@([A-Za-z0-9]+(\\.|\\-))+[A-Za-z]{2,6}$";
  private static final String REGEX_PHONE = "^(\\([0-9]+\\))?[0-9]{7,8}$";
  private static final String REGEX_MOBILE = "^(\\+[0-9]+)?[0-9]{11}";
  private static final String REGEX_NUM = "^\\d+$";

  /**
   * 验证空白文本信息
   * 
   * @param text
   *        文本
   * @return 是否为空白
   */
  public static boolean emptyText(String text) {
    return text == null || EMPTY_TEXT.equals(text);
  }

  /**
   * 验证邮件
   * 
   * @param mail
   *        邮件文本
   * @return 是否为mail
   */
  public static boolean checkMail(String mail) {
    return baseCheck(mail, REGEX_MAIL);
  }

  /**
   * 验证座机电话
   * 
   * @param phone
   *        电话文本
   * @return 是否为电话
   */
  public static boolean checkPhone(String phone) {
    return baseCheck(phone, REGEX_PHONE);
  }

  /**
   * 验证移动电话
   * 
   * @param mobile
   *        移动电话文本
   * @return 是否为移动电话
   */
  public static boolean checkMobile(String mobile) {
    return baseCheck(mobile, REGEX_MOBILE);
  }

  /**
   * 验证数值
   * 
   * @param num
   *        数值
   * @return 是否为数值
   */
  public static boolean checkNum(String num) {
    return baseCheck(num, REGEX_NUM);
  }

  /*
   * 验证符合规则的字符
   */
  private static boolean baseCheck(String v, String regex) {
    return v != null && v.matches(regex);
  }

  /**
   * 生成32位UUID
   */
  public static String uuid32() {
    return uuid(32);
  }

  /**
   * 生成指定长度的UUID
   * 
   * @param length
   * @return
   */
  public static String uuid(int length) {
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }

  /**
   * 生成商品流水号
   * 
   * @return
   */
  public static String generateGoodsBn() {
    return uuid32();
  }

  /**
   * 生成询价单编号
   * 
   * @return
   */
  public static String generateOfferNo() {
    return uuid(11);
  }

  /**
   * 生成报价单编号
   * 
   * @return
   */
  public static String generateTenderNo() {
    return uuid32();
  }

  // ----------------------------- date util ---------------------------------------------

  private static final String DATE_FORMAT_REGEX = "yyyy-MM-dd";
  private static final String TIME_FORMAT_REGEX = "yyyy-MM-dd HH:mm:ss";
  private static final String CHINESE_FORMAT_REGEX = "MM月dd日";
  private static final String CHINESE_DATE_FORMAT = "yyyy年 MM月 dd日";
  private static final String PACK8_DATE_FORMAT_REGEX = "yyyyMMdd";
  private static final String PACK6_DATE_FORMAT_REGEX = "HHmmss";


  /**
   * 转换日期字符串，格式：MM月dd日
   */
  public static String changeChineseMouthDay(Date date) {
    final DateFormat CHINESE_FORMAT = new SimpleDateFormat(CHINESE_FORMAT_REGEX);
    return CHINESE_FORMAT.format(date);
  }

  /**
   * 转换日期字符串，格式：MM月dd日
   */
  public static String changeChineseDay(Date date) {
    if (date == null) return null;
    final DateFormat CHINESE_FORMAT = new SimpleDateFormat(CHINESE_DATE_FORMAT);
    return CHINESE_FORMAT.format(date);
  }

  public static String getYear(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    return sdf.format(date);
  }

  public static String getMonth(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("MM");
    return sdf.format(date);
  }

  public static String getDay(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd");
    return sdf.format(date);
  }


  /**
   * 转换为日期字符串，格式：yyyy-MM-dd
   */
  public static String changeToDateString(Integer date) {
    if (date == null) return null;
    final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_REGEX);
    return DATE_FORMAT.format(changeIntToDate(date));
  }

  /**
   * 转换为日期字符串，格式：yyyy-MM-dd
   */
  public static String changeDateToString(Date date) {
    if (date == null) return null;
    final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_REGEX);
    return DATE_FORMAT.format(date);
  }

  /**
   * 格式化为形如 20080312 （yyyyMMdd）格式的日期字符串
   * 
   * @param date
   *        Date
   * @return String
   */
  public static String convertToPack8DateString(Date date) {
    final DateFormat dtFormat = new SimpleDateFormat(PACK8_DATE_FORMAT_REGEX);
    if (null == date) return dtFormat.format(new Date());
    return dtFormat.format(date);
  }

  /**
   * 格式化为形如 121212 （HHmmss）格式的日期字符串
   * 
   * @param date Date
   * @return String
   */
  public static String convertToPack6DateString(Date date) {
    final DateFormat dtFormat = new SimpleDateFormat(PACK6_DATE_FORMAT_REGEX);
    if (null == date) return dtFormat.format(new Date());
    return dtFormat.format(date);
  }

  /**
   * 转换为时间字符串，格式：yyyy-MM-dd HH:mm:ss
   */
  public static String changeToTimeString(Integer date) {
    if (date == null) return null;
    return changeDateToTimeString(changeIntToDate(date));
  }

  /**
   * 将秒时转换为时间类型
   */
  public static Date changeToDate(Integer date) {
    if (date == null) return new Date();
    return changeIntToDate(date);
  }

  /*
   * 将整型时间转换为Date类型
   */
  private static Date changeIntToDate(int date) {
    return new Date(date * 1000L);
  }

  /**
   * 将Date转换为秒时
   */
  public static int changeDateToInt(Date date) {
    return (int) (date.getTime() / 1000);
  }

  /**
   * 将字符串的日期转换为int
   */
  public static int changeStringDateToInt(String date) {
    return changeDateToInt(changeStringTimeToDate(date));
  }

  /**
   * 将字符串的时间转换为int
   */
  public static int changeStringTimeToInt(String date) {
    if (emptyText(date)) return 0;
    return changeDateToInt(changeStringTimeToDate(date));
  }

  /**
   * 将字符串的时间转换为date，舍弃时分秒
   */
  public static final Date changeStringDateToDate(String date) {
    final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_REGEX);
    try {
      return DATE_FORMAT.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 将字符串的时间转换为date,带有时分秒
   */
  public static final Date changeStringTimeToDate(String date) {
    final DateFormat DATE_FORMAT = new SimpleDateFormat(TIME_FORMAT_REGEX);
    try {
      return DATE_FORMAT.parse(date);
    } catch (ParseException e) {}
    return null;
  }

  /**
   * 将date时间转化为字符串 格式yyyy-MM-dd
   */
  public static final String changeDateTimeToString(Date date) {
    if (date == null) return null;
    final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_REGEX);
    return DATE_FORMAT.format(date);
  }

  /**
   * 将Date时间转换为字符串 yyyy-MM-dd hh:mm:ss
   * 
   * @param date
   * @return
   */
  public static final String changeDateToTimeString(Date date) {
    if (date == null) return null;
    final DateFormat TIME_FORMAT = new SimpleDateFormat(TIME_FORMAT_REGEX);
    return TIME_FORMAT.format(date);
  }

  /**
   * 获取当前系统时间，格式：yyyy-MM-dd HH:mm:ss
   */
  public static String getCurrentTime() {
    return changeDateToTimeString(getNowDate());
  }

  /**
   * 获得当前系统的秒时数
   */
  public static int getNowSecond() {
    return changeDateToInt(getNowDate());
  }

  public static Date getNowDate() {
    return new Date();
  }

  /**
   * 去掉时分秒
   */
  public static Date exchangeDate(Date d) {
    return changeStringDateToDate(changeDateTimeToString(d));
  }

  /**
   * @param offset
   * @return
   */
  public static Date getDate(int offset) {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, offset);
    return c.getTime();
  }

  /**
   * 获取当前时间的前后某一天，无时分秒
   * 
   * @param offset
   *        游标；前为负数，后为正数
   */
  public static Date getDateByDate(int offset) {
    return exchangeDate(getDate(offset));
  }

  /**
   * 获得当前小时
   */
  public static int getCurrentHour() {
    return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
  }

  public static int isCommonDate(Date d1, Date d2) {
    return d1.compareTo(d2);
  }

  private static final SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

  /**
   * 返回当前时间戳字符串
   * 
   * @return
   */
  public static String getCurTimeStampStr() {
    return timeStampFormat.format(new Date());
  }

  /**
   * 获取当前时间 Date 对象
   *
   * @return
   */
  public static Date getCurDate() {
    return new Date();
  }


  // ----------------- DATE UTIL END -----------------------------

  /**
   * 处理url中的中文参数
   */
  public static String decodeUrl(String value) {
    try {
      return URLDecoder.decode(value, "UTF-8");
    } catch (Exception e) {
      return value;
    }
  }

  // --------------------------- number util ------------------------------------
  /**
   * 获得实际的整数，默认为0
   */
  public static Integer realInt(Integer i) {
    return realInt(i, 0);
  }

  /**
   * 获得实际的整数
   * 
   * @param i
   *        整数
   * @param defval
   *        默认值
   */
  public static Integer realInt(Integer i, int defval) {
    return i == null ? defval : i;
  }

  /**
   * 获得实际的double值，默认值为0
   */
  public static Double readDouble(Double d) {
    return readDouble(d, 0);
  }

  /**
   * 获得实际的double值
   * 
   * @param defval
   *        默认值
   */
  public static Double readDouble(Double d, double defval) {
    return d == null ? defval : d;
  }

  public static BigDecimal changeDoubleForView(BigDecimal d) {
    if (null == d) return new BigDecimal("0.00");
    return d.setScale(2, BigDecimal.ROUND_HALF_UP);
  }


  // --------------------------- number util end ------------------------------------
  public static <T> String join(List<T> list) {
    return join(list, null);
  }

  public static <T> String join(List<T> list, String delimeter) {
    if (list == null) {
      return "null";
    }
    if (delimeter == null) {
      delimeter = ",";
    }
    StringBuffer sb = new StringBuffer();
    int len = list.size();
    for (int i = 0; i < len; i++) {
      if (i > 0) {
        sb.append(delimeter);
      }
      T item = list.get(i);
      sb.append(item == null ? "null" : item.toString());
    }
    return sb.toString();
  }

  public static <T> String join(T[] list) {
    return join(list, null);
  }

  public static <T> String join(T[] list, String delimeter) {
    if (list == null) {
      return "null";
    }
    if (delimeter == null) {
      delimeter = ",";
    }
    StringBuffer sb = new StringBuffer();
    int len = list.length;
    for (int i = 0; i < len; i++) {
      if (i > 0) {
        sb.append(delimeter);
      }
      T item = list[i];
      sb.append(item == null ? "null" : item.toString());
    }
    return sb.toString();
  }

  /**
   * 将邮箱匹配星号
   * 
   * @param email
   * @param index
   * @return fuzzyEmail or null
   */
  public static String buildFuzzyEmail(String email, Integer index) {

    if (StringUtils.isBlank(email)) return null;

    Pattern p = Pattern.compile(REGEX_MAIL);
    Matcher m = p.matcher(email);
    boolean flag = m.matches();
    if (!flag) return null;

    if (index == null) {
      index = 3;
    }

    String[] strs = email.split("@");
    String prefix = strs[0];
    int length = prefix.length();

    StringBuffer newPrefix = new StringBuffer("");

    if (length <= index.intValue()) {
      newPrefix.append(prefix).append("***")/* .append(prefix) */;
    } else {
      newPrefix.append(strs[0].substring(0, 3)).append("***");
    }

    newPrefix.append("@").append(strs[1]);
    System.out.println(newPrefix.toString());
    return newPrefix.toString();
  }

  /**
   * 将手机中间四位匹配星号
   * 
   * @param mobile
   * @param index
   * @return fuzzyMobile or null
   */
  public static String buildFuzzyMobile(String mobile) {

    if (StringUtils.isBlank(mobile)) return null;

    Pattern p = Pattern.compile(REGEX_MOBILE);
    Matcher m = p.matcher(mobile);
    boolean flag = m.matches();
    if (!flag) return null;

    StringBuffer newMobile = new StringBuffer(mobile);
    newMobile.replace(3, 7, "****");

    System.out.println(newMobile.toString());
    return newMobile.toString();
  }

  /**
   * 格式化异常消息
   * 
   * @param throwable
   * @return
   */
  public static String formatStackTrace(Throwable throwable) {
    if (throwable == null) return "";
    String rtn = throwable.getStackTrace().toString();
    try {
      Writer writer = new StringWriter();
      PrintWriter printWriter = new PrintWriter(writer);
      throwable.printStackTrace(printWriter);
      printWriter.flush();
      writer.flush();
      rtn = writer.toString();
      printWriter.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception ex) {}
    return rtn;
  }

  public static void main(String[] args) {
    buildFuzzyMobile("15200018a697");
  }

}
