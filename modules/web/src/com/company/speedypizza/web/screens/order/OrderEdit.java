package com.company.speedypizza.web.screens.order;

import com.company.speedypizza.entity.Customer;
import com.company.speedypizza.entity.Dishes;
import com.company.speedypizza.entity.Order;
import com.company.speedypizza.service.OrdersService;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@UiController("speedypizza_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private OrdersService ordersService;


    @Subscribe(id = "dishesOrderedDc", target = Target.DATA_CONTAINER)
    private void onConsumablesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Dishes> event) {
        if (event.getChangeType() != CollectionChangeType.REFRESH) {
            refreshTotalPrice();
            refreshTotalDiscountAndDISHcount();
        }
    }

    @Subscribe
    private void onAfterCommitChanges(AfterCommitChangesEvent event) {
        Customer customer = getEditedEntity().getCustomer();
        customer.setOrderedTimesCount(customer.getOrderedTimesCount() + 1);
        event.getDataContext().commit();
    }


    @Subscribe("pickCustomer")
    private void onPickCustomerValueChange(HasValue.ValueChangeEvent<Customer> event) {
        Customer customer = getEditedEntity().getCustomer();
        getEditedEntity().setClientName(customer.getCustomerName());
        getEditedEntity().setClientPhone(customer.getCustomerPhone());

        if (customer.getIsRegistered()) {
            if (customer.getOrderedTimesCount() >= 50) {
                customer.setCustomerCurrentDiscount(BigDecimal.valueOf(15));
            } else if (customer.getOrderedTimesCount() >= 100) {
                customer.setCustomerCurrentDiscount(BigDecimal.valueOf(20));
            } else {
                customer.setCustomerCurrentDiscount(BigDecimal.ZERO);
            }
        } else {
            customer.setCustomerCurrentDiscount(BigDecimal.ZERO);
        }

        refreshTotalDiscountAndDISHcount();
        refreshTotalPrice();

    }


    @Subscribe
    private void onInitEntity(InitEntityEvent<Order> event) {
        Date date1 = new Date();
        Date date2 = new Date();

        long systemCurrTime = System.currentTimeMillis();
        long hourInMillis = 3600000L;

        date1.setTime(systemCurrTime);
        date2.setTime(systemCurrTime + hourInMillis);

        event.getEntity().setOrderTime(date1);
        event.getEntity().setDeliveryTime(date2);

        event.getEntity().setTotalDishCount(0);
    }

    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {


    }



    private void refreshTotalPrice() {
        Order order = getEditedEntity();
        Customer customer = getEditedEntity().getCustomer();

        if (!customer.getCustomerCurrentDiscount().equals(BigDecimal.ZERO)) {
            BigDecimal priceBeforeCustomerDiscount = ordersService.calculateTotalPrice(order);
            BigDecimal discountNow = priceBeforeCustomerDiscount
                    .subtract(priceBeforeCustomerDiscount
                            .subtract(priceBeforeCustomerDiscount
                                    .divide(customer.getCustomerCurrentDiscount(), 2, RoundingMode.HALF_EVEN)));

            order.setTotalPrice(priceBeforeCustomerDiscount.subtract(discountNow));
        } else {
            order.setTotalPrice(ordersService.calculateTotalPrice(order));
        }
    }


    private void refreshTotalDiscountAndDISHcount() {
        Order order = getEditedEntity();
        List<Dishes> dishesOrdered = order.getDishesOrdered();
        Integer dishCountPerOrder = 0;

        for (Dishes dish : dishesOrdered) {
            dishCountPerOrder += dish.getDishCountPerOrder();
        }
        order.setTotalDishCount(dishCountPerOrder);
        if (dishCountPerOrder > 3 && dishCountPerOrder <= 10) {
            order.setOrderCurrentDicount(BigDecimal.valueOf(5).add(getEditedEntity().getCustomer().getCustomerCurrentDiscount()));
        } else if (dishCountPerOrder > 10) {
            order.setOrderCurrentDicount(BigDecimal.TEN.add(getEditedEntity().getCustomer().getCustomerCurrentDiscount()));
        } else {
            order.setOrderCurrentDicount(BigDecimal.ZERO.add(getEditedEntity().getCustomer().getCustomerCurrentDiscount()));
        }
    }
}