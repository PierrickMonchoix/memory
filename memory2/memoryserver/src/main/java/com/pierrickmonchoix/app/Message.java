package com.pierrickmonchoix.app;

public class Message {
    private String contenu;
    private int canal;


    

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public Message(String contenu, int canal) {
        this.contenu = contenu;
        this.canal = canal;
    }
}


