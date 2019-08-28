package com.controller;

import com.google.gson.Gson;
import com.pojo.FolderAndFile;
import com.pojo.ShowFolders;
import com.pojo.TbUser;
import com.pojo.TbUserFile;
import com.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-08-27 17:34
 * @Description:用户文件controller
 */
@Controller
@RequestMapping("/userfile")
public class UserFileController {

    @Autowired
    public UserFileService userFileService;

    /**
     * 重命名文件
     *
     * @param file
     * @param model
     * @return
     */
    @RequestMapping("/rename")
    public String renameFile(@RequestParam String file, Model model) {
        new Gson().fromJson(file, FolderAndFile.class);

        return null;
    }

    @RequestMapping("getFileType")
    @ResponseBody
    public String getFileType(HttpSession session, @RequestParam String type, Model model) {
        TbUser user = ((TbUser) session.getAttribute("onlineuser"));
        ShowFolders showFolders = new ShowFolders();
        List files = userFileService.getUserFileWithType(user.getUserId(), type);
        showFolders.setData(files);
        return new Gson().toJson(showFolders);
    }

}
