package com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.elementJeu.Card;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class WaitDrawFirstCard extends EtatJeu implements IWebsocketListener {

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
        if (message.getType() == EMessageType.FIRST_CARD) {
            if (waiting) {
                logger.info("on a recu la premiere carte");
                Card drawnCard = automateGameEngine.getCardFromJsonCoordinates(message.getContenu());
                automateGameEngine.setFirstCard(drawnCard);
                goNextEtat();
            } else {
                logger.warning("je n'attendais pas de msg ...");
            }
        }
    }



}
