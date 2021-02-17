package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;

public abstract class EtatJeu implements IEtatJeu {
    protected final GameEngine automateGameEngine;

    public EtatJeu(GameEngine automateGameEngine) {
        this.automateGameEngine = automateGameEngine;
    }

    public GameEngine getAutomateGameEngine() {
        return automateGameEngine;
    }



    

    


}
