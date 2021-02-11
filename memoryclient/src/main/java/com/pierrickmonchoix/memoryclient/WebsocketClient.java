package com.pierrickmonchoix.memoryclient;

import java.net.URI;


import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocketMessage.*;

import org.apache.log4j.Logger;

@ClientEndpoint( encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class) 
public class WebsocketClient {

    private static WebsocketClient instance;

    private Logger logger = Logger.getLogger(WebsocketClient.class);

    private javax.websocket.WebSocketContainer container;
    private Session session; // bien 1 sess par client

    private String nom;



    private WebsocketClient(String pseudo){
        initConnexion(pseudo);
    }

    public static WebsocketClient getInstance(String pseudo){
        if (instance == null){
            instance = new WebsocketClient(pseudo);
        }
        else{
            instance.initConnexion(pseudo);
        }
        return instance;
    }


    @OnMessage
    public void onMessage(WebsocketMessage msg) {
        System.out.println("msg recu par le client : " + msg.toString());
    }

    private void initConnexion(String pseudo) {
        System.out.println("init connexion");
        container = javax.websocket.ContainerProvider.getWebSocketContainer();
        nom = pseudo;
        try {
            session = container.connectToServer(WebsocketClient.class,
                    URI.create("ws://localhost:8098/websockets/echo/" + nom));
        } catch (Exception e) {
            System.out.println("init connexion impossible");
            logger.error(e);
        }
    }

    public void sendMessage() {
        WebsocketMessage msg = new WebsocketMessage();
        msg.setPseudo(nom);
        msg.setContenu("hello le server");
        msg.setType(42);
        System.out.println("tentative envoie msg au server: " + msg);
        try {
            session.getBasicRemote().sendObject(msg);
        } catch (Exception e) {
            System.out.println("envoie du msg impossible: " + e);
            logger.error("sendMessage");
            logger.error(e);
        }
    }


}
