package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.createGame;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.VueButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers.VueHowManyPlayers;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.layout.HBox;


public class VueCreateGame extends HBox implements IVue{

    private final VueHowManyPlayers vueHowManyPlayers;
    private final VueTextOutput vueTextOutput;
    private final VueButtonCreateGame vueButtonCreateGame;


    public VueCreateGame(PresentationCreateGame presentationCreateGame) {
        super(20); // ecart entre composants
        this.vueHowManyPlayers = (VueHowManyPlayers) presentationCreateGame.getPresentationHowManyPlayers().getVue();
        this.vueTextOutput = (VueTextOutput) presentationCreateGame.getPresentationTextOutput().getVue();
        this.vueButtonCreateGame = (VueButtonCreateGame) presentationCreateGame.getPresentationButtonCreateGame().getVue();
        
        this.getChildren().addAll(vueTextOutput);
        this.getChildren().addAll(vueHowManyPlayers);
        this.getChildren().addAll(vueButtonCreateGame);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {  // only upgrade position
            //nothing to MOVE
    }





    
}
