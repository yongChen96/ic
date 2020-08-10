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
 * 角色资源信息表
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_role_resource")
@ApiModel(value="RoleResource对象", description="角色资源信息表")
public class RoleResource extends SuperEntity<String> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty(value = "资源id")
    @TableField("resource_id")
    private String resourceId;

    @ApiModelProperty(value = "删除标识（0：否 1：是）")
    @TableField("del_state")
    private String delState;


}
