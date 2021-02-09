package com.pierrickmonchoix.memoryclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ClientEndpoint;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.Session;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@ClientEndpoint
public class TestClientWebSocketTyrus{

  private static Logger logger = Logger.getLogger(TestClientWebSocketTyrus.class);


  @OnMessage
  public void onMessage(String message, Session session) {
    
  }

  public static void main(String[] args) {
    BasicConfigurator.configure();

    logger.info("start main");
    
    javax.websocket.WebSocketContainer container = javax.websocket.ContainerProvider.getWebSocketContainer();
    try {
      Session session = container.connectToServer(TestClientWebSocketTyrus.class,
          URI.create("ws://localhost:8098/websockets/echo"));
      while (true) {
        logger.info("envoie msg hello 1 ");
        System.out.println("envoie 1");
        try {
          Thread.sleep(4000);
        } catch (InterruptedException ex) {
            logger.error(ex);
        }
        logger.info("envoie msg hello");
        session.getBasicRemote().sendText("hello");
      }
    } catch (DeploymentException | IOException ex) {
      
    }
  }


}
