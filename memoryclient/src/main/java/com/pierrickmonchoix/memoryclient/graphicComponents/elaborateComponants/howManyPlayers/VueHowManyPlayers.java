package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox.VueComboBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


public class VueHowManyPlayers extends VBox implements IVue{

    private final VueComboBox vueComboBox;


    public VueHowManyPlayers(PresentationHowManyPlayers presentationHowManyPlayers) {
        this.vueComboBox = (VueComboBox)presentationHowManyPlayers.getPresentationComboBox().getVue();
        
        getChildren().addAll(vueComboBox);

        setPadding(new Insets(0,0,0,0));

        updateFromPresentation();
 
 
    }


    @Override
    public void updateFromPresentation() {
        // nothing to move
        
    }

    








    
}
