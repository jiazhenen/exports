package cn.itcast;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CompanyProvider {

    public static void main(String[] args) throws IOException {
//        加载配置文件，启动容器
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
        app.start();
        System.in.read(); //等待控制台回车。如果不回车就一直卡这儿不继续
    }
}
