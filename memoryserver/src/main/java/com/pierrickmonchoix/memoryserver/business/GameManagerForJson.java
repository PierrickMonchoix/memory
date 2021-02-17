package com.pierrickmonchoix.memoryserver.business;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.pierrickmonchoix.memoryserver.business.game.Game;

/**
 * On tentera de trouver une alternative pour cette classe 
 * (qui a pour but de renvoyer un json des parties en cours)
 * si on a le temps
 */
public class GameManagerForJson {

    private static Gson gson = new Gson();

    public List<ShownGameForJson> listJsonGames;
    

    class ShownGameForJson{
        public String pseudoHost;
        public int numberPlayer;
        public int maxPlayer;

        public ShownGameForJson(Game game) {
            this.pseudoHost = game.getHostPlayer().getPseudo();
            this.numberPlayer = game.getListPlayers().size();
            this.maxPlayer = game.getMaxPlayer();
        }
    }

    public GameManagerForJson(){
        listJsonGames = new ArrayList<ShownGameForJson>();
        List<Game> listGames = GamesManager.getListGames();
        for (Game g : listGames) {
            ShownGameForJson jsonGame = new ShownGameForJson(g);
            listJsonGames.add(jsonGame);
        }
    }

    

    




    public static GameManagerForJson fromJson(String string){
        return gson.fromJson(string, GameManagerForJson.class);
    }

    public String toJson(){
        return gson.toJson(this);
    }

}
