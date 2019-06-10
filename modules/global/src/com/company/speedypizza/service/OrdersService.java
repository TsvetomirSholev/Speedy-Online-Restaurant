package com.company.speedypizza.service;

import com.company.speedypizza.entity.Order;

import java.math.BigDecimal;

public interface OrdersService {
    String NAME = "speedypizza_OrdersService";

    BigDecimal calculateTotalPrice(Order order);

//    igDecimal setCurrentOrderDiscount(Order order ,Integer discount);B
}