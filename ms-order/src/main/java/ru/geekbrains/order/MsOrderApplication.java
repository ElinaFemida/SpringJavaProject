package ru.geekbrains.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "ru.geekbrains")
@SpringBootApplication(scanBasePackages = "ru.geekbrains")
public class MsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class, args);
    }

}