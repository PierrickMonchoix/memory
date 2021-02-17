package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;

public class PresentationGameProposal extends Presentation {

    private final PresentationTextOutput presentationTextOutput;
    private final PresentationButton presentationButton;

    private final String pseudo;

    public PresentationGameProposal(String pseudo) {
        this.pseudo = pseudo;
        

        presentationTextOutput = new PresentationTextOutput("Partie de " + pseudo);
        presentationButton = new PresentationButton("GO!");

    }

    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }


    public String getPseudo() {
        return this.pseudo;
    }





 

    


    
    
}
