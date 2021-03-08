package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox.VueComboBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;



public class VueHowManyPlayers extends LinearLayout implements IVue{

    private final VueComboBox vueComboBox;


    public VueHowManyPlayers(PresentationHowManyPlayers presentationHowManyPlayers) {
        super(ContextHelper.getContext());
        this.vueComboBox = (VueComboBox)presentationHowManyPlayers.getPresentationComboBox().getVue();
        
        addView(vueComboBox);

        updateFromPresentation();
 
 
    }


    @Override
    public void updateFromPresentation() {
        // nothing to move
        
    }

    








    
}
