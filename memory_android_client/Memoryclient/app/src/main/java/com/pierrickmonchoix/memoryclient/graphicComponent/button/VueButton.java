package com.pierrickmonchoix.memoryclient.graphicComponent.button;

import android.content.Context;

import androidx.appcompat.widget.AppCompatButton;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;



public class VueButton extends AppCompatButton implements IVue{

    private final PresentationButton presentationButton;

    public VueButton(PresentationButton presentationButton , Context context) {
        super(context);
        this.presentationButton = presentationButton;
        update();
    }

    @Override
    public void update() {
        setText(presentationButton.getText());
    }


    
}
