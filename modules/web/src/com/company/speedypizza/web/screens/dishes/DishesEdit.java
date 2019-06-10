package com.company.speedypizza.web.screens.dishes;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Dishes;

import javax.inject.Inject;

@UiController("speedypizza_Dishes.edit")
@UiDescriptor("dishes-edit.xml")
@EditedEntityContainer("dishesDc")
@LoadDataBeforeShow
public class DishesEdit extends StandardEditor<Dishes> {


//    @Inject
//    private TextField<Integer> dishCountPerOrder;
//
//    @Subscribe
//    private void onInitEntity(InitEntityEvent<Dishes> event) {
//        event.getEntity().setDishCountPerOrder();
//    }

}