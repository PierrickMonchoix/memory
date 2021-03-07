package com.pierrickmonchoix.memoryclient.graphicComponents.superclasses;


/**
 * Peut ecouter plusieurs enfants
 */
public interface IChildenListener {

        /**
     * fonction a mettre a la fin du constructeur !!!
     */
    public void listenAllChildren();


    public void whenNotifiedByChild(EChildEvent typeEvent);



}
