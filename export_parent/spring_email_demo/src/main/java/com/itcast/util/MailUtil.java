package com.itcast.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class MailUtil {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to,String subject,String context){
//        把mimeMessage当成邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom("itcast_server@sina.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public void sendEmailWithAttachment(String to,String subject,String context){
//        把mimeMessage当成邮件对象
        try {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("itcast_server@sina.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context);
            helper.addAttachment("b1.jpg",new File("C:\\Users\\syl\\Pictures\\b1.jpg"));
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailWithAttachmentAndContentPic(String to,String subject,String context){
//        把mimeMessage当成邮件对象
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("itcast_server@sina.com");
            helper.setTo(to);
            helper.setSubject(subject);
//            helper.setText("<img src='https://wenhui.whb.cn/u/cms/www/201911/30164016la2q.jpg'>",true);
            helper.setText("<img src='cid:myCid'>",true);
            helper.addInline("myCid",new File("C:\\Users\\syl\\Pictures\\b1.jpg"));
            helper.addAttachment("b1.jpg",new File("C:\\Users\\syl\\Pictures\\b1.jpg"));
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
