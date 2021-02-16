package com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu;

import com.pierrickmonchoix.memoryserver.business.game.elementJeu.GameEngine;

public class CheckPairOrNot extends EtatJeu {

    public CheckPairOrNot(GameEngine automateGameEngine) {
        super(automateGameEngine);
    }

    @Override
    public void start() {
        if(automateGameEngine.isPairDrawn()){  // verification q'uone paire a bien etet tiree
            boolean isBoardEmpty = automateGameEngine.handlePairFoundAndSayIfEndGame(); // a faire avant de send msg!
            
            if(isBoardEmpty){ // partie terminee
                automateGameEngine.sendMessageToAllPlayerWhoWon();;
            }
            else {
                automateGameEngine.sendMessageToAllPlayerPairFound();

                //on ne change pa d ejourueru si une paire a ete trouvee
                goNextEtat();
            }
            
        }
        else{
            automateGameEngine.startTurnOfNextPlayer();
        }
    }

    @Override
    public void goNextEtat() {
        automateGameEngine.changeAndStartEtatJeuTo(automateGameEngine.getAskDrawFirstCard());
    }
    
}
