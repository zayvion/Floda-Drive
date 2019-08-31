package com.controller;

import com.google.gson.Gson;
import com.pojo.*;
import com.service.SystemFileService;
import com.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
    private UserFileService userFileService;
    @Autowired
    private SystemFileService systemFileService;

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

    @RequestMapping(value = "/getFileType", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getFileType(HttpSession session, @RequestParam String type, Model model) {
        TbUser user = ((TbUser) session.getAttribute("onlineuser"));
        ShowFolders showFolders = new ShowFolders();
        List files = userFileService.getUserFileWithType(user.getUserId(), type);
        showFolders.setData(files);
        return new Gson().toJson(showFolders);
    }

    @RequestMapping(value = "/previewFile")
    public String previewFile(long fileId, int type, Model model) {
        if (fileId == 0l || type == 0) {
            model.addAttribute("msg", " 参数异常，请重试！");
            return "error";
        }
        if (type == 3) {
            TbUserFile userFile = userFileService.getUserFile(fileId);
            TbSystemFile systemFile = systemFileService.getSystemFile(userFile.getUserSysfileId());
            FolderAndFile folderAndFile = new FolderAndFile();
            folderAndFile.setUserSysfileId(systemFile.getFileId());
            folderAndFile.setFile_url(systemFile.getFileUrl());
            folderAndFile.setFileName(userFile.getUserFileName());
            // 把文件的信息传给前台
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss") ;
            String updateTime = dateFormat.format(userFile.getUploadTime());
            BigDecimal fileSize = userFile.getFileSize();
            if (fileSize.floatValue() < 1024) {
                model.addAttribute("fileSize", fileSize + "KB");
            } else {
                DecimalFormat decimalFormat = new DecimalFormat(".0");
                model.addAttribute("fileSize",  decimalFormat.format(fileSize.doubleValue() / 1024)+ "MB");
            }
            model.addAttribute("fileInfo", folderAndFile);
            model.addAttribute("fileUploadTime", updateTime);
            return "/views/home/onlineVideo";
        }else if (type==4){
            TbUserFile userFile = userFileService.getUserFile(fileId);
            TbSystemFile systemFile = systemFileService.getSystemFile(userFile.getUserSysfileId());
            String extession = userFile.getUserFileName().substring(userFile.getUserFileName().lastIndexOf("."));
            if (extession.toLowerCase().equals(".docx")||extession.toLowerCase().equals(".doc")||extession.toLowerCase().equals(".xls")||extession.toLowerCase().equals(".xlsx")||extession.toLowerCase().equals(".ppt")||extession.toLowerCase().equals(".pptx")) {
                return "redirect:https://view.officeapps.live.com/op/view.aspx?src=" + systemFile.getFileUrl();
            }else if (extession.equals(".pdf"))
                return "redirect:" + systemFile.getFileUrl();
            else if (extession.equals("") || extession == null) {
                model.addAttribute("msg", "该文件暂不支持在线预览，系统将在后期将会支持该格式！");
                return "error";
            } else {
                model.addAttribute("msg", "该文件暂不支持在线预览，系统将在后期将会支持该格式！");
                return "error";
            }

        } else if (type == 2) {
            TbUserFile userFile = userFileService.getUserFile(fileId);
            TbSystemFile systemFile = systemFileService.getSystemFile(userFile.getUserSysfileId());
            FolderAndFile folderAndFile = new FolderAndFile();
            folderAndFile.setUserSysfileId(systemFile.getFileId());
            folderAndFile.setFile_url(systemFile.getFileUrl());
            folderAndFile.setFileName(userFile.getUserFileName());
            // 把文件的信息传给前台
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss") ;
            String updateTime = dateFormat.format(userFile.getUploadTime());
            BigDecimal fileSize = userFile.getFileSize();
            if (fileSize.floatValue() < 1024) {
                model.addAttribute("fileSize", fileSize + "KB");
            } else {
                DecimalFormat decimalFormat = new DecimalFormat(".0");
                model.addAttribute("fileSize",  decimalFormat.format(fileSize.doubleValue() / 1024)+ "MB");
            }
            model.addAttribute("fileInfo", folderAndFile);
            model.addAttribute("fileUploadTime", updateTime);
            return "/views/home/onlineMusic";
        }
        model.addAttribute("msg", "该文件暂不支持在线预览，系统将在后期将会支持该格式！");
        return "error";

    }

}
