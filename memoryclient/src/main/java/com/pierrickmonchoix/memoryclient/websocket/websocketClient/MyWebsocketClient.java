package com.pierrickmonchoix.memoryclient.websocket.websocketClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

import org.glassfish.tyrus.client.ClientManager;


/**
 * Client web socket muni d'un pattern singleton. Ce client est UNIQUEMENT
 * utilisé par 'WebsocketHelper'
 */
public class MyWebsocketClient {

    private String ipServer = "localhost";

    private static MyWebsocketClient instance;

    private Session currentSession;

    private List<IWebsocketListener> listListeners;

    private WebsocketClientEndpoint websocketClientEndpoint;

    private MyWebsocketClient() {
        ClientManager client = ClientManager.createClient();

        websocketClientEndpoint = new WebsocketClientEndpoint();

        String serverUri = "ws://" + ipServer + ":8026/memory/websocket";

        try {
            currentSession = client.connectToServer(websocketClientEndpoint,
                    new URI(serverUri));
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        listListeners = new ArrayList<IWebsocketListener>();
    }

    public void connectToEndpoint() {
        websocketClientEndpoint.setClient(this);
    }

    public static MyWebsocketClient getInstance() {
        if (instance == null) {
            instance = new MyWebsocketClient();
            instance.connectToEndpoint();
        }
        return instance;
    }

    public void sendMessage(WebsocketMessage message) {
        try {
            currentSession.getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException e) {
            System.out.println("### echec lors de l'envoie un message from client ");
            e.printStackTrace();
        }
    }

    public void addListener(IWebsocketListener listener) {
        listListeners.add(listener);
    }

}
