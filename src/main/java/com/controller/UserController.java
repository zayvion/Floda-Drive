package com.controller;

import com.mapper.TbUserMapper;
import com.pojo.TbUser;
import com.utils.MailUtil;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.Scanner;

/**
 * @Auther: zayvion
 * @Date: 2019-08-26 14:50
 * @Description:用户模块controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TbUserMapper userMapper;

    /**
     * 用户注册
     * @param user 用户实体，前台传过来直接封装
     * @param session
     * @param mailCode 邮箱验证码，前台传过来
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(@ModelAttribute("user") TbUser user, HttpSession session, @RequestParam String mailCode, Model model){
        if (((String) session.getAttribute("regCode")).equals(mailCode)) {
            userMapper.insertSelective(user);
            session.setAttribute("onlineuser",user);
            return "index";
        }
        model.addAttribute("msg", "验证码输入错误！");
        return "reg";
    }

    /**
     * 获取注册时的邮箱验证码
     * @param mailBox 用户邮箱
     * @param session
     * @return json
     */
    @RequestMapping("/sendRegCode")
    public String sendRegCode(@RequestParam String mailBox, HttpSession session) {
        String redomCode = getRedomCode(4);
        MailUtil.sendMail(mailBox, redomCode,"您正在注册FlodaDrive网盘，您的验证码为:");
        session.setAttribute("regCode", redomCode);
        return ResponseResult.ok();
    }

    /**
     * 获取一串随机验证码
     * @param n 需要多少位
     * @return string串
     */
    public String getRedomCode(int n) {
        String str = "1234567890qwertyuioplkjhgfdsazxcvbnm";
        Random r = new Random();
        String ss = "";
        for (int i = 0; i < n; i++) {
            char c = str.charAt(r.nextInt(str.length()));
            ss = ss + c;
        }
        return ss;
    }

}
