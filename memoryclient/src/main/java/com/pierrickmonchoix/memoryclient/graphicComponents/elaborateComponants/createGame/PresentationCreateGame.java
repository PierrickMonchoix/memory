package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.createGame;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField.VueTextField;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.PresentationButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.VueButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers.PresentationHowManyPlayers;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers.VueHowManyPlayers;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;

public class PresentationCreateGame extends PresentationNotifier implements IChildenListener {

    private static Logger logger = Logger.getLogger(PresentationCreateGame.class.getName());



    private final PresentationHowManyPlayers presentationHowManyPlayers;

    private final PresentationButtonCreateGame presentationButtonCreateGame;

    private final PresentationTextOutput presentationTextOutput;

    public PresentationCreateGame() {
        super(EChildEvent.ASK_FOR_CREATE_GAME);
        
        presentationHowManyPlayers = new PresentationHowManyPlayers();
        VueHowManyPlayers vueHowManyPlayers = new VueHowManyPlayers(presentationHowManyPlayers);
        presentationHowManyPlayers.setVue(vueHowManyPlayers);

        presentationTextOutput = new PresentationTextOutput("nombre de joueurs:");
        VueTextOutput vueTextOutput = new VueTextOutput(presentationTextOutput);
        presentationTextOutput.setVue(vueTextOutput);

        presentationButtonCreateGame = new PresentationButtonCreateGame();
        VueButtonCreateGame vueButtonCreateGame = new VueButtonCreateGame(presentationButtonCreateGame);
        presentationButtonCreateGame.setVue(vueButtonCreateGame);

        listenAllChildren();
    }

    @Override
    public void listenAllChildren() {
        presentationButtonCreateGame.attributeParentListener(this);
        
    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if (typeEvent == EChildEvent.ASK_FOR_CREATE_GAME) {
            notifyParent();
        }
        else{
            logger.info("mon/mes enfants ne m'on pas bien notifiés");
        }
        
    }


    public PresentationHowManyPlayers getPresentationHowManyPlayers() {
        return this.presentationHowManyPlayers;
    }


    public PresentationButtonCreateGame getPresentationButtonCreateGame() {
        return this.presentationButtonCreateGame;
    }


    public PresentationTextOutput getPresentationTextOutput() {
        return this.presentationTextOutput;
    }



    public void setEnable(boolean enable){
        presentationButtonCreateGame.setEnable(enable);
    }

    public String getNumberPlayer(){
        return presentationHowManyPlayers.getChoice();
    }


    
}
