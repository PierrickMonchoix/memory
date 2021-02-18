package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class WaitCardsSeen extends EtatJeuWaiting {

    private boolean waiting = false;

    private static Logger logger = Logger.getLogger(WaitCardsSeen.class.getName());

    public WaitCardsSeen(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        waiting = true;
    }

    @Override
    public void goNextEtat() {
        waiting = false;
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getCheckPairOrNot());  
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if (message.getType() == EMessageType.SHOW_CARD) {
            if (waiting) {
                logger.info("les client ont vu les cartes");
                goNextEtat();
            } else {
                logger.warning("je n'attendais pas de msg ...");
            }
        }
    }



}
