package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

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

}
