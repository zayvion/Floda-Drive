package com.controller;

import com.google.gson.Gson;
import com.pojo.ShowFolders;
import com.pojo.TbUser;
import com.service.RecycleService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-31 08:57
 * @Description:回收站的controler
 */
@RequestMapping("/recycle")
@Controller
public class RecycleController {
    @Autowired
    private RecycleService recycleService;

    @RequestMapping(value = "/list",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String list(HttpSession session) {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            return ResponseResult.build(500, "没有登录，请登录后再试");
        }
        List recycleList = recycleService.getUserRecycleList(user.getUserId());
        ShowFolders showFolders = new ShowFolders();
        showFolders.setData(recycleList);
        return new Gson().toJson(showFolders);
    }

}
