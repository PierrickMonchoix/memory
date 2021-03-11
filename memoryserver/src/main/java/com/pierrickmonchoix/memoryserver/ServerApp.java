package com.pierrickmonchoix.memoryserver;

import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;

/**
 * Main class du serveur
 */
public class ServerApp {
    public static void main(String[] args) {
        
        WebsocketServerHelper.launchWebsocketServer();
        
    }
}
