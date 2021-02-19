package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;

public class PresentationGameProposal extends PresentationNotifier implements IChildenListener {

    private static Logger logger = Logger.getLogger(PresentationGameProposal.class.getName());

    private final PresentationTextOutput presentationTextOutput;
    private final PresentationButton presentationButton;

    /**
     * unusable for updates
     */
    private String pseudoPlayer; 

    public PresentationGameProposal(String pseudo, String numberPlayer) {
        super(EChildEvent.ASK_FOR_JOIN_GAME);

        this.pseudoPlayer = pseudo;
        logger.info("creation");

        presentationTextOutput = new PresentationTextOutput("Partie de " + pseudo + " " + numberPlayer);
        VueTextOutput vueTextOutput = new VueTextOutput(presentationTextOutput);
        presentationTextOutput.setVue(vueTextOutput);

        presentationButton = new PresentationButton("Join");
        VueButton vueButton = new VueButton(presentationButton);
        presentationButton.setVue(vueButton);

        listenAllChildren();
    }

    // OVERIDE METHODS

    @Override
    public void listenAllChildren() {
        presentationButton.attributeParentListener(this);
    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if(typeEvent == EChildEvent.BUTTON_PRESSED){
            notifyParent();
        }
        else{
            logger.warning("mon/mes enfants ne m'as pas bien notifié");
        }

    }

    // GETTERS des presentations for vue



    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }

    // GETTER values from childrens

    public String getPseudoPlayer(){
        return pseudoPlayer;
    }

    public void setAnableButton(Boolean enable) {
        presentationButton.setUpEnable(enable);
    }



}
