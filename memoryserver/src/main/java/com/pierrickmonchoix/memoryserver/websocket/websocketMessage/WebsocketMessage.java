package com.pierrickmonchoix.memoryserver.websocket.websocketMessage;

import com.google.gson.Gson;

/**
 * Un message websocket composé d'un pseudo (pou savoir ace qui on parle)
 *  d'un type (pour savoir le sujet dont on parle)
 *  le contenu (ce qu'on envoie comme info) (un nombre, une info binaire ...)
 */
public class WebsocketMessage {

    private static Gson gson = new Gson();

	private String pseudo;
	private String contenu;
    private EMessageType type;

    public static WebsocketMessage newResponseMessage(WebsocketMessage message){
        WebsocketMessage response = new WebsocketMessage();
        response.setPseudo(message.getPseudo());
        response.setType(message.getType());
        return response;
    }

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


    

    @Override
    public String toString() {
        return "WebsocketMessage [pseudo=" + pseudo + ", type=" + type + ", contenu=" + contenu + "]";
    }

    public String toJson(){
        return gson.toJson(this);
    }

    public static WebsocketMessage fromJson(String string){
        return gson.fromJson(string, WebsocketMessage.class);
    }

    public WebsocketMessage(){}


    public WebsocketMessage(String pseudo, EMessageType type, String contenu) {
        this.pseudo = pseudo;
        this.contenu = contenu;
        this.type = type;
    }

    public EMessageType getType() {
        return type;
    }

    public void setType(EMessageType type) {
        this.type = type;
    }

    

    

    
	
}
