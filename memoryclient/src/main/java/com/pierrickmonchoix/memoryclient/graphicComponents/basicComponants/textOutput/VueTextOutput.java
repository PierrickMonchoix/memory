package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;

import javafx.scene.control.Label;

public class VueTextOutput extends Label implements IVue {

    private final PresentationTextOutput presentationTextOutput;

    public VueTextOutput(PresentationTextOutput presentationTextOutput) {
        super();
        this.presentationTextOutput = presentationTextOutput;

        update();
    }

    @Override
    public void update() {
        setText(presentationTextOutput.getText());
    }


}
