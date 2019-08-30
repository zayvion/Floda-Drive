package com.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.*;
import com.service.ShareService;
import com.service.SystemFileService;
import com.service.UserFileService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-30 10:44
 * @Description:分享controller
 */
@Controller
@RequestMapping("/share")
public class ShareController {

    @Autowired
    private ShareService shareService;
    @Autowired
    private UserFileService userFileService;
    @Autowired
    private SystemFileService systemFileService;

    /**
     * 新增分享
     * @param session
     * @param model
     * @param comment
     * @param shareObjs
     * @return
     */
    @RequestMapping(value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addShare(HttpSession session, Model model, String comment,String shareObjs) {
        System.out.println(shareObjs);
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            return ResponseResult.build(500,"没有登录，请登录后再试");
        }
        Type type = new TypeToken<ArrayList<shareJson>>() {
        }.getType();
        ArrayList<shareJson> shareFiles = new Gson().fromJson(shareObjs, type);
            if (shareFiles.get(0).getType() == 0) {
                return ResponseResult.build(500, "暂不支持这种类型的分享，请等待后期升级");

            } else {
                TbShare share = new TbShare();
                share.setShareComment(shareFiles.get(0).getComment());
                if (shareFiles.size() > 1) {
                    share.setShareTitle(shareFiles.get(0).getTitle()+shareFiles.size()+"个文件");
                }
                share.setShareTitle(shareFiles.get(0).getTitle());
                share.setShareUser(user.getUserId());
                share.setShareDate(new Date());
                long shareId = shareService.addShare(share);
                for (shareJson shareFile : shareFiles) {
                    TbShareItem shareItem = new TbShareItem();
                    shareItem.setShareId(shareId);
                    shareItem.setShareUserfileId(shareFile.getFileId());
                    shareService.addShareItem(shareItem);
                }
                share.setShareUrl("http://localhost/share/view/"+shareId);
                shareService.updateUserShare(share);
                return ResponseResult.ok("分享成功！");
            }


    }

    /**
     * 获取用户分享的数据
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String shouUserShares(HttpSession session,Model model) {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            return ResponseResult.build(500,"没有登录，请登录后再试");
        }
        List<TbShare> tbShares = shareService.showUserShares(user.getUserId());
        System.out.println(tbShares.size());
        List<ShowShare> showShares = new ArrayList<>();
        for (TbShare tbShare : tbShares) {
            ShowShare share = new ShowShare();
            share.setComment(tbShare.getShareComment());
            share.setShareDate(tbShare.getShareDate());
            share.setTitle(tbShare.getShareTitle());
            share.setShareUrl(tbShare.getShareUrl());
            share.setQRCodeUrl("http://qr.liantu.com/api.php?logo=182.254.180.106/img/123/yun-2.png&text="+share.getShareUrl());
            showShares.add(share);
        }
        ShowFolders showFolders = new ShowFolders();
        showFolders.setData(showShares);
        return new Gson().toJson(showFolders);
    }

    /**
     * 用户直接打开分享链接
     * @param shareId
     * @return
     */
    @RequestMapping("/view/{shareId}")

    public String viewShare(@PathVariable long shareId) {
        return "views/home/onlineShare";
    }


    @RequestMapping(value = "/getdata/{shareId}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getData(@PathVariable long shareId) {
        System.out.println(shareId);
        List<TbShareItem> shareItems = shareService.showShareData(shareId);
        System.out.println(shareItems.size());
        List<FolderAndFile> folderAndFiles = new ArrayList<>();
        for (TbShareItem shareItem : shareItems) {
            TbUserFile userFile = userFileService.getUserFile(shareItem.getShareUserfileId());
            TbSystemFile systemFile = systemFileService.getSystemFile(userFile.getUserSysfileId());
            FolderAndFile folderAndFile = new FolderAndFile();
            folderAndFile.setUpdatetime(userFile.getUploadTime());
            folderAndFile.setFileName(userFile.getUserFileName());
            folderAndFile.setFile_url(systemFile.getFileUrl());
            folderAndFile.setFileType(systemFile.getFileType());
            folderAndFile.setFileSize(systemFile.getFileSize());
            folderAndFiles.add(folderAndFile);
        }
        String json = new Gson().toJson(folderAndFiles);
        ShowFolders showFolders = new ShowFolders();
        showFolders.setData(folderAndFiles);
        return new Gson().toJson(showFolders);
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