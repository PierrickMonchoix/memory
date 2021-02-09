package com.pierrickmonchoix.memoryserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;

public class TestServerWebSocketTyrus {
  private static final Logger LOGGER = Logger.getLogger(TestServerWebSocketTyrus.class.getName());

  public static void main(String[] args) {
    Server server = new Server("localhost", 8098, "/websockets", EchoEndPoint.class);
    try {
      LOGGER.log(Level.INFO, "Lancement du serveur");
      server.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Appuyer sur Entree pour arreter le serveur.");
      reader.readLine();
    } catch (IOException | DeploymentException e) {
      throw new RuntimeException(e);
    } finally {
      LOGGER.log(Level.INFO, "Arret du serveur");
      server.stop();
    }
  }
}