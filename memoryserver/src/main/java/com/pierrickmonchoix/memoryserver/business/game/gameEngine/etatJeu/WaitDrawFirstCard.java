package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.IWebsocketFinishNotifyListener;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

/**
 * Demande que le joueur tire sa première carte
 */
public class WaitDrawFirstCard extends EtatJeuWaiting implements IWebsocketFinishNotifyListener {

    private boolean waiting = false;

    private WebsocketMessage receivedMessage;

    private static Logger logger = Logger.getLogger(WaitDrawFirstCard.class.getName());

    public WaitDrawFirstCard(GameEngine automateGameEngine) {
        super(automateGameEngine);

        WebsocketServerHelper.addFinishNotifyListener(this);
    }

    @Override
    public void start() {
        logger.info("###### ETAT JEU = WaitDrawFirstCard");
        waiting = true;
    }

    @Override
    public void goNextEtat() {
        waiting = false;
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getAskDrawSecondCard());
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        String pseudoMessageSender = message.getPseudo();
        String pseudoActualPlayer = getAutomateGameEngine().getActualPlayer().getPseudo();
        if ((message.getType() == EMessageType.DRAW_CARD) && (pseudoActualPlayer.equals(pseudoMessageSender))) {
            logger.info("msg recu par ws");
            if (waiting) {
                String jsonCoordinatesFirstCard = message.getContenu();
                logger.info("on a recu la premiere carte de coordonees: " + jsonCoordinatesFirstCard);
                automateGameEngine.drawFirstCardOfJsonCoordinates(jsonCoordinatesFirstCard);
                receivedMessage = message;

            } else {
                logger.info("je n'attendais pas de msg ...");
            }
        }

    }

    @Override
    public void whenMessageIsNotMoreDestributed(WebsocketMessage websocketMessage) {
        if (receivedMessage == websocketMessage) { // same reference
            goNextEtat();
        }

    }

}
