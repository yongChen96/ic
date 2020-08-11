package com.example.security.controller;

import com.example.common.annotation.Log;
import com.example.common.config.mybatisplus.superclass.BaseController;
import com.example.common.constant.GlobalConstant;
import com.example.common.enums.BusinessType;
import com.example.common.rest.Result;
import com.example.common.utils.Base64;
import com.example.common.utils.IDUtils;
import com.example.security.config.redis.RedisCache;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CaptchaController
 * @Description: 验证码控制器
 * @Author hzy
 * @Date 2020/8/11 16:48
 **/
@Slf4j
@RestController
@Api(value = "验证码", tags = "验证码")
public class CaptchaController extends BaseController {
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Resource
    private RedisCache redisCache;

    /**
     * 验证码类型
     */
    @Value("${danielle.captchaType}")
    private String captchaType;

    private final static String MATH = "math";
    private final static String CHAR = "char";

    @GetMapping("/captchaImage")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    public Result<Map<String, Object>> getCode(HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>(16);
        // 保存验证码信息
        String uuid = IDUtils.simpleUUID();
        String verifyKey = GlobalConstant.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        if (MATH.equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        }
        if (CHAR.equals(captchaType)) {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }
        log.info("验证码:" + capStr);
        redisCache.setCacheObject(verifyKey, code, GlobalConstant.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            assert image != null;
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return Result.fail(e.getMessage());
        }
        map.put("uuid", uuid);
        map.put("img", Base64.encode(os.toByteArray()));
        return success(map);
    }
}
