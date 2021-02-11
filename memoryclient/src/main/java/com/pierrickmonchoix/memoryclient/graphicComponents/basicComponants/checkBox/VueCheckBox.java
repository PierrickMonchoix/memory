package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox;

import javafx.scene.control.CheckBox;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
l'extends et l'implement de IVue :
*/
public class VueCheckBox extends CheckBox implements IVue {

    /*
     * sa presentation :
     */
    private final PresentationCheckBox presentationCheckBox;

    public VueCheckBox(PresentationCheckBox presentationCheckBox) {
        /*
         * le super :
         */
        super();
        /*
         * l'initialisation de sa présentation :
         */
        this.presentationCheckBox = presentationCheckBox;
        /*
         * les valeurs par défaut :
         */
        setSelected(presentationCheckBox.isDefaultChecked());
        /*
         * l'update d'initialisation :
         */
        update();

        setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                presentationCheckBox.alertChecked();
            }
        });

    }

    /*
     * l'update :
     */
    @Override
    public void update() {
        this.setText(presentationCheckBox.getText());
    }

    /*
     * les accesseurs :
     */
    public boolean isCheckedInput() {
        return isSelected();
    }

}
