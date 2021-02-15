package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;

import javafx.scene.layout.VBox;

public class VueLoginResult extends VBox implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueLoginResult(PresentationLoginResult presentationLoginTextResult) {

        vueTextOutput = new VueTextOutput(presentationLoginTextResult.getPresentationTextOutput());
        presentationLoginTextResult.getPresentationTextOutput().setVue(vueTextOutput);

        getChildren().addAll(vueTextOutput);

        update();
    }

    @Override
    public void update() {
        vueTextOutput.update();
    }

    
    
}
