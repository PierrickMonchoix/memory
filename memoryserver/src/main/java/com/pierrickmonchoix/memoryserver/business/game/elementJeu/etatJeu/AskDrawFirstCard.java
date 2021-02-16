package com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu;


import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.elementJeu.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;

public class AskDrawFirstCard extends EtatJeu {
    private static Logger logger = Logger.getLogger(AskDrawFirstCard.class.getName());

    public AskDrawFirstCard(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        askClientDrawFirstCard();
        goNextEtat();
    }

    @Override
    public void goNextEtat() {
        automateGameEngine.changeAndStartEtatJeuTo( automateGameEngine.getWaitDrawFirstCard() );
    }

    private void askClientDrawFirstCard(){
        logger.info("askClientDrawFirtCard");
        automateGameEngine.sendMessageToPlayer(EMessageType.FIRST_CARD, "order_draw_firstcard");
    }


    
    
}
