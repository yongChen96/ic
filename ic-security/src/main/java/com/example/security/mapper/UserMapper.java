package com.example.security.mapper;

import com.example.security.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.security.entity.vo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return user实体
     */
    UserVO selectByUserName(String username);
}
