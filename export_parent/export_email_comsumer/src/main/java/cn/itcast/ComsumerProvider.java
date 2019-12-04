package cn.itcast;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ComsumerProvider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mq-receive.xml");
        app.start();
        System.in.read();
    }
}
