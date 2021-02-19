package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.layout.VBox;

public class VueLoginResult extends VBox implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueLoginResult(PresentationLoginResult presentationLoginTextResult) {

        vueTextOutput = (VueTextOutput)presentationLoginTextResult.getPresentationTextOutput().getVue();

        getChildren().addAll(vueTextOutput);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // nothing to MOVE
    }

    
    
}
