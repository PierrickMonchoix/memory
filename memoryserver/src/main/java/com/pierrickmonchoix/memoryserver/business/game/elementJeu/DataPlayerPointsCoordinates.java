package com.pierrickmonchoix.memoryserver.business.game.elementJeu;

import com.google.gson.Gson;
import com.pierrickmonchoix.memoryserver.business.Player;

public class DataPlayerPointsCoordinates {
    private static Gson gson = new Gson();

    private String pseudo;
    private int points;
    private Coordinates firstCoordinates;
    private Coordinates secondCoordinates;



    
    public Coordinates getFirstCoordinates() {
        return this.firstCoordinates;
    }

    public void setFirstCoordinates(Coordinates firstCoordinates) {
        this.firstCoordinates = firstCoordinates;
    }

    public Coordinates getSecondCoordinates() {
        return this.secondCoordinates;
    }

    public void setSecondCoordinates(Coordinates secondCoordinates) {
        this.secondCoordinates = secondCoordinates;
    }


    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static DataPlayerPointsCoordinates fromJson(String string) {
        return gson.fromJson(string, DataPlayerPointsCoordinates.class);
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public DataPlayerPointsCoordinates(String pseudo, int points, Coordinates firstCoordinates,
            Coordinates secondCoordinates) {
        this.pseudo = pseudo;
        this.points = points;
        this.firstCoordinates = firstCoordinates;
        this.secondCoordinates = secondCoordinates;
    }

}