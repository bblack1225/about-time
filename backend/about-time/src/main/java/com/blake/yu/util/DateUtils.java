package com.blake.yu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {}

    /**
     * Parse Default Pattern yyyy/MM/dd
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateString) throws ParseException {
        return parse(dateString, null);
    }

    public static Date parse(String dateString, String pattern) throws ParseException {

        SimpleDateFormat sdf;
        if(pattern != null) {
            sdf = new SimpleDateFormat(pattern);
        }else {
            sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        }

        return sdf.parse(dateString);
    }

    /**
     * Format Default Pattern yyyy/MM/dd
     * @param date
     * @return
     * @throws ParseException
     */
    public static String format(Date date){
        return format(date, null);
    }

    public static String format(Date date, String pattern){

        SimpleDateFormat sdf;
        if(pattern != null) {
            sdf = new SimpleDateFormat(pattern);
        }else {
            sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        }

        return sdf.format(date);
    }
}
