package com.pierrickmonchoix.memoryclient.websocketClient;

import com.pierrickmonchoix.memoryclient.websocketMessage.WebsocketMessage;

public interface IWebsocketClientListener {

    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage);
    
}
