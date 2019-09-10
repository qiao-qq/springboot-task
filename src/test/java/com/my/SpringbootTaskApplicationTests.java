package com.my;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;


    //邮件发送
    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();

        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        message.setTo("2682557218@qq.com");
        message.setFrom("1692165877@qq.com");

        mailSender.send(message);
    }

    //带附件的邮件
    @Test
    public void test02() throws Exception {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("给你的图片");
        helper.setText("<b style='color:red'>爱你呦</b>", true);

        helper.setTo("2682557218@qq.com");
        helper.setFrom("1692165877@qq.com");

        //上传文件
        helper.addAttachment("1.jpg", new File("C:\\Users\\HP\\Pictures\\1.jpg"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\HP\\Pictures\\2.jpg"));

        mailSender.send(mimeMessage);

    }
}


