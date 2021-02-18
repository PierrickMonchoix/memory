package com.pierrickmonchoix.memoryserver.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Gére les joueurs (personnes actuelement connectées)
 */
public class PlayersManager{

    private static Logger logger = Logger.getLogger(PlayersManager.class.getName());

    private List<Player> listPlayers = new ArrayList<Player>(); // personnes connectées

    private static PlayersManager instance;

    // PATTERN SINGLETON
    public static PlayersManager getInstance() {
        if (instance == null) {
            instance = new PlayersManager();
        }
        return instance;
    }

    private PlayersManager() {

    }



    public void addNewPlayerWithPseudo(String pseudo) {
        listPlayers.add(new Player(pseudo));
        logger.info("la liste des joueurs a un new membre: \n" + listPlayers);
    }

    public void removePlayer(String pseudo) {
        GamesManager.getInstance().removeGameOfHostPseudo(pseudo);
        listPlayers.removeIf((player -> (player.getPseudo().equals(pseudo))));
        logger.info("la liste des joueurs a un membre en moins: \n" + listPlayers);
    }

    public boolean isPlayerAlreadyConnected(String pseudo) {
        for (Player player : listPlayers) {
            if (player.getPseudo().equals(pseudo)) {
                return true;
            }
        }
        return false;
    }

    public Player getPlayerFromPseudo(String pseudo) {
        for (Player player : listPlayers) {
            if (player.getPseudo().equals(pseudo)) {
                return player;
            }
        }
        logger.warning("ce joueur avec ce pseudo n'exist pas");
        return null;
    }

    public List<String> getAllPseudos() {
        List<String> listPseudos = new ArrayList<String>();
        for (Player player : listPlayers) {
            listPseudos.add(player.getPseudo());
        }
        return listPseudos;
    }



}
