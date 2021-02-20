package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class VueWinner extends VBox implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueWinner(PresentationWinner presentationWinner) {

        vueTextOutput = (VueTextOutput) presentationWinner.getPresentationTextOutput().getVue();

        getChildren().addAll(vueTextOutput);

        setPadding(new Insets(0,200,0,0));

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // nothing to MOVE
    }
}