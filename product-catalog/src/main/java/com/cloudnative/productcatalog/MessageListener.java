package com.cloudnative.productcatalog;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    CrudRepository<Order, String> repository;

    @Autowired
    public MessageListener(CrudRepository<Order, String> repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void process(Order order) {
        System.out.println("QUEUE MESSAGE LISTENER");
        System.out.println(order.productId);
        this.repository.save(order);
    }
}