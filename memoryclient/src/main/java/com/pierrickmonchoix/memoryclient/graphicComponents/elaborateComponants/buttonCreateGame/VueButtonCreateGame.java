package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;

import javafx.scene.layout.VBox;

public class VueButtonCreateGame extends VBox implements IVue {

    private static Logger logger = Logger.getLogger(VueButtonCreateGame.class.getName());

    private final VueButton vueButton;


    public VueButtonCreateGame(PresentationButtonCreateGame presentationButtonCreateGame) {
        vueButton = new VueButton(presentationButtonCreateGame.getPresentationButton());
        presentationButtonCreateGame.getPresentationButton().setVue(vueButton);

        getChildren().addAll(vueButton);

        update();
    }

    @Override
    public void update() {
        logger.info("vueButton CreateGame : " + vueButton);
        vueButton.update();
    }


}