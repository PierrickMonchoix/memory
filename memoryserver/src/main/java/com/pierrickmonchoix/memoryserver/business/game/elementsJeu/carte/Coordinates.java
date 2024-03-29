package com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte;

import com.google.gson.Gson;


/** 
 * Coordonnées d'une carte
*/
public class Coordinates {

    private static Gson gson = new Gson();

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinates other = (Coordinates) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public static Coordinates fromJson(String string){
        return gson.fromJson(string, Coordinates.class);
    }

    public String toJson(){
        return gson.toJson(this);
    }

    @Override
    public String toString() {
        return "Coordinates [x=" + x + ", y=" + y + "]";
    }

    



    

}
