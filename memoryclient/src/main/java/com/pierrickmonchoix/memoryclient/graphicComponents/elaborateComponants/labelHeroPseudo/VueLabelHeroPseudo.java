package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class VueLabelHeroPseudo extends VBox implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueLabelHeroPseudo(PresentationLabelHeroPseudo presentationLabelHeroPseudo) {

        vueTextOutput = (VueTextOutput) presentationLabelHeroPseudo.getPresentationTextOutput().getVue();

        getChildren().addAll(vueTextOutput);

        setPadding(new Insets(0,0,0,0));

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // nothing to MOVE
    }
}