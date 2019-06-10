package com.company.speedypizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NamePattern("%s|dishName")
@Table(name = "SPEEDYPIZZA_DISHES")
@Entity(name = "speedypizza_Dishes")
public class Dishes extends StandardEntity {
    private static final long serialVersionUID = -3783474435774632581L;

    @NotNull(message = "Please add dish price")
    @Column(name = "PRICE")
    protected BigDecimal price;

    @NotNull(message = "Please add dish Type (Pizza,Pasta,Salad)")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISH_TYPE_ID")
    protected DishTypes dishType;

    @NotNull(message = "Please add dish name !")
    @Column(name = "DISH_NAME")
    protected String dishName;

    @NotNull(message = "Please add ingredients to this dish !")
    @JoinTable(name = "SPEEDYPIZZA_DISHES_INGREDIENTS_LINK",
            joinColumns = @JoinColumn(name = "DISHES_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENTS_ID"))
    @ManyToMany
    protected List<Ingredients> dishIngridients;

    @JoinTable(name = "SPEEDYPIZZA_ORDER_DISHES_LINK",
            joinColumns = @JoinColumn(name = "DISHES_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    @ManyToMany
    protected List<Order> orders;

    @Min(message = "You can Order a minimum of 1 dish !", value = 1)
    @Column(name = "DISH_COUNT_PER_ORDER")
    protected Integer dishCountPerOrder;

    public Integer getDishCountPerOrder() {
        return dishCountPerOrder;
    }

    public void setDishCountPerOrder(Integer dishCountPerOrder) {
        this.dishCountPerOrder = dishCountPerOrder;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Ingredients> getDishIngridients() {
        return dishIngridients;
    }

    public void setDishIngridients(List<Ingredients> dishIngridients) {
        this.dishIngridients = dishIngridients;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public DishTypes getDishType() {
        return dishType;
    }

    public void setDishType(DishTypes dishType) {
        this.dishType = dishType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}