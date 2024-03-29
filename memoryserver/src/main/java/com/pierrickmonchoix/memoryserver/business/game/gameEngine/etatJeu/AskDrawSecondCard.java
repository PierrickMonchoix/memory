package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;

/**
 * Demande que le joueur tire sa première carte
 */
public class AskDrawSecondCard extends EtatJeu {
    private static Logger logger = Logger.getLogger(AskDrawSecondCard.class.getName());

    public AskDrawSecondCard(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        logger.info("###### ETAT JEU = AskDrawSecondCard");
        askClientDrawSecondCard();
        goNextEtat();
    }

    @Override
    public void goNextEtat() {
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getWaitDrawSecondCard());
    }

    private void askClientDrawSecondCard(){
        logger.info("askClientDrawSecondCard");
        automateGameEngine.sendMessageToAllPlayer(EMessageType.DRAW_SECOND_CARD);
    }
}