package com.xy.home.xiao20170311;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Xiao on 2017/2/22.
 */
public class Sender {
    public static void main(String[] args) throws Exception {
        // 第一步：建立ConnectionFactory工厂对象，需要填入用户名，密码，以及要连接的地址，均使用默认即可，默认端口为"tcp://localhost:61616"
        ConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "failover:(tcp://192.168.0.122:51511,tcp://192.168.0.122:51512,tcp://192.168.0.122:51513)?Randomize=false");

        // 第二步：通过ConnectionFactory工厂对象创建一个Connection连接，并且调用Connection的start方法开启连接，Connection默认是关闭的
        Connection connection = factory.createConnection();
        connection.start();

        // 第三步：通过Connection对象创建Session会话，用于接受消息，参数配置1为是否启用事务，参数配置2为签收模式，一般我们设置为自动签收
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        // 第四步：通过Session创建Destination对象，指的是一个客户端用来指定生产消息目标和消息来源的对象。在PTP模式中，Destination被称为Queue即队列；在Pub/Sub模式中，Destination被称为Topic即主题
        Destination destination = session.createQueue("queue1");

        // 第五步：我们需要通过Session对象创建消息的发送和接收对象（生产者和消费者）。MessageProducer/MessageConsumer
        MessageProducer producer = session.createProducer(destination);

        // 第六步：我们可以使用MessageProducer的setDeliveryMode方法为其设置持久化特性和非持久化特性（DeliveryMode）
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // 第七步：我们最后使用JMS规范的TextMessage形式创建数据（通过Session对象创建），并用MessageProducer的send方法发送数据。同理客户端使用receive方法接收数据
        for (int i = 1; i <= 500000; i++) {
            TextMessage message = session.createTextMessage();
            message.setText("it is a message, id is " + i);
            producer.send(message);
        }

        // 第八步：关闭Connection对象，会递归关闭所有，比如Session
        if(connection != null) {
            connection.close();
        }

        // 第九步：打开浏览器，访问http://localhost:8161下，查看消息情况
    }
}
