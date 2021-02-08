package com.pierrickmonchoix.memoryclient;

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

    @Override
    public String toString() {
        return "Message [canal=" + canal + ", contenu=" + contenu + "]";
    }

    

}


