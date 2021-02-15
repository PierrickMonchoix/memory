package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class VueLabelHeroPseudo extends VBox implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueLabelHeroPseudo(PresentationLabelHeroPseudo presentationLabelHeroPseudo) {

        vueTextOutput = new VueTextOutput(presentationLabelHeroPseudo.getPresentationTextOutput());
        presentationLabelHeroPseudo.getPresentationTextOutput().setVue(vueTextOutput);

        getChildren().addAll(vueTextOutput);

        setPadding(new Insets(0,200,0,0));

        update();
    }

    @Override
    public void update() {
        vueTextOutput.update();
    }
}