package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VueGameProposal extends HBox implements IVue {

    private final VueTextOutput vueTextOutput;
    private final VueButton vueButton;

    private static Logger logger = Logger.getLogger(VueGameProposal.class.getName());

    public VueGameProposal(PresentationGameProposal presentationGameProposal) {
        super(100);
        logger.info("creation");

        vueTextOutput = (VueTextOutput) presentationGameProposal.getPresentationTextOutput().getVue();
        vueButton = (VueButton) presentationGameProposal.getPresentationButton().getVue();

        getChildren().addAll(vueTextOutput);
        getChildren().addAll(vueButton);

        setAlignment(Pos.CENTER_RIGHT);

        setPadding(new Insets(0, 10, 0, 10));

        setMaxWidth(500);
        setMaxHeight(50);



        setStyle("-fx-border-color: black");  // border

        updateFromPresentation();

    }

    @Override
    public void updateFromPresentation() {
        // nothing to move
    }

}
