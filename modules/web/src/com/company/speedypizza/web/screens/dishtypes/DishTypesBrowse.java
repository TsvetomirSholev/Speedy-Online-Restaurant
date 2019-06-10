package com.company.speedypizza.web.screens.dishtypes;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.DishTypes;

@UiController("speedypizza_DishTypes.browse")
@UiDescriptor("dish-types-browse.xml")
@LookupComponent("dishTypesesTable")
@LoadDataBeforeShow
public class DishTypesBrowse extends StandardLookup<DishTypes> {
}