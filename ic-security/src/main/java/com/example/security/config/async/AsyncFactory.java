package com.example.security.config.async;

import com.example.common.constant.GlobalConstant;
import com.example.common.utils.*;
import com.example.security.entity.LoginInfo;
import com.example.security.entity.OperateLog;
import com.example.security.service.LoginInfoService;
import com.example.security.service.OperateLogService;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;

/**
 * @ClassName: AsyncFactory
 * @Description: 异步工厂（产生任务用）
 * @Author hzy
 * @Date 2020/8/11 10:41
 **/
@Slf4j
public class AsyncFactory {
    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     * @return 任务task
     */
    public static TimerTask recordLoginInfo(final String username, final String status, final String message,
                                            final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getAddressByIp(ip);
                // 打印信息到日志
                String s = LogUtils.getBlock(ip) +
                        address +
                        LogUtils.getBlock(username) +
                        LogUtils.getBlock(status) +
                        LogUtils.getBlock(message);
                log.info(s, args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                LoginInfo loginInfo = new LoginInfo();
                loginInfo.setUserName(username);
                loginInfo.setIpaddr(ip);
                loginInfo.setLoginLocation(address);
                loginInfo.setBrowser(browser);
                loginInfo.setOs(os);
                loginInfo.setMsg(message);
                loginInfo.setLoginTime(TimeUtils.currentTime());
                // 日志状态
                if (GlobalConstant.LOGIN_SUCCESS.equals(status) || GlobalConstant.LOGOUT.equals(status)) {
                    loginInfo.setStatus(GlobalConstant.SUCCESS);
                } else if (GlobalConstant.LOGIN_FAIL.equals(status)) {
                    loginInfo.setStatus(GlobalConstant.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(LoginInfoService.class).insertLoginInfo(loginInfo);
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param operateLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOperate(final OperateLog operateLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operateLog.setOperateLocation(AddressUtils.getAddressByIp(operateLog.getOperateIp()));
                SpringUtils.getBean(OperateLogService.class).insertOperateLog(operateLog);
            }
        };
    }
}
