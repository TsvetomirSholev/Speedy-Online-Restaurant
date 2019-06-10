package com.company.speedypizza.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "SPEEDYPIZZA_ORDER")
@Entity(name = "speedypizza_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -90713938513418840L;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "ORDER_TIME", nullable = false)
    protected Date orderTime;

    @Column(name = "CLIENT_NAME")
    protected String clientName;

    @Column(name = "CLIENT_PHONE")
    protected String clientPhone;

    @NotNull(message = "We need to know where to deliver the food ,please!")
    @Column(name = "CLIENT_ORDER_ADDRESS")
    protected String clientOrderAddress;

    @Column(name = "TOTAL_PRICE")
    protected BigDecimal totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELIVERY_TIME")
    protected Date deliveryTime;

    @Column(name = "ORDER_CURRENT_DICOUNT")
    protected BigDecimal orderCurrentDicount;

    @NotNull(message = "Please enter a customer ,who made the order !")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @JoinTable(name = "SPEEDYPIZZA_ORDER_DISHES_LINK", joinColumns = @JoinColumn(name = "ORDER_ID"), inverseJoinColumns = @JoinColumn(name = "DISHES_ID"))
    @ManyToMany
    protected List<Dishes> dishesOrdered;

    @Column(name = "TOTAL_DISH_COUNT")
    protected Integer totalDishCount;

    @Column(name = "SPECIAL_DELIVERY_INSTRUCTIONS")
    protected String specialDeliveryInstructions;

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getSpecialDeliveryInstructions() {
        return specialDeliveryInstructions;
    }

    public void setSpecialDeliveryInstructions(String specialDeliveryInstructions) {
        this.specialDeliveryInstructions = specialDeliveryInstructions;
    }

    public Integer getTotalDishCount() {
        return totalDishCount;
    }

    public void setTotalDishCount(Integer totalDishCount) {
        this.totalDishCount = totalDishCount;
    }

    public void setOrderCurrentDicount(BigDecimal orderCurrentDicount) {
        this.orderCurrentDicount = orderCurrentDicount;
    }

    public BigDecimal getOrderCurrentDicount() {
        return orderCurrentDicount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Dishes> getDishesOrdered() {
        return dishesOrdered;
    }

    public void setDishesOrdered(List<Dishes> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getClientOrderAddress() {
        return clientOrderAddress;
    }

    public void setClientOrderAddress(String clientOrderAddress) {
        this.clientOrderAddress = clientOrderAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}