package com.pierrickmonchoix.memoryserver.websocketServer;

import java.util.HashMap;
import java.util.Map;

import org.glassfish.tyrus.server.Server;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
public class WebsocketServerLauncher {

	public static void main(String[] args) {
        
		Server server = new Server("localhost", 8026, "/memory", null, WebsocketServerEndpoint.class);

		try {
			server.start();

			System.out.println("Tyrus app started available at ws://localhost:8026/memory"
					+ "\nHit enter to stop it...");

			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.stop();
		}
	}
}
