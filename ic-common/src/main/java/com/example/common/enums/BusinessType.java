package com.example.common.enums;

/**
 * @ClassName: BusinessType
 * @Description: 业务操作类型
 * @Author hzy
 * @Date 2020/8/11 15:31
 **/
public enum BusinessType {
    /**
     * 查询
     */
    QUERY,
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,

    /**
     * 清空数据
     */
    CLEAN,

    /**
     * 登录
     */
    LOGIN,

    /**
     * 验证码生成
     */
    CAPTCHA,
}
