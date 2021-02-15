package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;

public class PresentationListGames extends Presentation {

    private final PresentationTextOutput presentationTextOutput;

    public PresentationListGames() {

        presentationTextOutput = new PresentationTextOutput("ceci est la liste des parties futur");

    }

    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public void setText(String text) {
        presentationTextOutput.setText(text);
    }
}