package com.controller;

import com.google.gson.Gson;
import com.pojo.ShowFolders;
import com.pojo.TbFolder;
import com.pojo.TbUser;
import com.service.FolderService;
import com.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @Auther: dc
 * @Date: 2019/8/26 16:11
 * @Description:
 */
@Controller
@RequestMapping("folder")
public class FolderController {

    @Resource
    private FolderService folderServiceImpl;

    /**
     * 根据用户id查询当前用户的所有文件夹
     */
    @RequestMapping(value = "/folders")
    @ResponseBody
    public ShowFolders folders(@SessionAttribute TbUser onlineuser, @RequestParam(defaultValue = "0") Long folder_father){
        System.out.println(folderServiceImpl.findFolders(onlineuser.getUserId(),folder_father));
        return folderServiceImpl.findFolders(onlineuser.getUserId(),folder_father);
    }

    /**
     * 重命名文件夹
     * @param folder
     * @return
     */
    @RequestMapping(value = "/rename",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String rename(String folder){
        TbFolder fromJson = new Gson().fromJson(folder, TbFolder.class);
        return folderServiceImpl.updateFolder(fromJson);
    }

    /**
     * 创建文件夹
     * @param folderName
     * @return
     */
    @RequestMapping(value = "/create",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String create(String folderName,@SessionAttribute TbUser onlineuser, @RequestParam(defaultValue = "0") Long folder_father){
        TbFolder folder = new TbFolder();
        folder.setFolderCreatetime(new Date());
        folder.setFolderFather(folder_father);
        folder.setFolderName(folderName);
        folder.setFolderUser(onlineuser.getUserId());
        return folderServiceImpl.addFolder(folder);
    }
}
