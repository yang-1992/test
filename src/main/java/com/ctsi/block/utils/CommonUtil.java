package com.ctsi.block.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CommonUtil {
    /**
     * @param obj
     * @return
     * @描述 判断所给是否为空
     */
    public static boolean checkIsNullOrEmpty(Object obj) {
        if (obj instanceof String) {
            return (obj == null || (((String) obj).equals("")) || (((String) obj).equals("null")) || ((String) obj).equals("undefined"));
        } else {
            return obj == null;
        }
    }


    /**
     * 得到当前系统日期
     *
     * @return 当前日期的格式字符串, 日期格式为"yyyy-MM-dd"
     */
    public static String getCurrentDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date today = new Date();
        String tString = df.format(today);
        return tString;
    }

    /**
     * 得到当前系统时间
     *
     * @return 当前时间的格式字符串，时间格式为"HH:mm:ss"
     */
    public static String getCurrentTime() {
        String pattern = "HH:mm:ss";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date today = new Date();
        String tString = df.format(today);
        return tString;
    }

    /**
     * 得到当前系统时间  精确到分
     *
     * @return 当前时间的格式字符串，时间格式为"HH:mm:ss"
     */
    public static String getCurrentTimeFen() {
        String pattern = "HH:mm";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date today = new Date();
        String tString = df.format(today);
        return tString;
    }

    /**
     *
     *      获取时间
     *
     * */
    public static String getTime(){
        return getCurrentDate()+" "+getCurrentTime();
    }

    /**
     *
     *      获取时间
     *
     * */
    public static String getTimeFen(){
        return getCurrentDate()+" "+getCurrentTimeFen();
    }


    /**
     *
     * @return 日期类型
     *
     *  获取当前时间
     */
    public static Date getDate(){
        return CommonUtil.formatStringToDate(getCurrentDate()+" "+getCurrentTime(),"yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 获取当前年
     *
     */
    public static String getYear(){
        String year = "";
        String date = getCurrentDate();
        year = date.split("-")[0];
        return year;
    }

    /**
     * 获取当前月
     *
     */
    public static String getMonth(){
        String month = "";
        String date = getCurrentDate();
        month = date.split("-")[1];
        return month;
    }

    /**
     * 获取当前日
     *
     */
    public static String getDay(){
        String day = "";
        String date = getCurrentDate();
        day = date.split("-")[2];
        return day;
    }

    /**
     * 获取当前季度
     *
     */
    public static String getQuarter(){
        Integer quarter = Integer.valueOf(getMonth());
        quarter = (quarter%3==0 ? quarter/3 :(quarter/3+1));
        return quarter.toString();
    }


    /**
     *
     *      日期转字符
     *
     * */
    public static String formatDateToString(Date time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(time);
    }

    public static String formatDateToString(Timestamp time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(time);
    }


    /**
     *
     *      字符转日期
     *
     * */
    public static Date formatStringToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
            throw new RuntimeException(ex.toString());
        }
    }

    /**
     * String转ZonedDateTime 默认中国上海时区
     * @return
     */
    public static ZonedDateTime convertStr2ZonedTime(String date, String format){

        DateTimeFormatter beijingFormatter = DateTimeFormatter.ofPattern(format).withZone(ZoneId.of("Asia/Shanghai"));
        if(StringUtils.isBlank(date)){
            return null;
        }
        ZonedDateTime beijingDateTime = ZonedDateTime.parse(date, beijingFormatter);

        return beijingDateTime;

    }

    /**
     * date转ZonedDateTime 默认中国上海时区
     * @return
     */
    public static ZonedDateTime convertDate2ZonedTime(Date date){
        String format="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        String dateStr=sdf.format(date);
        return convertStr2ZonedTime(dateStr,format);

    }

    public static void main(String[] args) {
        System.out.println(CommonUtil.convertStr2ZonedTime(CommonUtil.getTimeFen(),"yyyy-MM-dd HH:mm"));
    }

}
