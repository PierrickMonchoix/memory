package com.pierrickmonchoix.memoryclient.graphicComponent.checkBox;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;

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
        update();
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
