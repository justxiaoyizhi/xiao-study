package home.xiao20170405;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import home.constvar.SysConstVar;

/**
 * Created by Xiao on 2017/4/5.
 */
public class RocketMQProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("quite-start-producer");
        producer.setNamesrvAddr("192.168.0.122:9876;192.168.0.123:9876");
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                Message message = new Message("topicA","tagsB",("helloworld"+i).getBytes(SysConstVar.DEFAULT_CHAESET));
                SendResult result = producer.send(message);
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}
