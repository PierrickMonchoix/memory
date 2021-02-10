package com.pierrickmonchoix.memoryclient.graphicComponent.button;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;

import javafx.scene.control.Button;


public class VueButton extends Button implements IVue{

    private final PresentationButton presentationButton;

    public VueButton(PresentationButton presentationButton) {
        super();
        this.presentationButton = presentationButton;
        update();
    }

    @Override
    public void update() {
        setText(presentationButton.getText());
    }


    
}
