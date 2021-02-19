package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.layout.VBox;

public class VueButtonCreateGame extends VBox implements IVue {

    private static Logger logger = Logger.getLogger(VueButtonCreateGame.class.getName());

    private final VueButton vueButton;


    public VueButtonCreateGame(PresentationButtonCreateGame presentationButtonCreateGame) {
        vueButton = (VueButton) presentationButtonCreateGame.getPresentationButton().getVue();
        logger.info("creation");

        getChildren().addAll(vueButton);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // notinng to move or create/delete
    }


}