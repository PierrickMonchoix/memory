package com.pierrickmonchoix.memoryserver.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.websocket.Session;

import com.pierrickmonchoix.memoryserver.dao.FactoryDao;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class ConnectedPlayersManager {

    private static Logger logger = Logger.getLogger(ConnectedPlayersManager.class.getName());

    private static List<Player> listPlayers = new ArrayList<Player>();  // joueurs connectes

    public static void addNewPlayerWithPseudo(String pseudo){
        listPlayers.add(new Player(pseudo));
        logger.info("la liste des joueurs a un new membre: \n" + listPlayers);
    }

}
