package com.pierrickmonchoix.memoryserver.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.Game;

public class GamesManager {

    private static Logger logger = Logger.getLogger(GamesManager.class.getName());

    private final static List<Game> listGames = new ArrayList<Game>();


    public static void createGameOfHostPlayerPseudo(String pseudo){
        Player hostPlayer = PlayersManager.getPlayerFromPseudo(pseudo);
        createGameOfHostPlayer(hostPlayer);
    }
    private static void createGameOfHostPlayer(Player hostPlayer){
        Game newGame = new Game(hostPlayer);
        listGames.add(newGame);
    }

    // APPELE PAR LES GAME ENGINE
    public static void removeGame(Game game){
        listGames.remove(game);
    }



    public static void addPlayerToGame(String hostPlayerPseudo , String playerPseudo){
        Game game = getGameOfHost(hostPlayerPseudo);
        game.addPlayer(playerPseudo);
    }
    private static Game getGameOfHost(String hostPlayerPseudo){
        for (Game game : listGames) {
            if(game.getHostPlayer().getPseudo().equals(hostPlayerPseudo)){  // pseudo des hostPlayers
                return game;
            }
        }
        logger.warning("pas de partie avec ce joueur trouvée...");
        return null;
    }

    public static List<Game> getListGames() {
        return listGames;
    }

    public static String getJson(){
        GameManagerForJson gameManagerForJson = new GameManagerForJson();
        return gameManagerForJson.toJson();
    }



    

}
