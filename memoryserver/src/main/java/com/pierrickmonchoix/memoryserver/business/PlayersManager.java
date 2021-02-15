package com.pierrickmonchoix.memoryserver.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Gére les joueurs (personnes actuelement connectées)
 */
public class PlayersManager {

    private static Logger logger = Logger.getLogger(PlayersManager.class.getName());

    private static List<Player> listPlayers = new ArrayList<Player>(); // personnes connectées

    public static void addNewPlayerWithPseudo(String pseudo) {
        listPlayers.add(new Player(pseudo));
        logger.info("la liste des joueurs a un new membre: \n" + listPlayers);
    }

}
