package producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Producer {
    private static final String EXCHANGE_NAME = "blog";

    public static void main(String[] argv) throws Exception {
        System.out.println("Write smth on the topic: [topic theme] + content");
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String article = reader.readLine();
        String[] articleName = article.split(" ");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

            String routingKey = "com.gb.blog." + articleName[0];
            String message = article.replace(articleName[0] + " ", "");

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }
    }
}