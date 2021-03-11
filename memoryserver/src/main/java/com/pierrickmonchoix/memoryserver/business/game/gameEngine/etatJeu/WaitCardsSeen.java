package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

/**
 * attend que les joueurs aient bien vu les cartes retournées
 */
public class WaitCardsSeen extends EtatJeuWaiting {

    private boolean waiting = false;

    private static Logger logger = Logger.getLogger(WaitCardsSeen.class.getName());

    public WaitCardsSeen(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        logger.info("###### ETAT JEU = WaitCardsSeen");
        waiting = true;
    }

    @Override
    public void goNextEtat() {
        waiting = false;
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getCheckPairOrNot());  
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        String pseudoMessageSender = message.getPseudo();
        String pseudoActualPlayer = getAutomateGameEngine().getActualPlayer().getPseudo();
        if ((message.getType() == EMessageType.SHOW_CARD) && (pseudoActualPlayer.equals(pseudoMessageSender))) {
            logger.info("msg recu par ws");
            if (waiting) {
                logger.info("les client ont vu les cartes");
                goNextEtat();
            } else {
                logger.warning("je n'attendais pas de msg ...");
            }
        }
    }



}
