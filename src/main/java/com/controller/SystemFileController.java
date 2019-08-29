package com.controller;

import com.pojo.TbSystemFile;
import com.pojo.TbUser;
import com.pojo.TbUserFile;
import com.service.SystemFileService;
import com.service.UserFileService;
import com.utils.FtpUtil;
import com.utils.MD5Util;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: zayvion
 * @Date: 2019-08-27 08:58
 * @Description:系统文件controller
 */
@Controller
@RequestMapping("/sysfile")
public class SystemFileController {

    @Autowired
    private SystemFileService systemFileService;
    @Autowired
    private UserFileService userFileService;

    @RequestMapping("/upload")
    public String uploadFile(HttpSession session, @RequestParam("files") MultipartFile file, Model model,Long folder_id) throws IOException {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        // session没有用户信息直接返回错误信息
        if (user == null) {
            model.addAttribute("msg", "登录信息异常，请退出后重新登录！");
            return "error";
        }
        if (file != null) {
            /**
             * 拿到文件应先判断是否之前有用户上传过
             */
            String fileMd5 = MD5Util.getMd5File(file.getInputStream());
            List<TbSystemFile> compareFile = systemFileService.useMd5ToCompareFile(fileMd5);
            if (compareFile.size() != 0) {
                System.out.println("存在相同文件，不需要上传");
                TbSystemFile existFile = compareFile.get(0);
                TbUserFile userFile = new TbUserFile();
                userFile.setBelongUser(user.getUserId());
                userFile.setFileSize(existFile.getFileSize());
                userFile.setFileType(existFile.getFileType());
                int sameNameFile = userFileService.getSameNameFile(file.getOriginalFilename(), user.getUserId());
                if (sameNameFile > 0) {
                    model.addAttribute("msg", "云端有相同文件名文件，请重新上传！");
                    return "error";
                } else {
                    userFile.setUserFileName(file.getOriginalFilename());
                }
                userFile.setUserSysfileId(existFile.getFileId());
                // 这里还暂时获取不到用户需要存的位置，后期请补充
                userFile.setFileLocation(folder_id);
                userFileService.addFile(userFile);
                return "/views/home/console";
            }
            System.out.println(file.getOriginalFilename());
            String oldFileName = file.getOriginalFilename();
            // 文件扩展名开始的下标
            int dotIndex = oldFileName.indexOf(".");
            if (dotIndex == 0) {
                model.addAttribute("msg", "不支持的文件类型，请重试！");
                return "error";
            }
            String extension = oldFileName.substring(dotIndex);
            String newName = UUID.randomUUID().toString().substring(0, 15) + extension;
            String path = getDate();
            System.out.println(newName);
            System.out.println(extension);
            // 保存文件
            try {
                FtpUtil.uploadFile("182.254.180.106", 21, "image", "image", "/img", path, newName, file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /**
             * 写入数据库
             */
            TbSystemFile systemFile = new TbSystemFile();
            systemFile.setFileName(newName);
            systemFile.setFileSize(BigDecimal.valueOf(file.getSize() / 1024));
            systemFile.setFileMd5(fileMd5);
            systemFile.setUploadUser(user.getUserId());
            systemFile.setFileUrl("http://image.lzllzl.cn/img/" + path + "/" + newName);
            // 根据文件扩展名判断类型
            if (extension.toLowerCase().equals(".jpg") || extension.toLowerCase().equals(".png") || extension.toLowerCase().equals(".gif") || extension.toLowerCase().equals(".bmp")) {
                systemFile.setFileType("1");
            } else if (extension.toLowerCase().equals(".mp3") || extension.toLowerCase().equals(".wav") || extension.toLowerCase().equals(".flac") || extension.toLowerCase().equals(".wma")) {
                systemFile.setFileType("2");
            } else if (extension.toLowerCase().equals(".mp4") || extension.toLowerCase().equals(".avi") || extension.toLowerCase().equals(".flv") || extension.toLowerCase().equals(".mov")) {
                systemFile.setFileType("3");
            } else if (extension.toLowerCase().equals(".doc") || extension.toLowerCase().equals(".docx") || extension.toLowerCase().equals(".txt") || extension.toLowerCase().equals(".ppt") || extension.toLowerCase().equals(".pptx") || extension.toLowerCase().equals(".xls") || extension.toLowerCase().equals(".xlsx") || extension.toLowerCase().equals(".pdf")) {
                systemFile.setFileType("4");
            } else {
                systemFile.setFileType("5");
            }
            long newFileId = systemFileService.addFile(systemFile);
            TbUserFile userFile = new TbUserFile();
            userFile.setBelongUser(user.getUserId());
            userFile.setFileSize(systemFile.getFileSize());
            userFile.setFileType(systemFile.getFileType());
            userFile.setUserFileName(file.getOriginalFilename());
            userFile.setUserSysfileId(newFileId);
            //这里还暂时获取不到用户需要存的位置，后期请补充
            userFile.setFileLocation(folder_id);
            userFileService.addFile(userFile);
            return "/views/home/console";
        } else {
            model.addAttribute("msg", "上传发生错误，青重试！");
            return "error";
        }

    }

    /**
     * 获取当前如期作为文件夹名
     *
     * @return
     */
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        return format;
    }

}
