package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public interface IWebsocketListener {

    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage);
    
}
