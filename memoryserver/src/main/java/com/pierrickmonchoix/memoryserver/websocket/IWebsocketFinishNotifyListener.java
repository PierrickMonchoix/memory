package com.pierrickmonchoix.memoryserver.websocket;

import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public interface IWebsocketFinishNotifyListener {

    public void whenMessageIsNotMoreDestributed(WebsocketMessage websocketMessage);
    
}
