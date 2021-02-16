package com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu;

import com.pierrickmonchoix.memoryserver.business.game.elementJeu.GameEngine;

public class CheckPairOrNot extends EtatJeu {

    public CheckPairOrNot(GameEngine automateGameEngine) {
        super(automateGameEngine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void start() {
        if(automateGameEngine.isPeerDrawn()){
            //TODO:
        }
    }

    @Override
    public void goNextEtat() {
        

    }
    
}
