package com.company.speedypizza.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Customer;

@UiController("speedypizza_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}