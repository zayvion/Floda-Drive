package com.service;

import com.mapper.TbUserMapper;
import com.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zayvion
 * @Date: 2019-08-25 20:24
 * @Description:测试service
 */
@Service
public class TestService {

    @Autowired
    private TbUserMapper userMapper;

    public void addData(){
        TbUser user = new TbUser();
        user.setUserId(15000l);
        user.setUserName("test");
        user.setUserEmail("1234@qq.com");
        user.setUserPassword("45tyhjsds");
        user.setUserLevel("1");
        userMapper.insertSelective(user);
    }
}
