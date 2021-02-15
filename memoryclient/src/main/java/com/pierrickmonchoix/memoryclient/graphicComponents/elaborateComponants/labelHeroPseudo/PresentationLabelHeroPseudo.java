package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;

public class PresentationLabelHeroPseudo extends Presentation {

    private final PresentationTextOutput presentationTextOutput;

    public PresentationLabelHeroPseudo() {

        presentationTextOutput = new PresentationTextOutput("default false pseudo");

    }

    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public void setText(String text) {
        presentationTextOutput.setText(text);
    }
}