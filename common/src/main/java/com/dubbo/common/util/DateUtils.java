package com.dubbo.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Stony on 2016/3/29.
 */
public abstract class DateUtils {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "yyyy_MM";
    /** 返回yyyy-MM-dd HH:mm:ss格式的字符串时间 */
    public static final SimpleDateFormat DATE_TIME_FORMAT_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT);
    /** 返回yyyy-MM-dd格式的字符串时间 */
    public static final SimpleDateFormat DATE_FORMAT_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    /** 返回HH:mm:ss格式的字符串时间 */
    public static final SimpleDateFormat TIME_FORMAT_FORMAT = new SimpleDateFormat(TIME_FORMAT);

    public static final ConcurrentHashMap<String,SimpleDateFormat> PATTERN_CACHES = new ConcurrentHashMap<String,SimpleDateFormat>();
    static {
        PATTERN_CACHES.put(DATE_TIME_FORMAT,DATE_TIME_FORMAT_FORMAT);
        PATTERN_CACHES.put(DATE_FORMAT,DATE_FORMAT_FORMAT);
        PATTERN_CACHES.put(TIME_FORMAT,TIME_FORMAT_FORMAT);
    }


    /** 返回yyyy-MM-dd格式的字符串时间 */
    public static String date2string(Date date){
        return DATE_FORMAT_FORMAT.format(date);
    }
    /** 当前时间返回yyyy-MM-dd格式的字符串时间 */
    public static String dateString(){
        return DATE_FORMAT_FORMAT.format(now());
    }
    /** 返回yyyy-MM-dd HH:mm:ss格式的字符串时间 */
    public static String dateTime2string(Date date){
        return DATE_TIME_FORMAT_FORMAT.format(date);
    }/** 返回当前时间yyyy-MM-dd HH:mm:ss格式的字符串时间 */
    public static String dateTimeString(){
        return DATE_TIME_FORMAT_FORMAT.format(now());
    }
    /** 返回HH:mm:ss格式的字符串时间 */
    public String time2string(Date date) {
        return TIME_FORMAT_FORMAT.format(date);
    }

    public static Date yesterday(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    /** 当前日期 **/
    public static Date now(){
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
    /**
     * 下一天
     * @param date
     * @return
     */
    public static Date nextDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
    public static Date addDay(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }
    public static Date subDay(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, (0 - days));
        return cal.getTime();
    }
    /**
     *
     * @param source
     * @return yyyy-MM-dd
     */
    public static Date string2date(String source){
        try {
            return DATE_FORMAT_FORMAT.parse(source);
        } catch (ParseException e) {
            return now();
        }
    }
    /**
     *
     * @param source
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static Date string2dateTime(String source){
        try {
            return DATE_TIME_FORMAT_FORMAT.parse(source);
        } catch (ParseException e) {
            return now();
        }
    }

    /**
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = PATTERN_CACHES.get(pattern);
        if (sdf == null){
            sdf = new SimpleDateFormat(pattern);
            PATTERN_CACHES.put(pattern,sdf);
        }
        return sdf.format(date);
    }

    /**
     *
     * @param beginDate yyyy-MM-dd
     * @param endDate  yyyy-MM-dd
     * @param includeEndDate 是否包含结束日期
     * @return {@link List}
     */
    public static List<String> getDateRangeList(String beginDate, String endDate, boolean includeEndDate){
        List<String> list = new ArrayList<String>();
        if(beginDate == null || beginDate.length() == 0){
            return list;
        }
        SimpleDateFormat format = DATE_FORMAT_FORMAT;
        try {
            Date beginD = format.parse(beginDate);
            Date endD = null;
            if(endDate == null || endDate.length() == 0){
                endD = now();
            }else{
                endD = format.parse(endDate);
            }

            Calendar cal = Calendar.getInstance();
            //倒叙 不包含 endDate
            if(beginD.getTime() > endD.getTime()){
                cal.setTime(beginD);
                while(cal.getTime().getTime() > endD.getTime()){
                    list.add(date2string(cal.getTime()));
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                if(includeEndDate){
                    list.add(endDate);
                }
            }else{
                cal.setTime(beginD);
                while(cal.getTime().getTime() < endD.getTime()){
                    list.add(date2string(cal.getTime()));
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                }
                if(includeEndDate){
                    list.add(endDate);
                }
            }
        } catch (Exception e) {
            if(list.size() > 0) list.clear();
        }
        return list;
    }
    /**
     *
     * @param beginDate yyyy-MM-dd
     * @param endDate yyyy-MM-dd default {@link #now() }
     * @return 步进为天，不包含 endDate
     */
    public static List<String> getDateRangeList(String beginDate, String endDate){
        return getDateRangeList(beginDate,endDate,false);
    }

    public static Timestamp getCurrentTime() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 算两个日期相差的小时数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static long dateDiff(Date startTime, Date endTime){
        //按照传入的格式生成一个simpledateformate对象
        long hour = 0;
        try {
            long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
            long nh = 1000 * 60 * 60;//一小时的毫秒数
            //long nm = 1000*60;//一分钟的毫秒数
            //long ns = 1000;//一秒钟的毫秒数long diff;try {
            //获得两个时间的毫秒时间差异
            long diff = startTime.getTime() - endTime.getTime();
            //long day = diff / nd;//计算差多少天
            hour = diff % nd / nh;//计算差多少小时
            //long min = diff % nd % nh / nm;//计算差多少分钟
            //long sec = diff % nd % nh % nm / ns;//计算差多少秒//输出结果
        }catch (Exception e){
            e.printStackTrace();
        }
        return hour;
    }
    
    
    /**
     * 时间比较大小
     * @param bigDate
     * @param smallDate
     * @return
     */
    public static Boolean compareDate(String bigDate, String smallDate) {
        boolean b=false;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date dt1 = df.parse(bigDate);
            Date dt2 = df.parse(smallDate);
            if (dt1.getTime() >= dt2.getTime()) {
                b=true;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return b;
    }


    public static int getTimelen(String timelen){
        int min=0;
        String strs[] = timelen.split(":");
        if (strs[0].compareTo("0") > 0) {
            min+=Integer.valueOf(strs[0])*60*60;//秒
        }
        if(strs[1].compareTo("0")>0){
            min+=Integer.valueOf(strs[1])*60;
        }
        if(strs[2].compareTo("0")>0){
            min+=Math.round(Float.valueOf(strs[2]));
        }
        return min;
    }
}
