package com.pierrickmonchoix.memoryclient.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.websocket.websocketClient.WebsocketClient;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

/**
 * La classe "statique" qui fait le lien entre le business et le serveur. On
 * peut grace a cette classe envoyer des messages au serveur et en rececoir.
 */
public class WebsocketClientHelper {

    private static Logger logger = Logger.getLogger(WebsocketClientHelper.class.getName());

    /**
     * le pseudo du joueur est mémorisé ici
     */
    private static String pseudo;

    private static WebsocketClient websocketClient;

    private static List<IWebsocketListener> listListeners;

    private WebsocketClientHelper() {
        // static class
    }

    /**
     * inititialise la classe
     */
    public static void initialize() {
        websocketClient = WebsocketClient.getInstance();
        websocketClient.connectToEndpoint();
        pseudo = "unknown";
        listListeners = new ArrayList<IWebsocketListener>();
    }

    public static void setPseudo(String pseudo) {
        WebsocketClientHelper.pseudo = pseudo;
    }

    public static void sendMessageToServer(EMessageType type, String contenu) {
        WebsocketMessage websocketMessage = new WebsocketMessage(pseudo, type, contenu);
        websocketClient.sendMessage(websocketMessage);
    }

    public static void notifyListenersOfMessage(WebsocketMessage message) {
        logger.info("notifcation des ws listeners du msg : " + message);
        for (IWebsocketListener listener : listListeners) {
            logger.info("on a notifié un ws listeners");
            listener.whenReceiveWebsocketMessage(message);
        }
    }

    public static void addListener(IWebsocketListener listener) {
        listListeners.add(listener);
    }

 

}
