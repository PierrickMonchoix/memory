package com.pierrickmonchoix.memoryclient.websocketClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.pierrickmonchoix.memoryclient.websocketMessage.WebsocketMessage;

import org.glassfish.tyrus.client.ClientManager;

import javafx.application.Platform;


/**
 * need helper
 */
public class WebsocketClient {

    private static WebsocketClient instance;

    private Session currentSession;

    private List<IWebsocketClientListener> listListeners;

    private WebsocketClientEndpoint websocketClientEndpoint;

    private WebsocketClient() {
        ClientManager client = ClientManager.createClient();

        websocketClientEndpoint = new WebsocketClientEndpoint();

        try {
            currentSession = client.connectToServer(websocketClientEndpoint,
                    new URI("ws://192.168.1.41:8026/chatwebsocket/chat/mickaelbaron"));
        } catch (DeploymentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        listListeners = new ArrayList<IWebsocketClientListener>();
    }

    public void connectToEndpoint(){
        websocketClientEndpoint.setClient(this);
    }

    public static WebsocketClient getInstance() {
        if (instance == null) {
            instance = new WebsocketClient();
        }
        return instance;
    }

    public void sendMessage() {
        WebsocketMessage message = new WebsocketMessage();
        message.setContenu("yolo");
        message.setPseudo("bernado");
        message.setType(48);
        try {
            currentSession.getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException e) {
            System.out.println("### echec lors de l'envoie un message from client ");
            e.printStackTrace();
        }
    }

    public void addListener(IWebsocketClientListener listener) {
        listListeners.add(listener);
    }

    public void notifyListenersOfMessage(WebsocketMessage websocketMessage) {
        for (IWebsocketClientListener listener : listListeners) {
            System.out.println("le clientWS a bien notifié qqun");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    listener.whenReceiveWebsocketMessage(websocketMessage);
                }
            });
            
        }
    }

}
