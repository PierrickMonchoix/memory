package com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.elementJeu.Card;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.Coordinates;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class WaitDrawSecondCard extends EtatJeu implements IWebsocketListener {

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
        changeAndStartEtatTo(automateGameEngine.getCheckPairOrNot());
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        if (websocketMessage.getType() == EMessageType.SECOND_CARD) {
            if (waiting) {
                logger.info("on a recu la premiere carte");
                Card drawnCard = getCardFromJsonCoordinates(websocketMessage.getContenu());
                automateGameEngine.setSecondCard(drawnCard);
            } else {
                logger.warning("je n'attendais pas de msg ...");
            }
        }
    }

    private Card getCardFromJsonCoordinates(String jsonCoordinates) {
        Coordinates coordinates = Coordinates.fromJson(jsonCoordinates);
        Card drawnCard = automateGameEngine.getBoard().getCardFromCoordinates(coordinates);
        return drawnCard;
    }

}
