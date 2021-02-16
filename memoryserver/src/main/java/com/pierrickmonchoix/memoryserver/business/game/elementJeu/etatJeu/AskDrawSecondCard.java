package com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.elementJeu.GameEngine;

public class AskDrawSecondCard extends EtatJeu {
    private static Logger logger = Logger.getLogger(AskDrawSecondCard.class.getName());

    public AskDrawSecondCard(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        askClientDrawSecondCard();

        goNextEtat();
    }

    @Override
    public void goNextEtat() {
        changeAndStartEtatTo(automateGameEngine.getWaitDrawSecondCard());
    }

    private void askClientDrawSecondCard() {
        logger.info("askClientDrawFirtCard");
        // TODO:
    }
}