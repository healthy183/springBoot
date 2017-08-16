package com.kang.boot.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */

public class DateUtil {
    public static final String DEFAULT_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_MONTH_PATTERN = "yyyy-MM";
    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String[] DAY_OF_WEEK_NAMES = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    public static final String[] QUARTER_OF_YEAR_NAMES = new String[]{"一季度", "二季度", "三季度", "四季度"};
    public static final String[] MONTH_OF_YEAR_NAMES = new String[]{"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("yyyyMMdd");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormat.forPattern("yyyyMMddHHmmss");

    public DateUtil() {
    }

    public static void main(String[] args) {
    }

    public static int getYear(Date inputDate) {
        DateTime dateTime = new DateTime(inputDate.getTime());
        return dateTime.year().get();
    }

    public static int getDayOfMonth(Date inputDate) {
        DateTime dateTime = new DateTime(inputDate.getTime());
        return dateTime.dayOfMonth().get();
    }

    public static int getMonthOfYear(Date inputDate) {
        DateTime dateTime = new DateTime(inputDate.getTime());
        return dateTime.monthOfYear().get();
    }

    public static String getMonthOfYearName(Date inputDate) {
        return MONTH_OF_YEAR_NAMES[getMonthOfYear(inputDate) - 1];
    }

    public static int getWeekOfYear(Date inputDate) {
        DateTime dateTime = new DateTime(inputDate.getTime());
        return dateTime.weekOfWeekyear().get();
    }

    public static int getDayOfWeek(Date inputDate) {
        DateTime dateTime = new DateTime(inputDate.getTime());
        return dateTime.dayOfWeek().get();
    }

    public static String getDayOfWeekName(Date inputDate) {
        return DAY_OF_WEEK_NAMES[getDayOfWeek(inputDate) - 1];
    }

    public static int getQuarterOfYear(Date inputDate) {
        int month = getMonthOfYear(inputDate);
        return (month - 1) / 3 + 1;
    }

    public static String getQuarterOfYearName(Date inputDate) {
        return QUARTER_OF_YEAR_NAMES[getQuarterOfYear(inputDate) - 1];
    }

    public static String getDateTimeBetween(Date startDate, Date endDate) {
        DateTime start = new DateTime(startDate.getTime());
        DateTime end = new DateTime(endDate.getTime());
        Period period = new Period(start, end);
        String result = period.getDays() + "天" + period.getHours() + "小时" + period.getMinutes() + "分" + period.getSeconds() + "秒";
        return result;
    }

    public static int getDateTimeMinuteBetween(Date startDate, Date endDate) {
        DateTime start = new DateTime(startDate.getTime());
        DateTime end = new DateTime(endDate.getTime());
        Minutes minutes = Minutes.minutesBetween(start, end);
        return minutes.getMinutes();
    }

    public static Date getMonday(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(7, 2);
        return cDay.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(5, 1);
        return cDay.getTime();
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(5, cDay.getActualMaximum(5));
        return cDay.getTime();
    }

    public static Date getFirstDayOfQuarter(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        int curMonth = cDay.get(2);
        if(curMonth >= 0 && curMonth <= 2) {
            cDay.set(2, 0);
        }

        if(curMonth >= 3 && curMonth <= 5) {
            cDay.set(2, 3);
        }

        if(curMonth >= 6 && curMonth <= 7) {
            cDay.set(2, 6);
        }

        if(curMonth >= 9 && curMonth <= 11) {
            cDay.set(2, 9);
        }

        cDay.set(5, cDay.getActualMinimum(5));
        return cDay.getTime();
    }

    public static Date getLastDayOfQuarter(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        int curMonth = cDay.get(2);
        if(curMonth >= 0 && curMonth <= 2) {
            cDay.set(2, 2);
        }

        if(curMonth >= 3 && curMonth <= 5) {
            cDay.set(2, 5);
        }

        if(curMonth >= 6 && curMonth <= 7) {
            cDay.set(2, 7);
        }

        if(curMonth >= 9 && curMonth <= 11) {
            cDay.set(2, 11);
        }

        cDay.set(5, cDay.getActualMaximum(5));
        return cDay.getTime();
    }

    public static String getDatePattern() {
        return "yyyy-MM-dd";
    }

    public static String getDateTimePattern() {
        return "yyyy-MM-dd HH:mm:ss";
    }

    public static Date plusSysDays(int days) {
        return plusDays(getSysDate(), days);
    }

    public static Date plusDays(Date input, int days) {
        DateTime dateTime = new DateTime(input.getTime());
        return dateTime.plusDays(days).toDate();
    }

    public static Date plusYears(Date input, int years) {
        DateTime dateTime = new DateTime(input.getTime());
        return dateTime.plusYears(years).toDate();
    }

    public static Date plusMonths(Date input, int months) {
        DateTime dateTime = new DateTime(input.getTime());
        return dateTime.plusMonths(months).toDate();
    }

    public static Date getSysDateNoPattern() {
        return new Date(System.currentTimeMillis());
    }

    public static Timestamp getSysTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date getSysDate() {
        return stringToDate(getSysDateTimeString(), getDatePattern());
    }

    public static Date getSysDateTime() {
        return stringToDate(getSysDateTimeString(), getDateTimePattern());
    }

    public static Date getSysDate(String pattern) {
        return stringToDate(getSysDateTimeString(), pattern);
    }

    public static String getSysDateString() {
        return dateToString(getSysDateNoPattern(), getDatePattern());
    }

    public static String getSysMonth() {
        return getSysDateString("yyyy-MM");
    }

    public static String getSysDateString(String pattern) {
        return dateToString(getSysDateNoPattern(), pattern);
    }

    public static String getSysDateTimeString() {
        return dateToString(getSysDateNoPattern(), getDateTimePattern());
    }

    public static String getSysDateTimeString(String pattern) {
        return dateToString(getSysDateNoPattern(), pattern);
    }

    public static final String dateToString(Date date) {
        return dateToString(date, getDatePattern());
    }

    public static final String timeToString(Date date) {
        return dateToString(date, getDateTimePattern());
    }

    public static final String dateToString(Date date, String pattern) {
        return (new SimpleDateFormat(pattern)).format(date);
    }

    public static final Date stringToDate(String dateStr) {
        return stringToDate(dateStr, getDatePattern());
    }

    public static final Date stringToDateTime(String dateStr) {
        return stringToDate(dateStr, getDateTimePattern());
    }

    public static final Date getSysDateNoTime() {
        String dateStr = dateToString(getSysDateNoPattern(), "yyyy-MM-dd");
        return stringToDate(dateStr, "yyyy-MM-dd");
    }

    public static String formatTimeSpan(long span) {
        long minSeconds = span % 1000L;
        span /= 1000L;
        long seconds = span % 60L;
        span /= 60L;
        long min = span % 60L;
        span /= 60L;
        long hours = span % 24L;
        span /= 24L;
        return (new Formatter()).format("%1$dDay %2$02d:%3$02d:%4$02d.%5$03d", new Object[]{Long.valueOf(span), Long.valueOf(hours), Long.valueOf(min), Long.valueOf(seconds), Long.valueOf(minSeconds)}).toString();
    }

    public static final Date stringToDate(String dateStr, String pattern) {
        try {
            return (new SimpleDateFormat(pattern)).parse(dateStr);
        } catch (ParseException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static Date getDate() {
        return new Date();
    }

    public static String formatDate(Date date, String pattern) {
        if(StringUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd";
        }

        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.print(new DateTime(date.getTime()));
    }

    public static String getNowTime() {
        return TIME_FORMAT.print(DateTime.now());
    }

    public static String getNowDate() {
        return DATE_FORMAT.print(DateTime.now());
    }

    public static String getDateYYYYMMddHHMMSS() {
        return TIME_FORMAT.print(new DateTime());
    }

    public static String getDateYYYYMMdd() {
        return DATE_FORMAT.print(new DateTime());
    }

    public static String formatDateYYYYMMdd(String src, String srcPattern, String targetPattern) {
        DateTimeFormatter srcFormatter = DateTimeFormat.forPattern(srcPattern);
        DateTimeFormatter targetFormatter = DateTimeFormat.forPattern(targetPattern);
        return targetFormatter.print(srcFormatter.parseDateTime(src));
    }

    public static String smartFormat(Date date) {
        String dateStr = null;
        if(date == null) {
            dateStr = "";
        } else {
            try {
                dateStr = formatDate(date, "yyyy-MM-dd HH:mm:ss");
                if(dateStr.endsWith(" 00:00:00")) {
                    dateStr = dateStr.substring(0, 10);
                } else if(dateStr.endsWith("00:00")) {
                    dateStr = dateStr.substring(0, 16);
                } else if(dateStr.endsWith(":00")) {
                    dateStr = dateStr.substring(0, 16);
                }
            } catch (Exception var3) {
                throw new IllegalArgumentException("转换日期失败: " + var3.getMessage(), var3);
            }
        }

        return dateStr;
    }

    public static Date smartFormat(String text) {
        Date date = null;

        try {
            if(text != null && text.length() != 0) {
                if(text.length() == 10) {
                    date = formatStringToDate(text, "yyyy-MM-dd");
                } else if(text.length() == 13) {
                    date = new Date(Long.parseLong(text));
                } else if(text.length() == 16) {
                    date = formatStringToDate(text, "yyyy-MM-dd HH:mm");
                } else {
                    if(text.length() != 19) {
                        throw new IllegalArgumentException("日期长度不符合要求!");
                    }

                    date = formatStringToDate(text, "yyyy-MM-dd HH:mm:ss");
                }
            } else {
                date = null;
            }

            return date;
        } catch (Exception var3) {
            throw new IllegalArgumentException("日期转换失败!");
        }
    }

    public static String getNow(String format) throws Exception {
        return formatDate(new Date(), format);
    }

    public static Date formatStringToDate(String argDateStr, String argFormat) throws Exception {
        if(argDateStr != null && argDateStr.trim().length() >= 1) {
            String strFormat = argFormat;
            if(StringUtils.isEmpty(argFormat)) {
                strFormat = "yyyy-MM-dd";
                if(argDateStr.length() > 16) {
                    strFormat = "yyyy-MM-dd HH:mm:ss";
                } else if(argDateStr.length() > 10) {
                    strFormat = "yyyy-MM-dd HH:mm";
                }
            }

            SimpleDateFormat sdfFormat = new SimpleDateFormat(strFormat);
            sdfFormat.setLenient(false);

            try {
                return sdfFormat.parse(argDateStr);
            } catch (ParseException var5) {
                throw new Exception(var5);
            }
        } else {
            return null;
        }
    }
}

