package com.company.speedypizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NamePattern("%s %s|customerName,customerPhone")
@Table(name = "SPEEDYPIZZA_CUSTOMER")
@Entity(name = "speedypizza_Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -4239334025488336731L;

    @Column(name = "IS_REGISTERED")
    protected Boolean isRegistered;

    @Column(name = "ORDERED_TIMES_COUNT")
    protected Integer orderedTimesCount;

    @Column(name = "CUSTOMER_CURRENT_DISCOUNT")
    protected BigDecimal customerCurrentDiscount;

    @OneToMany(mappedBy = "customer")
    protected List<Order> customerOrder;

    @NotNull(message = "Please enter your name!")
    @Column(name = "CUSTOMER_NAME")
    protected String customerName;

    @NotNull(message = "Please enter your phone !")
    @Column(name = "CUSTOMER_PHONE")
    protected String customerPhone;

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerCurrentDiscount(BigDecimal customerCurrentDiscount) {
        this.customerCurrentDiscount = customerCurrentDiscount;
    }

    public BigDecimal getCustomerCurrentDiscount() {
        return customerCurrentDiscount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(List<Order> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Integer getOrderedTimesCount() {
        return orderedTimesCount;
    }

    public void setOrderedTimesCount(Integer orderedTimesCount) {
        this.orderedTimesCount = orderedTimesCount;
    }

    public Boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}