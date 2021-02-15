package com.pierrickmonchoix.memoryserver.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryserver.websocket.websocketServer.WebsocketServerLauncher;

/**
 * set d'intermediaire entre le serveur websocket etla partie business.
 * permet d'envoyer des msg a des client, en recevoir et de lancer le serveur
 */
public class WebsocketServerHelper {

    private static List<Session> listSessions;

    private final static String PSEUDO = "pseudo";

    private static Logger logger = Logger.getLogger(WebsocketServerHelper.class.getName());

    public static void launchWebsocketServer() {
        listSessions = new ArrayList<Session>();
        WebsocketServerLauncher.launch();
    }

    public static void givePseudoToSession(Session session, String pseudo) {
        session.getUserProperties().put(PSEUDO, pseudo);
    }

    public static void receiveMessage(WebsocketMessage message, Session session) {
        if( (message.getType() == EMessageType.SIGN_IN) || (message.getType() == EMessageType.SIGN_UP) ){
            //cas particulier: il faut attribuer un pseudo a la session : no NEED en fait !!!!!!
            LoginWebsocketMessageTreater.treatMessage(message, session);
            //TODO: reflechir a dessus la
        }
        
    }

    public static void sendMessageToClient(String pseudo, WebsocketMessage websocketMessage) {
        logger.info("tentative d'envoie de msg au client : " + pseudo);
        for (Session session : listSessions) {
            logger.info("on peut envoyer un msg a : " + session.getUserProperties().get(PSEUDO));
            if (session.getUserProperties().get(PSEUDO).equals(pseudo)) {
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
        } else {
            logger.info("session deja existante");
        }
    }

    public static void removeSession(Session s) {
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

}
