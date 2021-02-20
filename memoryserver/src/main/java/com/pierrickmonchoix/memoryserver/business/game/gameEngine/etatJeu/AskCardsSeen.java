package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;

public class AskCardsSeen extends EtatJeu {
    private static Logger logger = Logger.getLogger(AskDrawSecondCard.class.getName());

    public AskCardsSeen(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        logger.info("###### ETAT JEU = AskCardsSeen");
        askClientToSeeCards();
        goNextEtat();
    }

    @Override
    public void goNextEtat() {
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getWaitCardsSeen());
    }

    private void askClientToSeeCards(){
        logger.info("askClientToSeeCards");
        automateGameEngine.sendMessageToAllPlayer(EMessageType.SHOW_CARD);
    }
    
}
