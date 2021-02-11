package com.pierrickmonchoix.memoryclient.graphicComponent.button;


import com.pierrickmonchoix.memoryclient.graphicComponent.EComponantEvent;
import com.pierrickmonchoix.memoryclient.graphicComponent.PresentationNotifier;



public class PresentationButton extends PresentationNotifier {


    
    public String text;

    public PresentationButton(String text) {
        super(EComponantEvent.BUTTON_PRESSED);
        this.text = text;

        
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        updateVue();
    }





    public void alertPressed(){ 
        notifyListeners();
    }







    





}
