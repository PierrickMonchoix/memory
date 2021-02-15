package com.pierrickmonchoix.memoryserver.websocket;

import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

/**
 * les classes qui écoutent les messages provenant du serveur
 */
public interface IWebsocketListener {

    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage);
    
}
