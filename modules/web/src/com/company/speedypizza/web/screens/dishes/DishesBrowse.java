package com.company.speedypizza.web.screens.dishes;

import com.company.speedypizza.entity.Ingredients;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Dishes;
import org.apache.log4j.Layout;

import javax.inject.Inject;
import java.util.List;

@UiController("speedypizza_Dishes.browse")
@UiDescriptor("dishes-browse.xml")
@LookupComponent("dishesesTable")
@LoadDataBeforeShow
public class DishesBrowse extends StandardLookup<Dishes> {

    @Inject
    private GroupTable<Dishes> dishesesTable;
    @Inject
    private CollectionContainer<Dishes> dishesesDc;
    @Inject
    private UiComponents uiComponents;


    @Subscribe
    private void onInit(InitEvent event) {
        dishesesTable.addGeneratedColumn("ingredients", entity -> {

            List<Ingredients> dishIngridients = entity.getDishIngridients();
            Label label = uiComponents.create(Label.TYPE_STRING);
            StringBuilder sb = new StringBuilder();
            for (Ingredients ingredient : dishIngridients){
                sb.append(ingredient.getIngredientType()).append(", ");


            }
            label.setValue(sb);

            return label;
        });

    }


}