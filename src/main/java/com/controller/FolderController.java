package com.controller;

import com.pojo.ShowFolders;
import com.pojo.TbFolder;
import com.service.FolderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    @RequestMapping("/folders")
    @ResponseBody
    public ShowFolders folders( ){
        //默认用户用户为1
        return folderServiceImpl.findFolders(1);
    }

}
