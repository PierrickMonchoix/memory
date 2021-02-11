package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class VueButton extends Button implements IVue{

    private final PresentationButton presentationButton;

    

    public VueButton(PresentationButton presentationButton) {
        super();
        this.presentationButton = presentationButton;

        
        setStyle("-fx-background-color: green;");
        update();

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
    public void update() {
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
