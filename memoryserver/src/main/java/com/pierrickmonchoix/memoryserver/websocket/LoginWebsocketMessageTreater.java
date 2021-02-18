package com.pierrickmonchoix.memoryserver.websocket;

import java.util.logging.Logger;

import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.business.GamesManager;
import com.pierrickmonchoix.memoryserver.business.Personne;
import com.pierrickmonchoix.memoryserver.business.PlayersManager;
import com.pierrickmonchoix.memoryserver.dao.FactoryDao;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

/**
 * Traite tous les massages entrants concernant le login (client > serveur)
 * C'est la seul classe "gérant" les messages, car il faut associer un pseudo à une session.
 * Il faut donc lui passer en parametre une session. Ce n'est donc pas concevable de la mettre coté business.
 */
public class LoginWebsocketMessageTreater {

    private static Logger logger = Logger.getLogger(LoginWebsocketMessageTreater.class.getName());

    public static void treatMessage(WebsocketMessage message, Session session) {
        if (message.getPseudo().equals("unknown") && WebsocketServerHelper.getPseudoOfSession(session).equals("unknown")
                && !PlayersManager.getInstance().isPlayerAlreadyConnected(message.getContenu())) {
            switch (message.getType()) {
                case SIGN_IN: // message n'a pas encore de pseudo
                    logger.info("message sign in detected");
                    treatSignInMessage(message, session);

                    break;
                default:
                case SIGN_UP: // message n'a pas encore de pseudo

                    logger.info("message sign up detected");
                    treatSignUpMessage(message, session);

                    break;
            }
        } else if (PlayersManager.getInstance().isPlayerAlreadyConnected(message.getContenu())) {
            logger.info("le joueur : " + message.getContenu() + " est deja connecté");
            WebsocketMessage response = WebsocketMessage.newResponseMessage(message);
            response.setContenu("nok_already_connected_player");
            WebsocketServerHelper.sendMessageToClient(session, response);
        } else {
            logger.warning("attributed pseudo incorect: pseudo message " + message.getPseudo() + " , pseudo session "
                    + WebsocketServerHelper.getPseudoOfSession(session) + " , aucun message transmit au client");

        }
    }

    private static void treatSignInMessage(WebsocketMessage message, Session session) {
        String pseudo = message.getContenu();
        WebsocketMessage response = WebsocketMessage.newResponseMessage(message);
        boolean isInDatabase = FactoryDao.isExisting(new Personne(pseudo));
        if (isInDatabase) {
            response.setContenu("ok_existing_pseudo");
            response.setPseudo(pseudo);

            WebsocketServerHelper.givePseudoToSession(session, pseudo);
            PlayersManager.getInstance().addNewPlayerWithPseudo(pseudo);

            sendMessgeToUpdateListGamesTo(pseudo,session);
        } else {
            response.setContenu("nok_not_existing_pseudo");
        }
        WebsocketServerHelper.sendMessageToClient(session, response);

        

    }

    private static void treatSignUpMessage(WebsocketMessage message, Session session) {
        String pseudo = message.getContenu();
        WebsocketMessage response = WebsocketMessage.newResponseMessage(message);
        boolean isInDatabase = FactoryDao.isExisting(new Personne(pseudo));
        if (isInDatabase) {
            logger.info("nok : il y a deja une personne avec le pseudo : " + pseudo + " dans la DB");
            response.setContenu("nok_existing_pseudo");
        } else {
            logger.info("ok : il n'y a pas encore de personne avec le pseudo : " + pseudo + " dans la DB");
            response.setContenu("ok_not_existing_pseudo");
            response.setPseudo(pseudo);

            WebsocketServerHelper.givePseudoToSession(session, pseudo);
            PlayersManager.getInstance().addNewPlayerWithPseudo(pseudo);
            FactoryDao.createPersonne(new Personne(pseudo));

            sendMessgeToUpdateListGamesTo(pseudo,session);
        }
        WebsocketServerHelper.sendMessageToClient(session, response);
        //WebsocketServerHelper.sendMessageToClient(session, )
    }


    public static void sendMessgeToUpdateListGamesTo(String pseudo , Session session){
        WebsocketMessage messageUpdateListGames = new WebsocketMessage();
        messageUpdateListGames.setPseudo(pseudo);
        messageUpdateListGames.setType(EMessageType.UPDATE_LIST_GAMES);
        messageUpdateListGames.setContenu(GamesManager.getInstance().getJson());
        WebsocketServerHelper.sendMessageToClient(session, messageUpdateListGames);
    }

}
