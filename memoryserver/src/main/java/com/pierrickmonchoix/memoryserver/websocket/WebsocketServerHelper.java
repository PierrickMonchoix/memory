package com.pierrickmonchoix.memoryserver.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryserver.websocket.websocketServer.WebsocketServerLauncher;



public class WebsocketServerHelper {

    private static List<Session> listSessions;

    private final static String PSEUDO = "pseudo";

    private static Logger logger = Logger.getLogger(WebsocketServerHelper.class.getName());

    public static void launchWebsocketServer(){
        listSessions = new ArrayList<Session>();
        WebsocketServerLauncher.launch();
    }

    public static void sendMessageToClient(String pseudo, WebsocketMessage websocketMessage) {
        logger.info("tentative d'envoie de msg au client : " + pseudo );
        for (Session session : listSessions) {
            logger.info("on peut envoyer un msg a : " + session.getUserProperties().get(PSEUDO));
            if (session.getUserProperties().get(PSEUDO).equals(pseudo)) {
                try {
                    session.getBasicRemote().sendObject(websocketMessage);
                } catch (IOException | EncodeException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }     
    }

    public static void sendMessageToSeveralClients(List<String> listPseudos, WebsocketMessage websocketMessage) {
        for (String pseudo : listPseudos) {
            sendMessageToClient(pseudo, websocketMessage);  
        }   
    }

    public static void updateListSessions(String pseudo , Session s){
        boolean alreadyHere = false;
        for (Session session : listSessions) {
            if( session.getUserProperties().get(PSEUDO).equals(pseudo)){
                alreadyHere = true;
            }
        }
        if( !alreadyHere ){
            logger.info("session NON deja presente");
            s.getUserProperties().put(PSEUDO,pseudo);
            listSessions.add(s);
        }
        else {
            logger.info("session deja presente");
        }
    }

    public static Session getSession(String pseudo){
        for (Session session : listSessions) {
            if(session.getUserProperties().get(PSEUDO).equals(pseudo) ){
                logger.info("pseudo trouvé");
                return session;
            }
        }
        logger.warning("pseudo non trouvé");
        return null;
    }
    
}
