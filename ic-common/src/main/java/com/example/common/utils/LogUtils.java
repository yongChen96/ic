package com.example.common.utils;

/**
 * @ClassName: LogUtils
 * @Description: 处理并记录日志文件
 * @Author hzy
 * @Date 2020/8/11 10:42
 **/
public class LogUtils {
    public static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
