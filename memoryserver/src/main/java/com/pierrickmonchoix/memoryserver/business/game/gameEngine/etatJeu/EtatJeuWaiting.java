package com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;
import com.pierrickmonchoix.memoryserver.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;

public abstract class EtatJeuWaiting extends EtatJeu implements IWebsocketListener {

    public EtatJeuWaiting(GameEngine automateGameEngine) {
        super(automateGameEngine);
        WebsocketServerHelper.addListener(this);
        /*
         * if(shouldAdd(iter.next())) { WebsocketServerHelper.addListener(this); }
         */
        // TODO: add un truc alors qua pas finit itezr: on est encore en trai d'iterer
        // ()

  

        

    }

}
