import com.alibaba.fastjson.JSONObject;
import com.fk.rabbit.message.CommonMessage;
import com.fk.rabbit.message.MessageHandler;
import com.fk.rabbit.service.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-amqp.xml")
public class RabbitMQDemo {
    @Resource
    private MessageSender messageSender;

    @Resource
    private MessageHandler messageHandler;

    @Test
    public void testSendMessage(){
        CommonMessage message = new CommonMessage();
        message.setSource("tonson");
        JSONObject obj = new JSONObject();
        obj.put("test", "test json message");
        message.setMessage(obj);
        messageSender.setRoutingKey("message.tonson");
        messageSender.sendDataToQueue(message);
    }

    @Test
    public void testGetMessage(){
/*CommonMessage message = new CommonMessage();
        message.setSource("tonson");
        messageHandler.handleMessage(message);*/
    }
}
