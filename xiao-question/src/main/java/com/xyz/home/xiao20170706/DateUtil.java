package com.xyz.home.xiao20170706;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Xiao on 2017/7/6.
 */
public class DateUtil {

    public static Date processEndTime(Date endTime) {
        // 处理结束时间的边界
        if (endTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            endTime = calendar.getTime();
        }
        return endTime;
    }

    public synchronized static Date parseEndTime(String endTimeStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = dateFormat.parse(endTimeStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
