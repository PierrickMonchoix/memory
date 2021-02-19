package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

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
        updateFromPresentation();

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
    public void updateFromPresentation() {
        this.setText(presentationCheckBox.getText());
    }

    /*
     * les accesseurs :
     */
    public boolean isCheckedInput() {
        return isSelected();
    }

}
