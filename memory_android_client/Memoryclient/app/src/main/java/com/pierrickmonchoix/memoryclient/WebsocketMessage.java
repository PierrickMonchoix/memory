package com.pierrickmonchoix.memoryclient;


import com.google.gson.Gson;

/**
 * Message envoyé par les clients
 * @author michaelrichard
 */
public class WebsocketMessage {

    private String pseudo;
    private String contenu;
    private int type;

    private static Gson gson = new Gson();

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WebsocketMessage [pseudo=" + pseudo + ", type=" + type + ", contenu=" + contenu + "]";
    }

    public String toJson(){
        return gson.toJson(this);
    }

    public static WebsocketMessage toObject(String string){
        return gson.fromJson(string, WebsocketMessage.class);
    }





}