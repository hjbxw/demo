package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class MyStringUtils {
    /**
     * 获取当前时间
     * @return
     */
    public static String getTime(){
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return time;
    }

    /**
     * 生成uuid
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

    /*计算年龄*/
    public static String getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 0;
                }
            }
            return String.valueOf(age);
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return "0";
        }
    }
}
