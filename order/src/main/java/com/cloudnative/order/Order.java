package com.cloudnative.order;

import java.util.Date;

public class Order {
    String id;
    String productId;
    String userId;
    Date OrderedOn;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderedOn() {
        return this.OrderedOn;
    }

    public void setOrderedOn(Date OrderedOn) {
        this.OrderedOn = OrderedOn;
    }
}