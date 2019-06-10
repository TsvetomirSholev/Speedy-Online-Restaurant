package com.company.speedypizza.service;

import com.company.speedypizza.entity.Customer;
import com.company.speedypizza.entity.Order;

public interface CustomersService {
    String NAME = "speedypizza_CustomersService";

    Customer getCustomerByOrder(Order order);
}