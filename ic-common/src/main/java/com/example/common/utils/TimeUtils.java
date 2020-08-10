package com.example.common.utils;

import java.time.LocalDateTime;

/**
 * @ClassName: TimeUtils
 * @Description: 时间工具类
 * @Author hzy
 * @Date 2020/8/10 15:24
 **/
public class TimeUtils {
    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static LocalDateTime currentTime() {
        return LocalDateTime.now();
    }
}
