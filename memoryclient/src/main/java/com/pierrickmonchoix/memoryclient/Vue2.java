package com.pierrickmonchoix.memoryclient;




class Vue2{

    public String name = "moi Vue";

    
    public Presentation2 presentation;

    public String couleurShow;

    public Vue2(Presentation2 presentation){
        this.presentation = presentation;
        couleurShow = presentation.couleur;

    }

}