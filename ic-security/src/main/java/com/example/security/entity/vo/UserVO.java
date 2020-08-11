package com.example.security.entity.vo;

import com.example.common.utils.StringUtils;
import com.example.security.entity.Role;
import com.example.security.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: UserVO
 * @Description: TODO
 * @Author hzy
 * @Date 2020/8/11 9:17
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends User implements Serializable {
    /**
     * 角色对象
     */
    private List<Role> roles;

    /**
     * 角色组
     */
    private String[] rolesIds;

    /**
     * 是否是管理员
     *
     * @return boolean
     */
    public boolean isAdmin() {
        return isAdmin(this.getId());
    }

    public static boolean isAdmin(String id) {
        return StringUtils.isNotNull(id) && "d34ca6e450394532bda9575fb6061bca".equals(id);
    }


}
