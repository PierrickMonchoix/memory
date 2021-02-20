package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.VueImage;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.layout.VBox;

public class VueCard extends VBox implements IVue{

    private final VueImage vueImage;


    public VueCard(PresentationCard presentationCard) {
        
        vueImage = (VueImage) presentationCard.getPresentationImage().getVue();
        
        getChildren().addAll(vueImage);


        updateFromPresentation();
    }
    

    @Override
    public void updateFromPresentation() {
        //nothing to move or delete/create
    }

    
    
    
}
