package com.company.speedypizza.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Order;

@UiController("speedypizza_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}