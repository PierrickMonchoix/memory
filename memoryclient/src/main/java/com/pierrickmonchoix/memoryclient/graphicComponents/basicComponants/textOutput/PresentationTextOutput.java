package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;

/**
 * Text output (Application > Utilisateur)
 */
public class PresentationTextOutput extends Presentation {

    private String text;

    public PresentationTextOutput(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        updateVue();
    }

    
    
}
