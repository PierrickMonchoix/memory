package com.pierrickmonchoix.memoryserver.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.business.ConnectedPlayersManager;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessageTreater;
import com.pierrickmonchoix.memoryserver.websocket.websocketServer.WebsocketServerLauncher;

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
        WebsocketMessageTreater.treatMessage(message, session);
    }

    public static void sendMessageToClient(String pseudo, WebsocketMessage websocketMessage) {
        logger.info("tentative d'envoie de msg au client : " + pseudo);
        for (Session session : listSessions) {
            logger.info("on peut envoyer un msg a : " + session.getUserProperties().get(PSEUDO));
            if (session.getUserProperties().get(PSEUDO).equals(pseudo)) {
                sendMessageToClient(session,websocketMessage);
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
        boolean deleted = false;
        for (Session session : listSessions) {
            if (session.getId().equals(s.getId())) {
                deleted = true;
                try {

                    listSessions.remove(session);
                } catch (Exception e) {
                    logger.warning("echec de la suppression de la la session");
                    throw e;
                }
            }
        }
        if (deleted) {
            logger.info("on a bien deleted la sessions");
            listSessions.add(s);
        } else {
            logger.warning("echec de la suppression de la la session");
        }
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
