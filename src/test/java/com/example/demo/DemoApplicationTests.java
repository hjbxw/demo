package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    ApplicationContext ioc;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        boolean b=ioc.containsBean("helloService");
        System.out.println(b);
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1633367715@qq.com");
        message.setTo("pgmerxw@163.com");
        message.setSubject("主题：测试功能");
        message.setText("测试邮件发送代码功能测试");

        mailSender.send(message);
    }

}
