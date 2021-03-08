package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessageDecoder;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessageEncoder;

/**
 * Décrit ce que doit faire le client websocket
 */
@ClientEndpoint(encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class)
public class WebsocketClientEndpoint {

    private MyWebsocketClient client;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("ChatClientEndpoint.onOpen()");

    }

    @OnMessage
    public void onMessage(WebsocketMessage message) {
        System.out.println("Le clien recoit  : ");

        System.out.println("Received by client : " + message);

        WebsocketClientHelper.notifyListenersOfMessage(message);

    }

    public MyWebsocketClient getClient() {
        return client;
    }

    public void setClient(MyWebsocketClient client) {
        this.client = client;
    }

}
