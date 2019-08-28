package com.controller;

import com.google.gson.Gson;
import com.pojo.*;
import com.service.FolderService;
import com.service.UserFileService;
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
    @Resource
    private UserFileService userFileServiceImpl;

    /**
     * 根据用户id查询当前用户的所有文件夹
     */
    @RequestMapping(value = "/folders")
    @ResponseBody
    public ShowFolders folders(@SessionAttribute TbUser onlineuser, Long folder_father){
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
        FolderAndFile folderAndFile = new Gson().fromJson(folder, FolderAndFile.class);
        if (folderAndFile.getFileType().equals("0")){
            TbFolder newFolder  = new TbFolder();
            newFolder.setFolderId(folderAndFile.getId());
            newFolder.setFolderName(folderAndFile.getFileName());
            newFolder.setFolderUser(folderAndFile.getBelong());
            newFolder.setFolderFather(folderAndFile.getParentId());
            return folderServiceImpl.updateFolder(newFolder);
        }else {
            TbUserFile userFile = new TbUserFile();
            userFile.setBelongUser(folderAndFile.getBelong());
            userFile.setFileLocation(folderAndFile.getParentId());
            userFile.setFileSize(folderAndFile.getFileSize());
            userFile.setFileType(folderAndFile.getFileType());
            userFile.setUserfileId(folderAndFile.getId());
            userFile.setUserFileName(folderAndFile.getFileName());
            userFile.setUserSysfileId(folderAndFile.getUserSysfileId());
            return userFileServiceImpl.updateUserFile(userFile);
        }
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
