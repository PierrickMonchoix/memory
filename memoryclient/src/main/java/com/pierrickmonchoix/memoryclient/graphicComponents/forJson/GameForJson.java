package com.pierrickmonchoix.memoryclient.graphicComponents.forJson;

import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;

public class GameForJson {
    public static Logger logger = Logger.getLogger(GameForJson.class.getName());

    public PlayerForJson hostPlayer;

    public BoardForJson board;
    public List<PlayerForJson> listPlayers;
    public static final int maxPlayer = 3;
    public PlayerForJson actualPlayer;

    public PlayerForJson winner;

    public boolean started;

    public static Gson gson = new Gson();


    // GSON FUNCTIONS
    public static GameForJson fromJson(String string) {
        return gson.fromJson(string, GameForJson.class);
    }

    public String toJson() {
        return gson.toJson(this);
    }

}
