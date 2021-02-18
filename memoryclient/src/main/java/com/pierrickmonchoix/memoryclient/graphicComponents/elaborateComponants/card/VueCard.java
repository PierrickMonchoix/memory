package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.VueImage;

import javafx.scene.layout.VBox;

public class VueCard extends VBox implements IVue{

    private final VueImage vueImage;


    public VueCard(PresentationCard presentationCarte) {
        
        this.vueImage = new VueImage(presentationCarte.getPresentationImage());
        presentationCarte.getPresentationImage().setVue(vueImage);
        
        getChildren().addAll(vueImage);

        update();


    }
    

    @Override
    public void update() {
        vueImage.update();
    }

    
    
    
}
