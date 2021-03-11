package com.pierrickmonchoix.memoryserver.websocket;

import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

/**
 * certaines classent doive,t savoir que tous les listeners de WebsocketHelper ont finit d'être appelés
 */
public interface IWebsocketFinishNotifyListener {
    public void whenMessageIsNotMoreDestributed(WebsocketMessage websocketMessage);
    
}
