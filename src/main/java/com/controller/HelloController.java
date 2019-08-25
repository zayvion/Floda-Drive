package com.controller;

import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zayvion
 * @Date: 2019-08-25 19:01
 * @Description:测试controller
 */
@Controller
public class HelloController {

    @Autowired
    private TestService testService;
    @RequestMapping("/")
    public String hello (Model model){
        System.out.println("w3");
        //testService.addData();
        return "index";
    }
}
