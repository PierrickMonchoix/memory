package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class WaitDrawSecondCard extends EtatJeuWaiting {

    private static Logger logger = Logger.getLogger(WaitDrawSecondCard.class.getName());

    private boolean waiting = false;

    public WaitDrawSecondCard(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        waiting = true;
        // se contente d'attendre

    }

    @Override
    public void goNextEtat() {
        waiting = false;
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getWaitCardsSeen());
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if (message.getType() == EMessageType.DRAW_CARD) {
            logger.info("msg recu par ws");
            if (waiting) {
                logger.info("on a recu la premiere carte");
                String jsonCoordinatesSecondCard = message.getContenu();
                automateGameEngine.drawSecondCardOfJsonCoordinates(jsonCoordinatesSecondCard);
                goNextEtat();
            } else {
                logger.warning("je n'attendais pas de msg ...");
            }
        }
    }



}
