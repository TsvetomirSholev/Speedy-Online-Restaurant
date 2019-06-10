package com.company.speedypizza.web.screens.ingredients;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Ingredients;

@UiController("speedypizza_Ingredients.edit")
@UiDescriptor("ingredients-edit.xml")
@EditedEntityContainer("ingredientsDc")
@LoadDataBeforeShow
public class IngredientsEdit extends StandardEditor<Ingredients> {
}