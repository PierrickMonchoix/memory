package com.pierrickmonchoix.memoryclient;

class Presentation2{

    public String couleur;


    public Vue2 vue;

    public Presentation2(){
        couleur = "bleu";

        this.vue = new Vue2(this);
    }
}
