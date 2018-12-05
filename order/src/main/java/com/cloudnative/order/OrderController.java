package com.cloudnative.order;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/orders")
public class OrderController {

    private final MessageSender messageSender;

    @Autowired
    public OrderController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ping() {
        return "Pong";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void order(@RequestBody Order order) {
        order.id = UUID.randomUUID().toString();
        messageSender.Send(order);
    }

}
