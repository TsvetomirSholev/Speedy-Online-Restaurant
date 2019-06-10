package com.company.speedypizza.service;

import com.company.speedypizza.entity.Customer;
import com.company.speedypizza.entity.Order;
import org.springframework.stereotype.Service;

@Service(CustomersService.NAME)
public class CustomersServiceBean implements CustomersService {

    @Override
    public Customer getCustomerByOrder(Order order) {


        return null;
    }
}