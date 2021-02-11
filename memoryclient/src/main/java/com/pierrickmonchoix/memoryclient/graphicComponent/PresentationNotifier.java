package com.pierrickmonchoix.memoryclient.graphicComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class PresentationNotifier extends Presentation {

    private final List<IComponantListener> listListeners;

    private final EComponantEvent eventType;

    public PresentationNotifier(EComponantEvent eventType){
        listListeners = new ArrayList<IComponantListener>();
        this.eventType = eventType;
    }



    public void addListener(IComponantListener listener){
        listListeners.add(listener);
    }

    public void notifyListeners(){
        for(IComponantListener listener : listListeners){
            listener.whenNotified(eventType);
        }
    }
    
}
