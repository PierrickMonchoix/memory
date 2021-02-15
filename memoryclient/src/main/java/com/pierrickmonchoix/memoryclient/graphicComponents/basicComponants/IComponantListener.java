package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants;


/**
 * Les classes qui écoutent les 'PrésentationNotifiers' (appui sur un bouton)
 */
public interface IComponantListener {

    public void whenNotifiedByComponant(EComponantBasicEvent typeEvent);

}
