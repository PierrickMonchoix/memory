package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

public class VueButton extends AppCompatButton implements IVue{

    private final PresentationButton presentationButton;

    

    public VueButton(PresentationButton presentationButton) {
        super(ContextHelper.getContext());
        this.presentationButton = presentationButton;

        updateFromPresentation();

        setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                presentationButton.alertPressed();
            }
        });
    }



    

    @Override
    public void updateFromPresentation() {
        setEnabled( presentationButton.isEnable());

        setText(presentationButton.getText());
        if(  presentationButton.getColor() != null){
            String colorStyle = presentationButton.getColor();
            setBackgroundColor(Color.parseColor(colorStyle));
            
        }
        else{
            setBackgroundColor(Color.LTGRAY);
        }
    }





    
}
