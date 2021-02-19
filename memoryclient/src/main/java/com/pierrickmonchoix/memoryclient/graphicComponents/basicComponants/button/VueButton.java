package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class VueButton extends Button implements IVue{

    private final PresentationButton presentationButton;

    

    public VueButton(PresentationButton presentationButton) {
        super();
        this.presentationButton = presentationButton;

        updateFromPresentation();

        /*
            Ajout des notifiers
        */
        setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                presentationButton.alertPressed();
            }
        });
    }



    

    @Override
    public void updateFromPresentation() {
        setDisable( ! presentationButton.isEnable());

        setText(presentationButton.getText());
        if(  presentationButton.getColor() != null){
            String colorStyle = "-fx-background-color: "+ presentationButton.getColor() +";";
            setStyle(colorStyle);
            
        }
        else{
            setStyle(null);
        }
    }





    
}
