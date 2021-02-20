package com.pierrickmonchoix.memoryserver.forJson;

import java.util.List;

import com.google.gson.Gson;
import com.pierrickmonchoix.memoryserver.business.Player;
import com.pierrickmonchoix.memoryserver.business.game.Game;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.Board;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte.Coordinates;

public class GameForJson {
    public Player hostPlayer;
    public Board board;
    public List<Player> listPlayers;
    public Player actualPlayer;
    public boolean started;

    private static Gson gson = new Gson();


    public GameForJson(Player hostPlayer, Board board, List<Player> listPlayers, Player actualPlayer, boolean started) {
        this.hostPlayer = hostPlayer;
        this.board = board;
        this.listPlayers = listPlayers;
        this.actualPlayer = actualPlayer;
        this.started = started;
    }

    public GameForJson(Game game) {
        this.hostPlayer = game.getHostPlayer();
        this.board = game.getBoard();
        this.listPlayers = game.getListPlayers();
        this.actualPlayer = game.getActualPlayer();
        this.started = game.isStarted();
    }
    

    public static String gameToJson(Game game){

        GameForJson gameForJson = new GameForJson(game);

        return gameForJson.toJson();

    }


    public static Coordinates fromJson(String string){
        return gson.fromJson(string, Coordinates.class);
    }

    public String toJson(){
        return gson.toJson(this);
    }

    
}
