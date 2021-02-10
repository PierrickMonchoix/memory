package com.pierrickmonchoix.memoryclient.graphicComponent.button;

import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;

public class PresentationButton extends Presentation {
    
    public String text;

    public PresentationButton(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    

    


}
