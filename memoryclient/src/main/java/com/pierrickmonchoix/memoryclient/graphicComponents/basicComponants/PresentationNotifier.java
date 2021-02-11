package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;

public abstract class PresentationNotifier extends Presentation {

    private final List<IComponantListener> listListeners;

    private final EComponantBasicEvent eventType;

    public PresentationNotifier(EComponantBasicEvent eventType){
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
