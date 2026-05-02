package com.devsuperior.desafio1;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class Desafio1Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    static void main(String[] args) {
        SpringApplication.run(Desafio1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order(1034, 150.00, 20.0);
        System.out.println("Order Code: " + order.getCode());
        System.out.printf("Order total value: $%.2f%n", orderService.total(order));
    }
}
