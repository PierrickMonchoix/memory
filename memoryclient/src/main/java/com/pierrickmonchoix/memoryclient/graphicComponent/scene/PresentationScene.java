package com.pierrickmonchoix.memoryclient.graphicComponent.scene;

import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;


/**
 * la presentation pricipale
 * 
 * Il faut appeler le constructeur
 * Contruire la vue
 * set la vue
 * set la mainPresentation
 * update(); (ce qui va update la vue)
 * show();
 * 
 * 
 * @param mainPresentation
 */
public class PresentationScene extends Presentation {
    
    Presentation mainPresentation;

    public Presentation getMainPresentation() {
        return mainPresentation;
    }

    public void setMainPresentation(Presentation mainPresentation) {
        this.mainPresentation = mainPresentation;
    }

 

    

}
