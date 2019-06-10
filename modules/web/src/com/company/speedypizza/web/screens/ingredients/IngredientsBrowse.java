package com.company.speedypizza.web.screens.ingredients;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Ingredients;

@UiController("speedypizza_Ingredients.browse")
@UiDescriptor("ingredients-browse.xml")
@LookupComponent("ingredientsesTable")
@LoadDataBeforeShow
public class IngredientsBrowse extends StandardLookup<Ingredients> {
}