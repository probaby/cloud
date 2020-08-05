package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/5 9:35
 */

public class DateTransfer {
    // 一天指定时间执行一次、
    public void time1(String hour,String minu,String seconds){
//        String corn = "0 0 12 * * ?
    }

    // 一天指定时间执行一次、
    public void time(String hour,String minu,String seconds){
//        String corn = "0 0 12 * * ?
    }
    // 一天周期性执行

    public static void everyMinu(){

    }

    /**
     * 日期转化为cron表达式
     *
     * @param date
     * @return
     */
    public static String getCron(java.util.Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return fmtDateToStr(date, dateFormat);
    }

    /**
     * cron表达式转为日期
     *
     * @param cron
     * @return
     */
    public static Date getCronToDate(String cron) throws ParseException {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        date = sdf.parse(cron);
        return date;
    }

    /**
     * Description:格式化日期,String字符串转化为Date
     *
     * @param date
     * @param dtFormat 例如:yyyy-MM-dd HH:mm:ss yyyyMMdd
     * @return
     */
    public static String fmtDateToStr(Date date, String dtFormat) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
        String str = dateFormat.format(date);
        return str;
    }


    public static Date fmtStringToDate(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        date = format.parse(time);
        return date;
    }
}
