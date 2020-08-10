package com.example.security.entity;

import com.example.common.config.mybatisplus.superclass.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_resource")
@ApiModel(value="Resource对象", description="资源表")
public class Resource extends SuperEntity<String> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父资源id")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "资源名称")
    @TableField("resource_name")
    private String resourceName;

    @ApiModelProperty(value = "资源路径")
    @TableField("resource_url")
    private String resourceUrl;

    @ApiModelProperty(value = "资源类型")
    @TableField("resource_type")
    private String resourceType;

    @ApiModelProperty(value = " 打开方式（0：当前页面 1：新页面）")
    @TableField("resource_open")
    private String resourceOpen;

    @ApiModelProperty(value = "资源状态（0：启用 1：禁用）")
    @TableField("resource_status")
    private String resourceStatus;

    @ApiModelProperty(value = "资源图标")
    @TableField("resource_icon")
    private String resourceIcon;

    @ApiModelProperty(value = "资源描述")
    @TableField("resource_desc")
    private String resourceDesc;

    @ApiModelProperty(value = "删除标识（0：否 1：是）")
    @TableField("del_state")
    private String delState;


}
