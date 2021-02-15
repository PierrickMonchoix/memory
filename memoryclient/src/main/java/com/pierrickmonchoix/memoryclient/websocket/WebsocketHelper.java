package com.pierrickmonchoix.memoryclient.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.websocket.websocketClient.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.websocketClient.WebsocketClient;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

/**
 * La classe "statique" qui fait le lien entre le business et le serveur. On
 * peut grace a cette classe envoyer des messages au serveur et en rececoir.
 */
public class WebsocketHelper {

    private static Logger logger = Logger.getLogger(WebsocketHelper.class.getName());

    /**
     * le pseudo du joueur est mémorisé ici
     */
    private static String pseudo;

    private static WebsocketClient websocketClient;

    private static List<IWebsocketListener> listListeners;

    private WebsocketHelper() {
        // static class
    }

    /**
     * inititialise la classe
     */
    public static void initialize() {
        websocketClient = WebsocketClient.getInstance();
        pseudo = "unknown";
        listListeners = new ArrayList<IWebsocketListener>();
    }

    public static void setPseudo(String pseudo) {
        WebsocketHelper.pseudo = pseudo;
    }

    public static void sendMessageToServer(EMessageType type, String contenu) {
        WebsocketMessage websocketMessage = new WebsocketMessage(pseudo, type, contenu);
        websocketClient.sendMessage(websocketMessage);
    }

    public static void notifyListenersOfMessage(WebsocketMessage websocketMessage) {
        logger.info("notification des ws listeners");
        for (IWebsocketListener listener : listListeners) {
            logger.info("on a notifié un ws listeners");
            listener.whenReceiveWebsocketMessage(websocketMessage);
        }
    }

    public static void addListener(IWebsocketListener listener) {
        listListeners.add(listener);
    }

    public static void notifyListenersOfWebsocketMessage(WebsocketMessage websocketMessage) {
        for (IWebsocketListener listener : listListeners) {
            listener.whenReceiveWebsocketMessage(websocketMessage);
        }
    }

}
