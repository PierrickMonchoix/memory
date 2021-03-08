package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.VueImage;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueCard extends LinearLayout implements IVue{

    private final VueImage vueImage;


    public VueCard(PresentationCard presentationCard) {
        super(ContextHelper.getContext());
        
        vueImage = (VueImage) presentationCard.getPresentationImage().getVue();
        
        addView(vueImage);


        updateFromPresentation();
    }
    

    @Override
    public void updateFromPresentation() {
        //nothing to move or delete/create
    }

    
    
    
}
