package com.controller;

import com.pojo.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Auther: zayvion
 * @Date: 2019-08-25 19:01
 * @Description:跳转controller
 */
@Controller
public class PageController {
    @RequestMapping(value = "/")
    public String hello (Model model){
        return "user/login";
    }

    @RequestMapping("/index")
    public String index(HttpSession session,Model model){
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user != null) {
            return "index";
        } else {
            model.addAttribute("msg", "没有权限，请登录后再试！");
            return "error";
        }
    }
}
