package com.company.speedypizza.web.screens.dishtypes;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.DishTypes;

@UiController("speedypizza_DishTypes.edit")
@UiDescriptor("dish-types-edit.xml")
@EditedEntityContainer("dishTypesDc")
@LoadDataBeforeShow
public class DishTypesEdit extends StandardEditor<DishTypes> {
}