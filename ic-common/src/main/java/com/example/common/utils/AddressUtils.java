package com.example.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.common.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: AddressUtils
 * @Description: 根据ip获取地址工具类
 * @Author hzy
 * @Date 2020/8/10 15:42
 **/
@Slf4j
public class AddressUtils {
    /**
     * IP地址查询
     */
    public static final String IP_URL = "http://ip.taobao.com/outGetIpInfo";
    /**
     * 未知地址
     */
    public static final String UNKNOWN = "XX XX";

    public static String getAddressByIp(String ip) {
        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        try {
            String rspStr = HttpUtils.sendGet(IP_URL, "ip=" + ip + "&accessKey=alibaba-inc&json=true", GlobalConstant.UTF8);
            if (StringUtils.isEmpty(rspStr)) {
                log.error("获取地理位置异常 {}", ip);
                return UNKNOWN;
            }
            JSONObject obj = JSONObject.parseObject(rspStr);
            JSONObject data = obj.getJSONObject("data");
            String country = data.getString("country");
            String isp = data.getString("isp");

            String region = obj.getString("region");
            String city = obj.getString("city");
            return country + "." + region + "." + city + "." + isp;
        } catch (Exception e) {
            log.error("获取地理位置异常 {}", ip);
        }
        return UNKNOWN;
    }
}
