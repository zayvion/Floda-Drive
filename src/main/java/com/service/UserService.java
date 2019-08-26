package com.service;

import com.mapper.TbUserMapper;
import com.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zayvion
 * @Date: 2019-08-25 20:24
 * @Description:用户service接口
 */
public interface UserService {
    /**
     * 用户注册
     * @param user 用户实体
     */
    void addUser(TbUser user);

    /**
     * 用户登录
     * @param username 用户名或者邮箱都可以登录
     * @param password 密码
     * @return user实体
     */
    TbUser login(String username, String password);

}
