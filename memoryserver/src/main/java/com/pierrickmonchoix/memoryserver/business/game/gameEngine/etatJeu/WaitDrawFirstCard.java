package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class WaitDrawFirstCard extends EtatJeuWaiting {

    private boolean waiting = false;

    private static Logger logger = Logger.getLogger(WaitDrawFirstCard.class.getName());

    public WaitDrawFirstCard(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        waiting = true;
    }

    @Override
    public void goNextEtat() {
        waiting = false;
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getAskDrawSecondCard());
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if (message.getType() == EMessageType.DRAW_FIRST_CARD) {
            if (waiting) {
                logger.info("on a recu la premiere carte");
                String jsonCoordinatesFirstCard = message.getContenu();
                automateGameEngine.drawFirstCardOfJsonCoordinates(jsonCoordinatesFirstCard);
                goNextEtat();
            } else {
                logger.warning("je n'attendais pas de msg ...");
            }
        }
    }



}
