package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;


/**
 * Affiche le vaiqueur de la partie
 * 
 * Architecture:
 * rootWinner > winner
 */
public class PresentationWinner extends Presentation {

    private final PresentationTextOutput presentationTextOutput;

    public PresentationWinner(){

        presentationTextOutput = new PresentationTextOutput("default false winner");
        VueTextOutput vueTextOutput = new VueTextOutput(presentationTextOutput);
        presentationTextOutput.setVue(vueTextOutput);

    }

    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public void setText(String text) {
        presentationTextOutput.setUpText(text);
    }

}
