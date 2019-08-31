package com.controller;

import com.google.gson.Gson;
import com.pojo.ShowFolders;
import com.pojo.TbUser;
import com.pojo.TbUserFile;
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

    @RequestMapping(value = "/del",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String del(HttpSession session ,String userfileIds) {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            return ResponseResult.build(500, "没有登录，请登录后再试");
        }
        String[] ids = new String[0];
        try {
            String res = userfileIds.substring(1, userfileIds.length() - 1);
            ids = res.split(",");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.build(500, "参数异常，请重试！");
        }
        for (String id : ids) {
            recycleService.remove(Long.parseLong(id));
        }
        return ResponseResult.ok("操作成功！");
    }

    @RequestMapping(value = "/empty",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delAll(HttpSession session) {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            return ResponseResult.build(500, "没有登录，请登录后再试");
        }
        recycleService.delAllFile(user.getUserId());
        return ResponseResult.ok("操作成功！");
    }

    @RequestMapping(value = "/restore",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String restore(HttpSession session,String userfileIds) {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            return ResponseResult.build(500, "没有登录，请登录后再试");
        }
        String[] ids = new String[0];
        try {
            String res = userfileIds.substring(1, userfileIds.length() - 1);
            ids = res.split(",");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.build(500, "参数异常，请重试！");
        }
        for (String id : ids) {
            System.out.println("id:"+id);
            TbUserFile userFile = new TbUserFile();
            userFile.setUserfileId(Long.parseLong(id));
            recycleService.restore(userFile);
        }
        return ResponseResult.ok("操作成功！");
    }

}
