package com.pierrickmonchoix.memoryserver.business;

import com.google.gson.Gson;

/**
 * un player est une personne qui a reussi a passer le lgoin, connexion réussie.
 */
public class Player {

    private static Gson gson = new Gson();

    private String pseudo;
    private int points;

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void incrementPoints(){
        points ++;
    } 

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Player(String pseudo) {
        this.pseudo = pseudo;
    }

    

    @Override
    public String toString() {
        return "Player [pseudo=" + pseudo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
        return result;
    }

    // CHECK PSEUDO
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;

        if (pseudo == null) {  
            if (other.pseudo != null)
                return false;
        } else if (!pseudo.equals(other.pseudo))
            return false;
        return true;
    }

    public static Player fromJson(String string){
        return gson.fromJson(string, Player.class);
    }

    public String toJson(){
        return gson.toJson(this);
    }



}
