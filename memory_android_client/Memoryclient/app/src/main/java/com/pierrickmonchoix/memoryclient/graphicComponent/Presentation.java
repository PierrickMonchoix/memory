package com.pierrickmonchoix.memoryclient.graphicComponent;


/**
 * Posséde déja une IVue par défaut, mais elle DOIT être set juste apres la construction
 */
public abstract class Presentation {

    protected IVue vue;

    public void setVue(IVue vue) {
        this.vue = vue;
    }

    public IVue getVue() {
        return vue;
    }

    public void updateVue(){
        vue.update();
    }









}
