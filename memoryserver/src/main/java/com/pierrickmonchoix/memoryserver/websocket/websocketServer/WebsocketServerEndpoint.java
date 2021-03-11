package com.pierrickmonchoix.memoryserver.websocket.websocketServer;

import java.io.IOException;
import java.util.logging.Logger;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessageDecoder;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessageEncoder;

/**
 * Decrit ce que dois faire le serveur lors de la reception de msg , open et close de sessions.
 * Il communique UNIQUEMENT avec 'WebsocketServerHelper'
 * 
 * grace aux encodeurd/decoders, la classe recoit des json et renvoie des json
 * automatiquement (avec andoird on doit le faire a la main a priori)
 */
@ServerEndpoint(value = "/websocket", encoders = WebsocketMessageEncoder.class, decoders = WebsocketMessageDecoder.class)
public class WebsocketServerEndpoint {

    private static Logger logger = Logger.getLogger(WebsocketServerEndpoint.class.getName());

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("ChatEndpoint.onOpen()");
        WebsocketServerHelper.updateListSessions(session);
    }

    @OnMessage
    public void onMessage(WebsocketMessage message, Session session) {

        logger.info("le server recoit : " + message);

        WebsocketServerHelper.receiveMessage( message, session );
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("ChatEndpoint.onClose()");
        WebsocketServerHelper.removeSession(session);
    }

}
