package com.pierrickmonchoix.memoryserver.business;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.dao.FactoryDao;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class ConnectedPlayersManager {

    private static List<Player> listPlayers = new ArrayList<Player>();  // joueurs connectes

    public static void addNewPlayerWithPseudo(String pseudo){
        listPlayers.add(new Player(pseudo));
    }

    public static void treatUnknownMessage(WebsocketMessage message, Session session){
        switch (message.getType()) {
            case SIGN_IN:
            String pseudo = message.getContenu();
                boolean isInDatabase = FactoryDao.isExisting( new Personne( pseudo ) );
                if(isInDatabase){
                    listJoueurs.add(new Joueur(pseudo));
                    WebsocketServerHelper.givePseudoToSession(session , message.getPseudo());
                    WebsocketMessage.
                }
                
                break;
        
            default:
                break;
        }
    }

}
