package com.pierrickmonchoix.memoryclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ClientEndpoint;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.Session;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@ClientEndpoint
public class TestClientWebSocketTyrus {

  private static Logger logger = Logger.getLogger(TestClientWebSocketTyrus.class);

  private static javax.websocket.WebSocketContainer container;
  private static Session session;

  @OnMessage
  public void onMessage(String message, Session session) {
    System.out.println("msg recu par le client : " + message);
  }

  public static void initConnexion() {
    container = javax.websocket.ContainerProvider.getWebSocketContainer();
    try {
      session = container.connectToServer(TestClientWebSocketTyrus.class,
          URI.create("ws://localhost:8098/websockets/echo"));

      session.getUserProperties().put("pseudo", "leclient");
      session.getUserProperties().put("canal", "lecanalclient");
    } catch (Exception e) {
      logger.error(e);
    }
  }

  public static void sendMessage() {
    try {
      session.getBasicRemote().sendText("hello");
    } catch (Exception e) {
      logger.error("sendMessage");
      logger.error(e);
    }
  }

  public static void main(String[] args) {
    BasicConfigurator.configure();

    logger.info("start main");

    initConnexion();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      while (true) {
        System.out.println("ecrit svp");
        reader.readLine();
        logger.info("envoie msg hello");
        session.getBasicRemote().sendText("hello");
      }
    } catch (Exception e) {
      logger.error(e);
    }
  }

}
