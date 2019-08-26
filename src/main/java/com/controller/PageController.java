package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zayvion
 * @Date: 2019-08-25 19:01
 * @Description:跳转controller
 */
@Controller
public class PageController {
    @RequestMapping(value = "/")
    public String hello (Model model){
        return "index";
    }
}
