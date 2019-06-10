package com.company.speedypizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s|ingredientType")
@Table(name = "SPEEDYPIZZA_INGREDIENTS")
@Entity(name = "speedypizza_Ingredients")
public class Ingredients extends StandardEntity {
    private static final long serialVersionUID = 7565959185345758369L;

    @Column(name = "INGREDIENT_TYPE")
    protected String ingredientType;

    @JoinTable(name = "SPEEDYPIZZA_DISHES_INGREDIENTS_LINK",
            joinColumns = @JoinColumn(name = "INGREDIENTS_ID"),
            inverseJoinColumns = @JoinColumn(name = "DISHES_ID"))
    @ManyToMany
    protected List<Dishes> disheses;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISH_TYPES_ID")
    protected DishTypes dishTypes;

    public DishTypes getDishTypes() {
        return dishTypes;
    }

    public void setDishTypes(DishTypes dishTypes) {
        this.dishTypes = dishTypes;
    }

    public List<Dishes> getDisheses() {
        return disheses;
    }

    public void setDisheses(List<Dishes> disheses) {
        this.disheses = disheses;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }
}