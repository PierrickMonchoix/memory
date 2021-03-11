package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;

/**
 * Vérifie si une paire à été tirée
 */
public class CheckPairOrNot extends EtatJeu {
    private static Logger logger = Logger.getLogger(CheckPairOrNot.class.getName());

    public CheckPairOrNot(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        logger.info("###### ETAT JEU = CheckPairOrNot");
        checkPairOrNot();
        //on ve va pas forcement au next etat!
    }

    @Override
    public void goNextEtat() {
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getAskDrawFirstCard());
    }

    private void checkPairOrNot(){
        automateGameEngine.updateScoresAndBoard();

        if(automateGameEngine.isWinner()){
            logger.info("il y a un vainceur");
            String pseudoWinner = getAutomateGameEngine().getWinner().getPseudo();
            automateGameEngine.sendSpecificMessageToAllPlayer(EMessageType.WINNER , pseudoWinner);
            automateGameEngine.endGame();
            
        }
        else {
            if(automateGameEngine.isPairDrawn()){
                logger.info("il y a eu une paire returned");
                automateGameEngine.sendMessageToAllPlayer(EMessageType.DRAW_SUCCESS);
            }
            else{ // pas de paire tirée
                logger.info("il y n'y a PAS eu une paire returned");
                automateGameEngine.sendMessageToAllPlayer(EMessageType.DRAW_FAILURE);
            }
            goNextEtat(); // ask pair
        }
    }
    
}
