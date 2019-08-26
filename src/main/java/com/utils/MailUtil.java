package com.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 邮箱工具类
 * @author Zayvion
 * @date Aug 5, 2019
 */
public class MailUtil {
	 //使用对象注入的方式  记得配置文件   
    private static JavaMailSenderImpl senderImpl;
    private static SimpleMailMessage mailMessage;
    private static Properties prop;
    static {
    	senderImpl=new JavaMailSenderImpl();
    	mailMessage=new SimpleMailMessage();
    	prop=new Properties();
    }
    //发送验证码的方法,to是目标邮箱地址，code是发送的验证码（事先生成）
    public static boolean sendMail (String to,String code, String content) {
        try{
            //设定mail server
            senderImpl.setHost("smtp.qq.com");

            // 设置收件人，寄件人 用数组发送多个邮件

            mailMessage.setTo(to); 
            mailMessage.setFrom( "davy199766@vip.qq.com" );
            mailMessage.setSubject( "FlodaDrive-您的私人网盘" );
            mailMessage.setText(content + code+"!");

            senderImpl.setUsername("davy199766@vip.qq.com");
            senderImpl.setPassword("xhxxpqvhrjgxbhdf");
            
           
            prop.put("mail.smtp.auth","true");
            prop.put("mail.smtp.ssl.enable","true");
            prop.put("mail.smtp.timeout","25000");
            senderImpl.setJavaMailProperties(prop);

            //发送邮件
            senderImpl.send(mailMessage);

            System.out.println("发送邮件成功,邮箱验证码是："+code);

            return true;
        }catch (Exception e) {
            System.out.println("发送邮件失败");
            System.out.println(prop);
            return false;
        }
    }

}