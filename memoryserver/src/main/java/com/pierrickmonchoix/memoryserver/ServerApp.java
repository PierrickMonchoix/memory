package com.pierrickmonchoix.memoryserver;


import com.pierrickmonchoix.memoryserver.business.PlayersManager;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;

public class ServerApp {
    public static void main(String[] args) {
        
        WebsocketServerHelper.launchWebsocketServer();
    }
}
