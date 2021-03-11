package com.pierrickmonchoix.memoryclient.graphicComponents.superclasses;

/**
 * Des présentation qui peuvent alerter des listeners d'un event particulier
 * (appui sur un bouton par exemple)
 */
public abstract class PresentationNotifier extends Presentation {

    private IChildenListener listener;

    private final EChildEvent eventType;

    public PresentationNotifier(EChildEvent eventType){
        this.eventType = eventType;
    }



    public void attributeParentListener(IChildenListener listener){
        this.listener = listener;
    }

    public void notifyParent(){
        if(listener != null){
            listener.whenNotifiedByChild(eventType);
        }
    }
    
}
