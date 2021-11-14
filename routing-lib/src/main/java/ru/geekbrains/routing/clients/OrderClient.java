package ru.geekbrains.routing.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ms-orders")
public interface OrderClient {
}