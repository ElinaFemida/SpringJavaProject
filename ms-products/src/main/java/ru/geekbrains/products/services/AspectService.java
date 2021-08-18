package ru.geekbrains.products.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {

    @Before("execution(public * ru.geekbrains.products.controllers.ProductController.*(..))")
    public void beforeFindProductById(JoinPoint thisJoinPoint) {
        Object[] args = thisJoinPoint.getArgs();
        if (args.length != 0) {
            for (Object signatureArg : args) {
                System.out.println("Аргумент: " + signatureArg);
            }
        } else
            System.out.println("Аргументов нет");
    }
}