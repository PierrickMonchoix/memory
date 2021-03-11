package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

/**
 * Attend que le joueur tire sa première carte
 */
public class WaitDrawSecondCard extends EtatJeuWaiting {

    private static Logger logger = Logger.getLogger(WaitDrawSecondCard.class.getName());

    private boolean waiting = false;

    public WaitDrawSecondCard(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        logger.info("###### ETAT JEU = WaitDrawSecondCard");
        waiting = true;
        // se contente d'attendre

    }

    @Override
    public void goNextEtat() {
        waiting = false;
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getAskCardsSeen());
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        String pseudoMessageSender = message.getPseudo();
        String pseudoActualPlayer = getAutomateGameEngine().getActualPlayer().getPseudo();
        if ((message.getType() == EMessageType.DRAW_CARD) && (pseudoActualPlayer.equals(pseudoMessageSender))) {
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
