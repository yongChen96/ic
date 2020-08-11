package com.example.security.entity;

import com.example.common.config.mybatisplus.superclass.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_operate_log")
@ApiModel(value="OperateLog对象", description="操作日志记录")
public class OperateLog extends SuperEntity<String> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模块标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除）")
    @TableField("business_type")
    private Integer businessType;

    @ApiModelProperty(value = "方法名称")
    @TableField("method")
    private String method;

    @ApiModelProperty(value = "请求方式")
    @TableField("request_method")
    private String requestMethod;

    @ApiModelProperty(value = "操作类别（0其它 1后台用户 2手机端用户）")
    @TableField("operate_type")
    private Integer operateType;

    @ApiModelProperty(value = "操作人员")
    @TableField("operate_name")
    private String operateName;

    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "请求URL")
    @TableField("operate_url")
    private String operateUrl;

    @ApiModelProperty(value = "主机地址")
    @TableField("operate_ip")
    private String operateIp;

    @ApiModelProperty(value = "操作地点")
    @TableField("operate_location")
    private String operateLocation;

    @ApiModelProperty(value = "请求参数")
    @TableField("operate_param")
    private String operateParam;

    @ApiModelProperty(value = "返回参数")
    @TableField("json_result")
    private String jsonResult;

    @ApiModelProperty(value = "操作状态（0正常 1异常）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "错误消息")
    @TableField("error_msg")
    private String errorMsg;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;


}
