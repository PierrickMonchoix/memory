package com.pierrickmonchoix.memoryserver.websocket.websocketServer;

import org.glassfish.tyrus.server.Server;

/**
 * Permet de lancer le serveur ws
 */
public class WebsocketServerLauncher {

	public static void launch() {
        // accessible to : ws://localhost:8026/memory/websocket
		Server server = new Server("localhost", 8026, "/memory", null, WebsocketServerEndpoint.class);

		try {
			server.start();

			System.out.println("Tyrus app started available at ws://localhost:8026/memory/websocket"
					+ "\nHit enter to stop it...");

			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.stop();
		}
	}

}
