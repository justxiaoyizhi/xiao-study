package home.xiao20170405;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import home.constvar.SysConstVar;

import java.util.List;

/**
 * Created by Xiao on 2017/4/5.
 */
public class RocketMQConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("quite-start-consumer");
        consumer.setNamesrvAddr("192.168.0.122:9876;192.168.0.123:9876");
        consumer.subscribe("topicA", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try {
                    for (MessageExt messageExt : list) {
                        System.out.println(messageExt.getTopic() + "----" + messageExt.getTags() + "----" + new String(messageExt.getBody(), SysConstVar.DEFAULT_CHAESET));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer started");
    }
}
