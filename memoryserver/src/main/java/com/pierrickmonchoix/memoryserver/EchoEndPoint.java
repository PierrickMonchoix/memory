package com.pierrickmonchoix.memoryserver;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.pierrickmonchoix.memoryserver.websocketMessage.*;

import org.apache.log4j.Logger;

@ServerEndpoint(value = "/echo/{pseudo}", encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class) 
public class EchoEndPoint {

  private static Logger logger = Logger.getLogger(EchoEndPoint.class);

  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

  @OnOpen
  public void onOpen(@PathParam("pseudo") String pseudo, Session session) {
    System.out.println(session.getId() + " vient de se connecter au canal avec le pseudo: " + pseudo);
    // verif qu'il existe bien avec la DAO (pas mtnt car pas de msg)
    session.getUserProperties().put("pseudo", pseudo);
    clients.add(session);
    logger.info("nouveau client ajouté dans la liste des clients: ");
    logger.info(clients);
    try {
      session.getBasicRemote().sendText("Vous avez bien été add au serveur avec le pseudo: " + pseudo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @OnMessage
  public void onMessage(WebsocketMessage message, Session session) {
    System.out.println("message recu:");
    System.out.println(message);
    try {
      session.getBasicRemote().sendObject(message);
    } catch (Exception e) {
      logger.error("echo");
      logger.error(e);
    }
    /*
     * return ThreadSafeFormatter.getDateFormatter().format(new Date()) + " " +
     * message;
     */
  }

  @OnClose
	public void onClose(Session sess) {
		System.out.println(sess.getUserProperties().get("pseudo") + " vient de se déconnecter ...");
		clients.remove(sess);
  }
}

