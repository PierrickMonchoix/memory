package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VueGameProposal extends HBox implements IVue {

    private final VueTextOutput vueTextOutput;
    private final VueButton vueButton;

    private static Logger logger = Logger.getLogger(VueGameProposal.class.getName());
    public VueGameProposal(PresentationGameProposal presentationGameProposal){
        super(100);

        vueTextOutput = new VueTextOutput(presentationGameProposal.getPresentationTextOutput());
        presentationGameProposal.getPresentationTextOutput().setVue(vueTextOutput);
        

        vueButton = new VueButton(presentationGameProposal.getPresentationButton());
        presentationGameProposal.getPresentationButton().setVue(vueButton);
        


        setAlignment(Pos.CENTER_RIGHT);

        setPadding(new Insets(0,10,0,10));
        
        setMaxWidth(500);
        setMaxHeight(50);

        getChildren().addAll(vueTextOutput);
        getChildren().addAll(vueButton);

        setStyle("-fx-border-color: black");

        update();

    }




    @Override
    public void update() {
        logger.info("vueTextOutput : " + vueTextOutput);
        logger.info("vueButton : " + vueButton);
        vueTextOutput.update();
        vueButton.update();
        
    }
    
}
