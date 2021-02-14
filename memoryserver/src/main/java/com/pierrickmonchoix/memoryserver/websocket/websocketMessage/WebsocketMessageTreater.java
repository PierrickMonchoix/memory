package com.pierrickmonchoix.memoryserver.websocket.websocketMessage;

import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.business.ConnectedPlayersManager;
import com.pierrickmonchoix.memoryserver.business.Personne;
import com.pierrickmonchoix.memoryserver.dao.FactoryDao;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;

public class WebsocketMessageTreater {

    public static void treatMessage(WebsocketMessage message, Session session) {
        switch (message.getType()) {
            case SIGN_IN:
                treatSignInMessage(message, session);
                break;
            default:
            case SIGN_UP:
                treatSignUpMessage(message, session);
                break;
        }
    }

    private static void treatSignInMessage(WebsocketMessage message, Session session) {
        String pseudo = message.getContenu();
        boolean isInDatabase = FactoryDao.isExisting(new Personne(pseudo));
        if (isInDatabase) {
            message.setContenu("ok_existing_pseudo");

            WebsocketServerHelper.givePseudoToSession(session, pseudo);
            ConnectedPlayersManager.addNewPlayerWithPseudo(pseudo);
        } else {
            message.setContenu("error_not_existing_pseudo");
        }
        WebsocketServerHelper.sendMessageToClient(session, message);
    }

    private static void treatSignUpMessage(WebsocketMessage message, Session session) {
        String pseudo = message.getContenu();
        boolean isInDatabase = FactoryDao.isExisting(new Personne(pseudo));
        if (isInDatabase) {
            message.setContenu("error_existing_pseudo");
        } else {
            message.setContenu("ok_not_existing_pseudo");

            WebsocketServerHelper.givePseudoToSession(session, pseudo);
            ConnectedPlayersManager.addNewPlayerWithPseudo(pseudo);
            FactoryDao.createPersonne(new Personne(pseudo));
        }
        WebsocketServerHelper.sendMessageToClient(session, message);
    }

}
