package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.createGame;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.VueButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers.VueHowManyPlayers;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;



public class VueCreateGame extends LinearLayout implements IVue{

    private final VueHowManyPlayers vueHowManyPlayers;
    private final VueTextOutput vueTextOutput;
    private final VueButtonCreateGame vueButtonCreateGame;


    public VueCreateGame(PresentationCreateGame presentationCreateGame) {
        super(ContextHelper.getContext()); // ecart entre composants
        this.vueHowManyPlayers = (VueHowManyPlayers) presentationCreateGame.getPresentationHowManyPlayers().getVue();
        this.vueTextOutput = (VueTextOutput) presentationCreateGame.getPresentationTextOutput().getVue();
        this.vueButtonCreateGame = (VueButtonCreateGame) presentationCreateGame.getPresentationButtonCreateGame().getVue();
        
        addView(vueTextOutput);
        addView(vueHowManyPlayers);
        addView(vueButtonCreateGame);

        setOrientation(HORIZONTAL);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {  // only upgrade position
            //nothing to MOVE
    }





    
}
