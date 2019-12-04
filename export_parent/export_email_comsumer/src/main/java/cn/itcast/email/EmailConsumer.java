package cn.itcast.email;

import cn.itcast.utils.MailUtil;
import com.alibaba.fastjson.JSON;
import com.qiniu.util.Json;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.util.Map;

public class EmailConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        byte[] body = message.getBody();
//        把字节数组转成map
//        使用阿里巴巴的fastjson
        Map<String,String> map = JSON.parseObject(body, Map.class);
        String to = map.get("to");
        String subject = map.get("subject");
        String content = map.get("content");
        try {
            MailUtil.sendMsg(to,subject,content);
            System.out.println("邮件发送成功.......");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
