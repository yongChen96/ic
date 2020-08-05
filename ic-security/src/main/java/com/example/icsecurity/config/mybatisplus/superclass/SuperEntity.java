package com.example.icsecurity.config.mybatisplus.superclass;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName: SuperEntity
 * @Description: 公共父类
 * @Author: yongchen
 * @Date: 2020/8/5 11:39
 **/
@Data
public class SuperEntity<T> implements Serializable, Cloneable {
    private static final long serialVersionUID = -8813694495536208357L;

    public static final String ID = "id";
    public static final String CREATE_TIME = "createTime";
    public static final String CREATE_USER = "createUser";
    public static final String UPDATE_TIME = "updateTime";
    public static final String UPDATE_USER = "updateUser";

    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty("主键")
    @NotNull(message = "id不能为空", groups = {SuperEntity.Update.class})
    protected T id;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @ApiModelProperty("创建人ID")
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected T createUser;

    @ApiModelProperty("最后修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    @ApiModelProperty("最后修改人ID")
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected T updateUser;

    public SuperEntity() {
    }

    public SuperEntity(T id, LocalDateTime createTime, T createUser, LocalDateTime updateTime, T updateUser) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }

    public interface Update extends Default {}
    public interface Save extends Default {}
}
