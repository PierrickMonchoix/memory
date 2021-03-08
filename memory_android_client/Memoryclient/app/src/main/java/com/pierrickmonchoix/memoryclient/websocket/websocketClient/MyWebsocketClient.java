package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

import android.util.Log;

import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class MyWebsocketClient {

    private static MyWebsocketClient instance;

    private static WebSocketClient realClientInstance;



    public static MyWebsocketClient getInstance() {
        if (instance == null) {
            instance = new MyWebsocketClient();
        }
        return instance;
    }

    private MyWebsocketClient(){
        createWebSocketClient();
    }


    private void createWebSocketClient() {
        URI uri;
        try {
            // Connect to local host
            uri = new URI("ws://192.168.0.104:8026/memory/websocket");
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        realClientInstance = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                Log.i("WebSocket", "Session is starting");
            }
            @Override
            public void onTextReceived(String stringMessage) {

                WebsocketMessage message = WebsocketMessage.toObject(stringMessage);

                WebsocketClientHelper.notifyListenersOfMessage(message);

            }



            @Override
            public void onBinaryReceived(byte[] data) {
            }
            @Override
            public void onPingReceived(byte[] data) {
            }
            @Override
            public void onPongReceived(byte[] data) {
            }
            @Override
            public void onException(Exception e) {
                System.out.println(e.getMessage());
            }
            @Override
            public void onCloseReceived() {
                Log.i("WebSocket", "Closed ");
                System.out.println("onCloseReceived");
            }
        };
        //realClientInstance.setConnectTimeout(10000);
        //realClientInstance.setReadTimeout(60000);
        //realClientInstance.enableAutomaticReconnection(5000);
        realClientInstance.connect();
    }

    public void sendMessage(WebsocketMessage message) {
        realClientInstance.send(message.toJson());
    }



}
