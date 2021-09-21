package consumer;

import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private final static String EXCHANGE_NAME = "blog";

    public static void main(String[] args) throws Exception {
        System.out.println("Choose topic theme: [subscribe] + [theme]");
        List<String> subscribeThemes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectTop;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String queueName = channel.queueDeclare().getQueue();

        while (true) {
            selectTop = reader.readLine();
            if (selectTop.startsWith("subscribe")) {
                selectTop = selectTop.replace("subscribe ", "");
                break;
            }
            else System.out.println("Choose topic theme: [subscribe] + [theme]");
        }

        String routingKey = "com.gb.blog." + selectTop + ".#";
        channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
        subscribeThemes.add(selectTop);
        System.out.println(" [*] Waiting for messages with routing key (" + routingKey + "):");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "'\n'" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });

        selectTop = reader.readLine();
        if (selectTop.startsWith("subscribe")) {
            selectTop = selectTop.replace("subscribe", "");
            routingKey = "com.gb.blog" + selectTop + ".#";
            channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
            subscribeThemes.add(selectTop);
            System.out.println(" [!] Add topic (" + selectTop + "):");
        }

    }
}