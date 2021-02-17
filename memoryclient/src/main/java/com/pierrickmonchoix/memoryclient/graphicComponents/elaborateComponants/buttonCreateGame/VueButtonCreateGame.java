package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;

import javafx.scene.layout.VBox;

public class VueButtonCreateGame extends VBox implements IVue {

    private final VueButton vueButton;


    public VueButtonCreateGame(PresentationButtonCreateGame presentationButtonCreateGame) {
        vueButton = new VueButton(presentationButtonCreateGame.getPresentationButton());
        presentationButtonCreateGame.getPresentationButton().setVue(vueButton);

        getChildren().addAll(vueButton);

        update();
    }

    @Override
    public void update() {
        vueButton.update();
    }


}