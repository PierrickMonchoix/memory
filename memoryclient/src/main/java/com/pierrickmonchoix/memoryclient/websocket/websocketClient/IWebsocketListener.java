package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

/**
 * les classes qui écoutent les messages provenant du serveur
 */
public interface IWebsocketListener {

    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage);
    
}
