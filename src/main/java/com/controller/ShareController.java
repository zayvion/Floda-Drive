package com.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.TbShare;
import com.pojo.TbUser;
import com.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @Auther: zayvion
 * @Date: 2019-08-30 10:44
 * @Description:分享controller
 */
@Controller
@RequestMapping("/share")
public class ShareController {

    @RequestMapping(value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addShare(HttpSession session, Model model, String comment,String shareObjs) {
        System.out.println(shareObjs);
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            model.addAttribute("msg", "没有登录，请登录后再试");
            return ResponseResult.build(500,"暂不支持此类型分享，系统升级中......");
        }
        Type type = new TypeToken<ArrayList<shareJson>>() {
        }.getType();
        ArrayList<shareJson> shareFiles = new Gson().fromJson(shareObjs, type);
        for (int i = 0; i < shareFiles.size(); i++) {
            if (shareFiles.get(i).getType() == 0) {
                return ResponseResult.build(500, "暂不支持这种类型的分享，请等待后期升级");

            } else {
                TbShare share = new TbShare();
                share.setShareComment(shareFiles.get(i).getComment());


            }
        }

        return ResponseResult.ok("分享成功！");
    }


    class shareJson {
        private long fileId;
        private String comment;
        private String title;
        private int type;

        public long getFileId() {
            return fileId;
        }

        public void setFileId(long fileId) {
            this.fileId = fileId;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}