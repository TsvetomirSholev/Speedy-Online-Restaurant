package com.company.speedypizza.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Customer;

import java.math.BigDecimal;

@UiController("speedypizza_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {

    @Subscribe
    private void onInitEntity(InitEntityEvent<Customer> event) {
        event.getEntity().setIsRegistered(true);
        event.getEntity().setOrderedTimesCount(0);
        event.getEntity().setCustomerCurrentDiscount(BigDecimal.ZERO);
//        event.getEntity().setCubaUser();
    }
}