package com.controller;

import com.mapper.TbUserFileMapper;
import com.mapper.TbUserMapper;
import com.pojo.TbSystemFile;
import com.pojo.TbUser;
import com.pojo.TbUserFile;
import com.pojo.TbUserFileExample;
import com.service.UserService;
import com.utils.FtpUtil;
import com.utils.MD5Util;
import com.utils.MailUtil;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @Auther: zayvion
 * @Date: 2019-08-26 14:50
 * @Description:用户模块controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TbUserFileMapper userFileMapper;

    /**
     * 用户注册
     *
     * @param user     用户实体，前台传过来直接封装
     * @param session
     * @param mailCode 邮箱验证码，前台传过来
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(@ModelAttribute("user") TbUser user, HttpSession session, @RequestParam String mailCode, Model model) {
        if (((String) session.getAttribute("regCode")).equals(mailCode)) {
            userService.addUser(user);
            session.setAttribute("onlineuser", user);
            model.addAttribute("msg", "恭喜您，注册成功！");
            return "user/login";
        }
        // 验证码不正确向前台传值
        model.addAttribute("msg", "验证码输入错误！");
        return "user/reg";
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param model
     * @param session
     * @return 登录成功重定向到index.jsp，失败返回login.jsp并给出提示
     */
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        TbUser user = userService.login(username, password);
        if (user != null) {
            TbUserFileExample userFileExample = new TbUserFileExample();
            TbUserFileExample.Criteria fileExampleCriteria = userFileExample.createCriteria();
            fileExampleCriteria.andBelongUserEqualTo(user.getUserId());
            List<TbUserFile> tbUserFiles = userFileMapper.selectByExample(userFileExample);
            double sum = 0.0;
            for (TbUserFile tbUserFile : tbUserFiles) {
                sum = sum + tbUserFile.getFileSize().doubleValue();
            }
            DecimalFormat decimalFormat=new DecimalFormat(".0");
            String format = decimalFormat.format(sum/1024);
            // 登录成功将用户对象放入session
            session.setAttribute("onlineuser", user);
            session.setAttribute("userTotalSize", format);
            session.setAttribute("TotalSize", user.getDriveSize()/1024);
            session.setAttribute("sizePresent",  decimalFormat.format(sum/1024/(user.getDriveSize()/1024)*100));
            return "redirect:/index";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "user/login";
    }

    /**
     * 获取注册时的邮箱验证码
     *
     * @param mailBox 用户邮箱
     * @param session
     * @return json
     */
    @RequestMapping("/sendRegCode")
    @ResponseBody
    public String sendRegCode(@RequestParam String mailBox, HttpSession session) {
        String redomCode = getRedomCode(4);
        MailUtil.sendMail(mailBox, redomCode, "您正在注册FlodaDrive网盘，您的验证码为:");
        session.setAttribute("regCode", redomCode);
        return ResponseResult.ok();
    }

    /**
     * 修改密码获取验证码
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/sendUpdatePasswordCode",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String sendUpdatePasswordCode( HttpSession session,Model model) {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user.getUserEmail() == null||user.getUserEmail().equals("")) {
            return ResponseResult.build(500, "您还没有填写邮箱，请您在个人资料页面补全邮箱再试！");
        }
        String redomCode = getRedomCode(4);
        MailUtil.sendMail(user.getUserEmail(), redomCode, "您正在使用FlodaDrive网盘重置密码，您的验证码为:");
        session.setAttribute("regCode", redomCode);
        return ResponseResult.ok();
    }

    @RequestMapping(value = "/updatePassword",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updatePassword(String password,String mailCode,HttpSession session) {
        try {
            TbUser onlineuser = (TbUser) session.getAttribute("onlineuser");
            TbUser tbUser = new TbUser();
            tbUser.setUserId(onlineuser.getUserId());
            tbUser.setUserPassword(MD5Util.getMD5(password));
            userService.updateInfo(tbUser);
            return ResponseResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.build(500, "发生错误!");
    }


    /**
     * 用户登出
     *
     * @param session
     * @return login.jsp
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("onlineuser");
        return "redirect:/user/login.jsp";
    }

    /**
     * 获取用户的资料
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/info")
    public String getUserInfo(HttpSession session, Model model) {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        if (user == null) {
            model.addAttribute("msg", "登录状态错误，请重新登录后再试！");
            return "error";
        }

        return "views/set/user/info";
    }

    /**
     * 修改用户的资料
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/updateInfo")
    public String updateInfo(@ModelAttribute TbUser user, Model model,HttpSession session) {
        TbUser onlineuser = (TbUser) session.getAttribute("onlineuser");
        System.out.println(user);
        if (onlineuser == null) {
            model.addAttribute("msg", "登录状态错误，请重新登录后再试！");
            return "error";
        }
        user.setUserId(onlineuser.getUserId());
        userService.updateInfo(user);
        session.setAttribute("onlineuser", userService.getUserInfo(onlineuser.getUserId()));
        return "views/set/user/info";
    }

    /**
     * 用户上传头像
     * @param session
     * @param file
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadImg")
    public String uploadImg(HttpSession session, @RequestParam("img") MultipartFile file, Model model) throws IOException {
        TbUser user = (TbUser) session.getAttribute("onlineuser");
        // session没有用户信息直接返回错误信息
        if (user == null){
            model.addAttribute("msg","登录信息异常，请退出后重新登录！");
            return "error";
    }
            System.out.println(file.getOriginalFilename());
            String oldFileName = file.getOriginalFilename();
            String extension = oldFileName.substring(oldFileName.indexOf("."));
            String newName = UUID.randomUUID().toString().substring(0, 15) + extension;
            String path = getDate();
            System.out.println(newName);
            System.out.println(extension);
            // 保存文件,并写入数据库
            try {
                FtpUtil.uploadFile("182.254.180.106", 21, "image", "image", "/img", path, newName, file.getInputStream());
                TbUser u = new TbUser();
                u.setUserId(user.getUserId());
                u.setUserImgurl("http://image.lzllzl.cn/img/" + path + "/" + newName);
                userService.updateInfo(u);
                session.setAttribute("onlineuser", userService.getUserInfo(user.getUserId()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        //返回页面
        return "redirect:/user/info";
    }

    /**
     * 获取一串随机验证码
     *
     * @param n 需要多少位
     * @return string串
     */
    public String getRedomCode(int n) {
        String str = "1234567890qwertyuioplkjhgfdsazxcvbnm";
        Random r = new Random();
        String ss = "";
        for (int i = 0; i < n; i++) {
            char c = str.charAt(r.nextInt(str.length()));
            ss = ss + c;
        }
        return ss;
    }

    /**
     * 获取当前如期作为文件夹名
     * @return
     */
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        return format;
    }

}
