package com.service.impl;

import com.mapper.TbUserMapper;
import com.pojo.TbUser;
import com.pojo.TbUserExample;
import com.service.UserService;
import com.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-26 14:48
 * @Description:用户service接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public void addUser(TbUser user) {
        String password = user.getUserPassword();
        // 将密码转化为md5加密存入数据库
        user.setUserPassword(MD5Util.getMD5(password));
        userMapper.insertSelective(user);
    }

    @Override
    public TbUser login(String username, String password) {
        /*
        用户名密码验证
         */
        TbUserExample user1 = new TbUserExample();
        TbUserExample.Criteria criteria1 = user1.createCriteria();
        criteria1.andUserPasswordEqualTo(MD5Util.getMD5(password));
        criteria1.andUserNameEqualTo(username);
        List<TbUser> usernameList = userMapper.selectByExample(user1);
        /*
        用户名邮箱验证
         */
        TbUserExample user2 = new TbUserExample();
        TbUserExample.Criteria criteria2 = user1.createCriteria();
        criteria2.andUserPasswordEqualTo(MD5Util.getMD5(password));
        criteria2.andUserEmailEqualTo(username);
        List<TbUser> emailList = userMapper.selectByExample(user2);
        /*
        两个条件满足一个都可以登录
         */
        if (usernameList.size() > 0) {
            return usernameList.get(0);
        } else if (emailList.size() > 0){
            return emailList.get(0);
        }
            return null;
    }

    @Override
    public void updateInfo(TbUser user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public TbUser getUserInfo(Long userId) {

        return userMapper.selectByPrimaryKey(userId);
    }
}
