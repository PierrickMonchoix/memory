package com.pierrickmonchoix.memoryclient.websocket;

import java.util.List;

import com.pierrickmonchoix.memoryclient.websocket.websocketClient.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.websocketClient.WebsocketClient;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class WebsocketHelper {

    private static String pseudo;

    private static WebsocketClient websocketClient;

    private static List<IWebsocketListener> listListeners;

    private WebsocketHelper() {
        // static class
    }

    public static void initialize() {
        websocketClient = WebsocketClient.getInstance();
        pseudo = "unknown";
    }

    public static void sendMessageToServer(EMessageType type , String contenu) {
        WebsocketMessage websocketMessage = new WebsocketMessage(pseudo,type,contenu);
        websocketClient.sendMessage(websocketMessage);
    }

    public static void notifyListenersOfMessage(WebsocketMessage websocketMessage) {
        for (IWebsocketListener listener : listListeners) {
            listener.whenReceiveWebsocketMessage(websocketMessage);
        }
    }


    public static void setPseudo(String pseudo) {
        WebsocketHelper.pseudo = pseudo;
    }

    public static void addListener(IWebsocketListener listener){
        listListeners.add(listener);
    }

    public static void notifyListenersOfWebsocketMessage(WebsocketMessage websocketMessage){
        for (IWebsocketListener listener : listListeners) {
            listener.whenReceiveWebsocketMessage(websocketMessage);
        }
    }



}
