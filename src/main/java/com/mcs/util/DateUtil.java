package com.mcs.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil
{
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // String date = "2009-07-12";
        // String date2 = DateUtil.getNextSomeDate(date, 25, "yyyy-MM-dd");
        // System.out.println(date2);
        //
        // // long n = 2073600000;
        // // long n2 = 2160000000L;
        //
        // System.out.println(Integer.MAX_VALUE);
        //
        // System.out.println(DateUtil.format("091001", "yyMMdd", "yyyy-MM-dd"));
        //
        // System.out.println(DateUtil.getNextSomeMonth(DateUtil.toDate("2009-10-10"), 3).toLocaleString());
        //
        // java.util.Calendar d = getDate("10:08");
        System.out.println(DateUtil.nextSomeDate(0));
    }
    
    public static String getEDate()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMdd,yyyy", Locale.US);
        String times = sdf.format(date);
        return times;
    }
    
    public static java.util.Date getDate(java.util.Date date, int hour, int min, int second)
    {
        
        java.util.Calendar c = java.util.Calendar.getInstance();
        
        c.setTime(date);
        c.set(java.util.Calendar.HOUR, hour);
        c.set(java.util.Calendar.MINUTE, min);
        c.set(java.util.Calendar.SECOND, second);
        
        return c.getTime();
    }
    
    /**
     * 返回某时间
     */
    public static int getField(java.util.Date date, int field)
    {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(field);
        
    }
    
    /**
     * 根据生效时间、有效时间段 返回到期日期
     * 
     * @param efficientTime
     * @param periodDay
     * @return outdateTime
     */
    public static java.sql.Timestamp getOutdateTime(java.util.Date efficientTime, long periodDay)
    {
        
        long lOutdate = efficientTime.getTime() + (periodDay * 24 * 60 * 60 * 1000L);
        
        java.sql.Timestamp outdateTime = new java.sql.Timestamp(lOutdate);
        
        return outdateTime;
    }
    
    /**
     * 根据生效时间、有效时间段 返回到期剩下的天数
     * 
     * @param efficientTime
     * @param periodDay
     * @return outdateTime
     */
    public static long getRemainDay(java.util.Date efficientTime, long periodDay)
    {
        long days = 0;
        long lPass = efficientTime.getTime() - System.currentTimeMillis();
        days = periodDay - lPass / (24 * 60 * 60 * 1000L);
        return days;
    }
    
    /**
     * 根据起始时间 返回两个日期之间的差数
     * 
     * @param starttime
     * @param endtime
     * @return getBetweenDay
     */
    public static long getBetweenDay(java.util.Date starttime, java.util.Date endtime)
    {
        long days = 0;
        days = (endtime.getTime() - starttime.getTime()) / (24 * 60 * 60 * 1000L);
        return days;
    }
    
    /**
     * 根据起始时间 返回两个时间之间的分钟数
     * 
     * @param starttime
     * @param endtime
     * @return getBetweenDay
     */
    public static long getBetweenMin(java.util.Date starttime, java.util.Date endtime)
    {
        long days = 0;
        days = (endtime.getTime() - starttime.getTime()) / (60 * 1000L);
        return days;
    }
    
    /**
     * 返回某个日期到现在过了多少分钟
     * 
     * @param thetime
     * @return getBetweenMin
     */
    public static long getBetweenMin(java.util.Date thetime)
    {
        long days = 0;
        days = (System.currentTimeMillis() - thetime.getTime()) / (60 * 1000L);
        return days;
    }
    
    /**
     * 根据起始时间 返回两个日期之间的差数
     * 
     * @param startdate
     * @param enddate
     * @return days
     */
    public static long getBetweenDay(String strStartdate, String strEnddate)
    {
        long days = 0;
        
        days = (toTimestamp(strEnddate).getTime() - toTimestamp(strStartdate).getTime()) / (24 * 60 * 60 * 1000L);
        
        return days;
    }
    
    /**
     * 根据当前日期 返回n天后的日期
     */
    public static Timestamp getNextSomeDate(long n)
    {
        long longTime = System.currentTimeMillis() + (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return outdateTime;
    }
    
    /**
     * 根据当前日期 返回n天后的日期
     */
    public static String getNextSomeDate(int n)
    {
        long longTime = System.currentTimeMillis() + (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return DateUtil.format(outdateTime, "yyyy-MM-dd");
    }
    
    /**
     * 根据当前日期 返回n天后的日期
     */
    public static String getNextSomeDate(int n, String format)
    {
        long longTime = System.currentTimeMillis() + (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return DateUtil.format(outdateTime, format);
    }
    
    /**
     * 根据当前日期 返回n天后的日期
     */
    public static String getNextSomeDate(String datetime, int n, String format)
    {
        java.util.Date theDate = toDate(datetime);
        
        long longTime = theDate.getTime() + (n * 24 * 60 * 60 * 1000L);
        
        Timestamp outdateTime = new Timestamp(longTime);
        
        return DateUtil.format(outdateTime, format);
    }
    
    public static Timestamp getNextSomeMin(Date date, long n)
    {
        long longTime = date.getTime() + (n * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        return outdateTime;
    }
    
    public static Timestamp getNextSomeMin(long n)
    {
        long longTime = System.currentTimeMillis() + (n * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        return outdateTime;
    }
    
    public static java.util.Date getNextSomeMonth(int n)
    {
        // Calendar类:一个抽像类，不能直接new 得到。
        Calendar calendar = Calendar.getInstance();// 得到当前时间
        
        // 在当前的月份上加上n天
        calendar.add(Calendar.MONTH, n);
        // 一般可以转化为util包的Date类
        return calendar.getTime();
    }
    
    // 获取下一月的日期
    public static java.util.Date getNextSomeMonth(Date currentDate, int n)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.MONTH, n);// 在月份上加1
        return cal.getTime();
    }
    
    /**
     * 根据当前日期 返回n天后的日期
     * 
     * @param startDate
     * @param n
     */
    public static Timestamp getNextSomeDate(String datetime, long n)
    {
        java.util.Date theDate = toDate(datetime);
        
        long longTime = theDate.getTime() + (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return outdateTime;
    }
    
    public static Timestamp getNextSomeDate(Date startDate, long n)
    {
        long longTime = startDate.getTime() + (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return outdateTime;
    }
    
    public static String formatTime(long times)
    {
        long day = times / (24 * 60 * 60 * 1000);
        long hour = (times / (60 * 60 * 1000) - day * 24);
        long min = ((times / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (times / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        return "" + day + "天" + hour + "小时" + min + "分" + s + "秒";
    }
    
    /**
     * 格式化日期
     * 
     * @param datetime
     * @param format
     */
    public static String format(Date datetime, String format)
    {
        
        long longTime = datetime.getTime();
        
        Timestamp outdateTime = new Timestamp(longTime);
        
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(outdateTime);
        return strDate;
    }
    
    /** 续几天 */
    public static java.util.Date nextSomeDate(int n)
    {
        // Calendar类:一个抽像类，不能直接new 得到。
        Calendar calendar = Calendar.getInstance();// 得到当前时间
        
        // 在当前的月份上加上n天
        calendar.add(Calendar.DATE, n);
        // 一般可以转化为util包的Date类
        return calendar.getTime();
    }
    
    /** 续几天 */
    public static java.util.Date nextSomeMonth(int n)
    {
        // Calendar类:一个抽像类，不能直接new 得到。
        Calendar calendar = Calendar.getInstance();// 得到当前时间
        
        // 在当前的月份上加上n天
        calendar.add(Calendar.MONTH, n);
        // 一般可以转化为util包的Date类
        return calendar.getTime();
    }
    
    /**
     * 格式化日期
     * 
     * @param datetime
     * @param format
     */
    public static String format(String strDatetime, String format)
    {
        
        long longTime = DateUtil.toDate(strDatetime).getTime();
        
        Timestamp outdateTime = new Timestamp(longTime);
        
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(outdateTime);
        return strDate;
    }
    
    public static String formatEDate(String strDatetime, String aimFormat)
    {
        
        long longTime = DateUtil.toDate(strDatetime).getTime();
        
        Timestamp outdateTime = new Timestamp(longTime);
        
        SimpleDateFormat formatter = new SimpleDateFormat(aimFormat, Locale.US);
        String strDate = formatter.format(outdateTime);
        return strDate;
    }
    
    public static String formatEDate(String strDatetime, String srcFormat, String aimFormat)
    {
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(srcFormat);
        java.util.Date srcDate = null;
        try
        {
            srcDate = sdf.parse(strDatetime);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        
        long longTime = srcDate.getTime();
        
        Timestamp outdateTime = new Timestamp(longTime);
        
        SimpleDateFormat formatter = new SimpleDateFormat(aimFormat, Locale.US);
        String strDate = formatter.format(outdateTime);
        return strDate;
    }
    
    public static String formatEDate(java.util.Date datetime, String format)
    {
        
        // long longTime = DateUtil.toDate(strDatetime).getTime();
        //
        // Timestamp outdateTime = new Timestamp(longTime);
        
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US);
        String strDate = formatter.format(datetime);
        return strDate;
    }
    
    /**
     * 格式化日期
     * 
     * @param datetime
     * @param srcFormat
     * @param aimFormat
     */
    public static String format(String datetime, String srcFormat, String aimFormat)
    {
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(srcFormat);
        
        java.util.Date srcDate = null;
        
        try
        {
            srcDate = sdf.parse(datetime);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        long longTime = srcDate.getTime();
        Timestamp outdateTime = new Timestamp(longTime);
        SimpleDateFormat formatter = new SimpleDateFormat(aimFormat);
        String aimDate = formatter.format(outdateTime);
        
        return aimDate;
    }
    
    /**
     * 根据当前日期 返回n天后的日期
     * 
     * @param datetime
     * @param n
     */
    public static String getStrNextSomeDate(String format, long n)
    {
        
        long longTime = System.currentTimeMillis() + (n * 24 * 60 * 60 * 1000L);
        
        Timestamp outdateTime = new Timestamp(longTime);
        
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(outdateTime);
        return strDate;
    }
    
    /**
     * 根据当前日期 返回n天后的日期
     * 
     * @param datetime
     * @param n
     */
    public static String getStrNextSomeDate(java.sql.Timestamp datetime, long n)
    {
        long longTime = datetime.getTime() + (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return getDate(outdateTime);
    }
    
    /**
     * 根据当前日期 返回n天前的日期
     */
    public static Timestamp getPreSomeDate(long n)
    {
        long longTime = System.currentTimeMillis() - (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return outdateTime;
    }
    
    /**
     * 根据当前日期 返回n天前的日期
     */
    public static String getPreSomeDate(int n, String format)
    {
        long longTime = System.currentTimeMillis() - (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        String strDate = format(outdateTime, format);
        
        return strDate;
    }
    
    /**
     * 前多分钟的时间点
     */
    public static Timestamp getPreSomeMin(long n)
    {
        long longTime = System.currentTimeMillis() - (n * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return outdateTime;
    }
    
    /**
     * 根据当前日期 返回n天前的日期
     * 
     * @param datetime
     * @param n
     */
    public static java.sql.Timestamp getPreSomeDate(java.sql.Timestamp datetime, long n)
    {
        long longTime = datetime.getTime() - (n * 24 * 60 * 60 * 1000L);
        Timestamp outdateTime = new Timestamp(longTime);
        
        return outdateTime;
    }
    
    /**
     * 根据当前日期 返回n天前的日期
     * 
     * @param datetime
     * @param n
     */
    public static java.util.Date getPreSomeDate(java.sql.Date datetime, long n)
    {
        long longTime = datetime.getTime() - (n * 24 * 60 * 60 * 1000L);
        java.util.Date outdateTime = new Timestamp(longTime);
        return outdateTime;
    }
    
    /**
     * 根据当前日期 返回n天前的日期
     * 
     * @param datetime
     * @param n
     */
    public static java.util.Date getPreSomeDate(java.util.Date datetime, long n)
    {
        long longTime = datetime.getTime() - (n * 24 * 60 * 60 * 1000L);
        java.util.Date outdateTime = new Timestamp(longTime);
        return outdateTime;
    }
    
    /**
     * 将格式如yyyy-MM-dd HH:mm:ss的时间格式转成java.util.Data形式
     */
    public static Date toDate(String strDate)
    {
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        java.util.Date aimDate = null;
        
        if (strDate.length() == 10 || strDate.length() == 9 || strDate.length() == 8)
        {
            strDate = strDate + " 00:00:00";
        }
        try
        {
            aimDate = sdf.parse(strDate);
        }
        catch (ParseException e)
        {
            
            e.printStackTrace();
        }
        
        return aimDate;
    }
    
    /**
     * 将格式如format的时间格式转成java.util.Data形式
     */
    public static Date toDate(String strDate, String format)
    {
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
        
        java.util.Date aimDate = null;
        try
        {
            aimDate = sdf.parse(strDate);
        }
        catch (ParseException e)
        {
            
            e.printStackTrace();
        }
        
        return aimDate;
    }
    
    public static Timestamp toTimestamp(java.util.Date date)
    {
        long time = date.getTime();
        return new Timestamp(time);
    }
    
    public static Date getCurrentDate()
    {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        return currDate;
    }
    
    public static String dateToString(Date date, String format)
    {
        
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    
    public static Timestamp getDate(Calendar cal)
    {
        return new Timestamp(cal.getTimeInMillis());
    }
    
    /**
     * 将格式如format的时间格式转成java.util.Data形式
     */
    public static Timestamp toTimestamp(String strDate, String format)
    {
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
        
        java.util.Date aimDate = null;
        try
        {
            aimDate = sdf.parse(strDate);
        }
        catch (ParseException e)
        {
            
            e.printStackTrace();
        }
        
        return toTimestamp(aimDate);
    }
    
    public static Timestamp toTimestamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 将格式如yyyy-MM-dd HH:mm:ss的时间格式转成java.sql.Timestamp形式
     */
    public static Timestamp toTimestamp(String strDate)
    {
        if (strDate == null || strDate.equals(""))
            return null;
        
        Timestamp aimTime = null;
        if (strDate.length() == 10 || strDate.length() == 9 || strDate.length() == 8)
        {
            strDate = strDate + " 00:00:00";
        }
        
        // 字符串转化成时间类型（字符串可以是任意类型，只要和SimpleDateFormat中的格式一致即可）
        java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US);
        try
        {
            java.util.Date d = sdf2.parse(strDate);
            
            aimTime = new Timestamp(d.getTime());
            
        }
        catch (ParseException e)
        {
            
            e.printStackTrace();
        }
        return aimTime;
    }
    
    /**
     * 根据日期，返回星期几
     */
    public static String getWeek(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        String week = formatter.format(date);
        return week;
    }
    
    /**
     * 返回数据形式的星期
     */
    public static String getNumWeek(String date)
    {
        
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        String strDate = formatter.format(toDate(date));
        if (strDate.equals("星期一"))
        {
            return "1";
        }
        else if (strDate.equals("星期二"))
        {
            return "2";
        }
        else if (strDate.equals("星期三"))
        {
            return "3";
        }
        else if (strDate.equals("星期四"))
        {
            return "4";
        }
        else if (strDate.equals("星期五"))
        {
            return "5";
        }
        else if (strDate.equals("星期六"))
        {
            return "6";
        }
        else if (strDate.equals("星期日"))
        {
            return "0";
        }
        return strDate;
        
        // return getWeek();
    }
    
    /**
     * 返回数据形式的星期
     */
    public static Integer getNumWeek2(String date)
    {
        
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        String strDate = formatter.format(toDate(date));
        if (strDate.equals("星期一"))
        {
            return 1;
        }
        else if (strDate.equals("星期二"))
        {
            return 2;
        }
        else if (strDate.equals("星期三"))
        {
            return 3;
        }
        else if (strDate.equals("星期四"))
        {
            return 4;
        }
        else if (strDate.equals("星期五"))
        {
            return 5;
        }
        else if (strDate.equals("星期六"))
        {
            return 6;
        }
        else if (strDate.equals("星期日"))
        {
            return 7;
        }
        return 0;
        
        // return getWeek();
    }
    
    public static String getEWeek(Date date)
    {
        
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        String strDate = formatter.format(date);
        if (strDate.equals("星期一"))
        {
            return "MON";
        }
        else if (strDate.equals("星期二"))
        {
            return "TUE";
        }
        else if (strDate.equals("星期三"))
        {
            return "WED";
        }
        else if (strDate.equals("星期四"))
        {
            return "THU";
        }
        else if (strDate.equals("星期五"))
        {
            return "FRI";
        }
        else if (strDate.equals("星期六"))
        {
            return "SAT";
        }
        else if (strDate.equals("星期日"))
        {
            return "SUN";
        }
        return strDate;
        
        // return getWeek();
    }
    
    public static String getEWeek(Integer num)
    {
        
        if (num.equals(1))
        {
            return "MON";
        }
        else if (num.equals(2))
        {
            return "TUE";
        }
        else if (num.equals(3))
        {
            return "WED";
        }
        else if (num.equals(4))
        {
            return "THU";
        }
        else if (num.equals(5))
        {
            return "FRI";
        }
        else if (num.equals(6))
        {
            return "SAT";
        }
        else if (num.equals(7))
        {
            return "SUN";
        }
        return "";
        
    }
    
    public static String getStrCurrentDate()
    {
        Date date = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
        return formatter.format(date);
    }
    
    public static String getStrCurrentDate(String format)
    {
        Date date = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    
    public static String getStrWeek(String date)
    {
        
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        String strDate = formatter.format(toDate(date));
        if (strDate.equals("星期一"))
        {
            return "一";
        }
        else if (strDate.equals("星期二"))
        {
            return "二";
        }
        else if (strDate.equals("星期三"))
        {
            return "三";
        }
        else if (strDate.equals("星期四"))
        {
            return "四";
        }
        else if (strDate.equals("星期五"))
        {
            return "五";
        }
        else if (strDate.equals("星期六"))
        {
            return "六";
        }
        else if (strDate.equals("星期日"))
        {
            return "日";
        }
        return strDate;
        
        // return getWeek();
    }
    
    /**
     * 返回string日期及时间
     */
    public static String getDatetime(Date date, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(date);
        return strDate;
    }
    
    /**
     * 返回string日期
     */
    public static String getDate(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        return strDate;
    }
    
    public static java.util.Calendar getDate(String time)
    {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(new Date(System.currentTimeMillis()));
        strDate = strDate + " " + time;
        
        Calendar calendar = Calendar.getInstance();
        // 从一个 Calendar 对象中获取 Date 对象
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date aimDate = null;
        try
        {
            aimDate = sdf.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        // 将 Date 对象反应到一个 Calendar 对象中，
        // Calendar/GregorianCalendar 没有构造函数可以接受 Date 对象
        // 所以我们必需先获得一个实例，然后设置 Date 对象
        calendar.setTime(aimDate);
        // calendar.set(2010, 8, 8, 5, 20);
        return calendar;
    }
    
    public static java.util.Calendar getDate(String date, String time)
    {
        if (time == null || time.equals(""))
            time = "00:00";
        String strDate = date + " " + time;
        Calendar calendar = Calendar.getInstance();
        // 从一个 Calendar 对象中获取 Date 对象
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date aimDate = null;
        try
        {
            aimDate = sdf.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        // 将 Date 对象反应到一个 Calendar 对象中，
        // Calendar/GregorianCalendar 没有构造函数可以接受 Date 对象
        // 所以我们必需先获得一个实例，然后设置 Date 对象
        calendar.setTime(aimDate);
        // calendar.set(2010, 8, 8, 5, 20);
        return calendar;
    }
    
    public static java.util.Calendar getDate(java.util.Date date, String time)
    {
        if (time == null || time.equals(""))
            time = "00:00";
        String strDate = format(date, "yyyy-MM-dd") + " " + time;
        
        Calendar calendar = Calendar.getInstance();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date aimDate = null;
        try
        {
            aimDate = sdf.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        calendar.setTime(aimDate);
        return calendar;
    }
    
    /**
     * 返回今天的日期 格式为yyyy-MM-dd
     * 
     * @param format 日期格式
     */
    public static String today(String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(new Date(System.currentTimeMillis()));
        return strDate;
    }
    
    /**
     * 返回今天的日期
     */
    public static Date today()
    {
        return new Date(System.currentTimeMillis());
    }
    
    /**
     * 返回特定时间的日期
     * 
     * @param hour
     * @param min
     */
    public static java.util.Date today(int hour, int min, int second)
    {
        java.util.Calendar c = java.util.Calendar.getInstance();
        
        c.set(java.util.Calendar.HOUR_OF_DAY, hour);
        c.set(java.util.Calendar.MINUTE, min);
        c.set(java.util.Calendar.SECOND, second);
        c.set(java.util.Calendar.MILLISECOND, 0);
        
        return c.getTime();
    }
    
    /**
     * 返回今天的日期
     */
    public static Date nowTime()
    {
        return new Date(System.currentTimeMillis());
    }
    
    public static Timestamp nowTimestamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 判断是否为今天
     */
    public static boolean isToday(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        
        String strToday = formatter.format(new Date(System.currentTimeMillis()));
        
        if (strToday.equals(strDate))
        {
            return true;
        }
        return false;
    }
    
    public static boolean isTomorrow(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        
        String strTomorrow = formatter.format(new Date(System.currentTimeMillis() + (1 * 24 * 60 * 60 * 1000L)));
        if (strTomorrow.equals(strDate))
        {
            return true;
        }
        return false;
    }
    
    public static boolean isToday(String date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strToday = formatter.format(new Date(System.currentTimeMillis()));
        
        if (strToday.equals(date))
        {
            return true;
        }
        return false;
    }
    
    public static boolean isBefore(Date date)
    {
        long times = date.getTime();
        long nows = System.currentTimeMillis();
        if (nows - times > 0)
            return true;
        return false;
    }
    
    public static boolean isSameday(Date date1, Date date2)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = formatter.format(date1);
        String strDate2 = formatter.format(date2);
        
        if (strDate1.equals(strDate2))
        {
            return true;
        }
        return false;
        
    }
    
}
// out.println(d);
// out.println("<br>");
// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// String mDateTime1=formatter.format(d);
// out.println(mDateTime1);
// out.println("<br>");
// out.println(d.getTime());
// out.println("<br>");
// // 当前时间
// Calendar cal = Calendar.getInstance();
// // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss G E D F w W a E F");
// String mDateTime=formatter.format(cal.getTime());
// out.println(mDateTime);
// out.println("<br>");
// // 1年前日期
// java.util.Date myDate=new java.util.Date();
// long myTime=(myDate.getTime()/1000)-60*60*24*365;
// myDate.setTime(myTime*1000);
// String mDate=formatter.format(myDate);
// out.println(mDate);
// out.println("<br>");
// // 明天日期
// myDate=new java.util.Date();
// myTime=(myDate.getTime()/1000)+60*60*24;
// myDate.setTime(myTime*1000);
// mDate=formatter.format(myDate);
// out.println(mDate);
// out.println("<br>");
// // 两个时间之间的天数
// SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
// java.util.Date date= myFormatter.parse("2003-05-1");
// java.util.Date mydate= myFormatter.parse("1899-12-30");
// long day=(date.getTime()-mydate.getTime())/(24*60*60*1000);
// out.println(day);
// out.println("<br>");
// // 加半小时
// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
// java.util.Date date1 = format.parse("2002-02-28 23:16:00");
// long Time=(date1.getTime()/1000)+60*30;
// date1.setTime(Time*1000);
// String mydate1=formatter.format(date1);
// out.println(mydate1);
// out.println("<br>");
// // 年月周求日期
// SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM F E");
// java.util.Date date2= formatter2.parse("2003-05 5 星期五");
// SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
// String mydate2=formatter3.format(date2);
// out.println(mydate2);
// out.println("<br>");
// // 求是星期几
// mydate= myFormatter.parse("2001-1-1");
// SimpleDateFormat formatter4 = new SimpleDateFormat("E");
// String mydate3=formatter4.format(mydate);
// out.println(mydate3);
// out.println("<br>");

