package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button;


import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.PresentationNotifier;



public class PresentationButton extends PresentationNotifier {


    
    public String text;
    public String color;


    public PresentationButton(String text) {
        super(EComponantBasicEvent.BUTTON_PRESSED);
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        updateVue();
    }







    





}
