package com.company.speedypizza.service;

import com.company.speedypizza.entity.Dishes;
import com.company.speedypizza.entity.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service(OrdersService.NAME)
public class OrdersServiceBean implements OrdersService {

    @Override
    public BigDecimal calculateTotalPrice(Order order) {

        final List<Dishes> orderedDishes = order.getDishesOrdered();
        BigDecimal price = BigDecimal.ZERO;

        BigDecimal orderDiscount;

        Integer dishCountPerOrder = 0;
        for (Dishes dish : orderedDishes) {
            dishCountPerOrder += dish.getDishCountPerOrder();
        }


        if (dishCountPerOrder > 3 && dishCountPerOrder <= 10) {
            orderDiscount = BigDecimal.valueOf(5);
            price = priceCalculator(orderedDishes, price, orderDiscount);

        } else if (dishCountPerOrder > 10) {
            orderDiscount = BigDecimal.valueOf(10);
            price = priceCalculator(orderedDishes, price, orderDiscount);

        } else {
            for (Dishes dish : orderedDishes) {
                BigDecimal numberOfDishes = new BigDecimal(dish.getDishCountPerOrder());
                BigDecimal currentPayingForDishType = dish.getPrice().multiply(numberOfDishes);
                price = price.add(currentPayingForDishType);
            }
        }


        return price;
    }

    private BigDecimal priceCalculator(List<Dishes> orderedDishes,
                                       BigDecimal price,
                                       BigDecimal orderDiscount) {
        for (Dishes dish : orderedDishes) {
            BigDecimal numberOfDishes = new BigDecimal(dish.getDishCountPerOrder());
            BigDecimal currentPayingForDishType = dish.getPrice().multiply(numberOfDishes);
            price = price.add(currentPayingForDishType);
        }
        price = price.subtract(price.multiply(orderDiscount.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)));
        return price;
    }

}