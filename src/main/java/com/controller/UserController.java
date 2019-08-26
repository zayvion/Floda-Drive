package com.controller;

import com.mapper.TbUserMapper;
import com.pojo.TbUser;
import com.service.UserService;
import com.utils.MailUtil;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @Auther: zayvion
 * @Date: 2019-08-26 14:50
 * @Description:用户模块controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
            userService.addUser(user);
            session.setAttribute("onlineuser",user);
            model.addAttribute("msg", "恭喜您，注册成功！");
            return "user/login";
        }
        // 验证码不正确向前台传值
        model.addAttribute("msg", "验证码输入错误！");
        return "user/reg";
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @param model
     * @param session
     * @return 登录成功重定向到index.jsp，失败返回login.jsp并给出提示
     */
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session){
        TbUser user = userService.login(username, password);
        if (user != null) {
            // 登录成功将用户对象放入session
            session.setAttribute("onlineuser", user);
            return "redirect:/index.jsp";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "user/login";
    }

    /**
     * 获取注册时的邮箱验证码
     * @param mailBox 用户邮箱
     * @param session
     * @return json
     */
    @RequestMapping("/sendRegCode")
    @ResponseBody
    public String sendRegCode(@RequestParam String mailBox, HttpSession session) {
        String redomCode = getRedomCode(4);
        MailUtil.sendMail(mailBox, redomCode,"您正在注册FlodaDrive网盘，您的验证码为:");
        session.setAttribute("regCode", redomCode);
        return ResponseResult.ok();
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("onlineuser");
        return "redirect:/user/login.jsp";
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
