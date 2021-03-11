package com.pierrickmonchoix.memoryserver.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.business.PlayersManager;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryserver.websocket.websocketServer.WebsocketServerLauncher;

/**
 * set d'intermediaire entre le serveur websocket etla partie business.
 * permet d'envoyer des msg a des client, en recevoir et de lancer le serveur.
 */
public class WebsocketServerHelper {

    private static List<Session> listSessions;

    private final static String PSEUDO = "pseudo";

    private static List<IWebsocketListener> listListeners;

    private static List<IWebsocketFinishNotifyListener> listFinishNotifyListener;

    private static Logger logger = Logger.getLogger(WebsocketServerHelper.class.getName());

    public static void launchWebsocketServer() {
        listSessions = new ArrayList<Session>();
        listListeners = new ArrayList<IWebsocketListener>();
        listFinishNotifyListener = new ArrayList<IWebsocketFinishNotifyListener>();
        WebsocketServerLauncher.launch();
    }

    public static void givePseudoToSession(Session session, String pseudo) {
        session.getUserProperties().put(PSEUDO, pseudo);
    }

    public static String getPseudoOfSession(Session session) {
        return (String)session.getUserProperties().get(PSEUDO);
    }

    public static void receiveMessage(WebsocketMessage message, Session session) {
        if( (message.getType() == EMessageType.SIGN_IN) || (message.getType() == EMessageType.SIGN_UP) ){
            /*
            cas particulier: on va attribuer un pseudo a la session.
            grace a ca, en fonction du pseudo, on sait a quelle session on enverra des msg.
            */
            LoginWebsocketMessageTreater.treatMessage(message, session);
        }
        else{
            notifyListenersOfMessage(message);
        }
        
    }

    public static void sendMessageToClient(String pseudo, WebsocketMessage websocketMessage) {
        logger.info("tentative d'envoie de msg au pseudo : " + pseudo);
        for (Session session : listSessions) {
            //logger.info("on tente d'envoyer un msg a : " + session.getUserProperties().get(PSEUDO));
            if (session.getUserProperties().get(PSEUDO).equals(pseudo)) {
                logger.info("on envoie un msg au CLIENT : " + pseudo + " message : " +  websocketMessage);
                sendMessageToClient(session, websocketMessage);
            }
        }
    }

    public static void sendMessageToClient(Session session, WebsocketMessage websocketMessage) {
        try {
            session.getBasicRemote().sendObject(websocketMessage);
        } catch (IOException | EncodeException e) {
            // TODO Auto-generated catch block
            logger.warning("envoie du msg impossible");
            e.printStackTrace();
        }
    }

    public static void sendMessageToSeveralClients(List<String> listPseudos, WebsocketMessage websocketMessage) {
        for (String pseudo : listPseudos) {
            sendMessageToClient(pseudo, websocketMessage);
        }
    }


    public static void sendMessageToEveryPlayer(WebsocketMessage websocketMessage){
        sendMessageToSeveralClients(PlayersManager.getInstance().getAllPseudos() ,websocketMessage);
    }

    public static void updateListSessions(Session s) {
        boolean alreadyHere = false;
        for (Session session : listSessions) {
            if (session.getId().equals(s.getId())) {
                alreadyHere = true;
            }
        }
        if (!alreadyHere) {
            logger.info("ajout d'une nouvealle session");
            listSessions.add(s);
            givePseudoToSession(s, "unknown");
        } else {
            logger.info("session deja existante");
        }
    }

    public static void removeSession(Session s) {
        PlayersManager.getInstance().removePlayer(getPseudoOfSession(s));
        listSessions.removeIf((session -> (session.getId().equals(s.getId()))));
    }

    public static Session getSession(String pseudo) {
        for (Session session : listSessions) {
            if (session.getUserProperties().get(PSEUDO).equals(pseudo)) {
                logger.info("pseudo trouvé");
                return session;
            }
        }
        logger.warning("pseudo non trouvé");
        return null;
    }

    public static void notifyListenersOfMessage(WebsocketMessage message) {
        logger.info("notification des ws listeners du msg : " + message);
        List<IWebsocketListener> copyListListeners = new ArrayList<IWebsocketListener>(listListeners);
        /*
        on doit paasser par une copie car il arrive
        que l'on modifie la liste alors que l'on itére celle ci
        */
        for (IWebsocketListener listener : copyListListeners) {
            logger.info("on a notifié un ws listeners");
            listener.whenReceiveWebsocketMessage(message);
        }

        logger.info("notification des ws listeners du msg : " + message);
        List<IWebsocketFinishNotifyListener> copyListFinishListeners = new ArrayList<IWebsocketFinishNotifyListener>(listFinishNotifyListener);
        /*
        on doit passer par une copie car il arrive
        que l'on modifie la liste alors que l'on itére celle ci
        */
        for (IWebsocketFinishNotifyListener finishListener : copyListFinishListeners) {
            logger.info("on a notifié un ws listeners");
            finishListener.whenMessageIsNotMoreDestributed(message);
        }


    }

    public static void addListener(IWebsocketListener listener) {
        listListeners.add(listener);
    }

    public static void addFinishNotifyListener(IWebsocketFinishNotifyListener finishNotifyListener) {
        listFinishNotifyListener.add(finishNotifyListener);
    }

}
