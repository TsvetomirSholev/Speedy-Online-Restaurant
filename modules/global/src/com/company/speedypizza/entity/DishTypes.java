package com.company.speedypizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|dishType")
@Table(name = "SPEEDYPIZZA_DISH_TYPES")
@Entity(name = "speedypizza_DishTypes")
public class DishTypes extends StandardEntity {
    private static final long serialVersionUID = -6160000902418556231L;

    @NotNull(message = "dishType should not be null")
    @Column(name = "DISH_TYPE", nullable = false, unique = true)
    protected String dishType;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "dishType")
    protected Dishes dishes;

    @OneToMany(mappedBy = "dishTypes")
    protected List<Ingredients> ingridientsForDishType;

    public List<Ingredients> getIngridientsForDishType() {
        return ingridientsForDishType;
    }

    public void setIngridientsForDishType(List<Ingredients> ingridientsForDishType) {
        this.ingridientsForDishType = ingridientsForDishType;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }
}