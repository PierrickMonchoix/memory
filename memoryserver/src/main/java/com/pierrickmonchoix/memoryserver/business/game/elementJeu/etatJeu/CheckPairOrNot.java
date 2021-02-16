package com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu;

import com.pierrickmonchoix.memoryserver.business.game.elementJeu.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;

public class CheckPairOrNot extends EtatJeu {

    public CheckPairOrNot(GameEngine automateGameEngine) {
        super(automateGameEngine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void start() {
        if(automateGameEngine.isPairDrawn()){
            automateGameEngine.paireFound();
            automateGameEngine.sendMessageToAllPlayerPairFound();
        }
    }

    @Override
    public void goNextEtat() {
        
    }
    
}
