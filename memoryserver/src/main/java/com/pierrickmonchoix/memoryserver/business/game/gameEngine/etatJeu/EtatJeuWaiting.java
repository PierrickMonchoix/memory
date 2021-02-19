package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;



import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;

public abstract class EtatJeuWaiting extends EtatJeu implements IWebsocketListener {

    public EtatJeuWaiting(GameEngine automateGameEngine) {
        super(automateGameEngine);
        WebsocketServerHelper.addListener(this);
  

  

        

    }

}
