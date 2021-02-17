package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;

public class CheckPairOrNot extends EtatJeu {

    public CheckPairOrNot(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        checkPairOrNot();
        //on ve va pas forcement au next etat!
    }

    @Override
    public void goNextEtat() {
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getAskDrawFirstCard());
    }

    private void checkPairOrNot(){
        if(automateGameEngine.isWinner()){
            automateGameEngine.updateScoresAndBoard();// a faire apres verif du winner
            automateGameEngine.sendMessageToAllPlayer(EMessageType.WINNER);
            automateGameEngine.endGame();
        }
        else {
            if(automateGameEngine.isPairDrawn()){
                automateGameEngine.updateScoresAndBoard();
                automateGameEngine.sendMessageToAllPlayer(EMessageType.DRAW_SUCCESS);
            }
            else{ // pas de paire tirée
                automateGameEngine.updateScoresAndBoard();
                automateGameEngine.sendMessageToAllPlayer(EMessageType.DRAW_FAILURE);
            }
            goNextEtat(); // ask pair
        }
    }
    
}
