package com.pierrickmonchoix.memoryclient.graphicComponent2.checkBox;

import android.content.Context;

import androidx.appcompat.widget.AppCompatCheckBox;

import com.pierrickmonchoix.memoryclient.graphicComponent2.IVue;


/*
l'extends et l'implement de IVue :
*/
public class VueCheckBox extends AppCompatCheckBox implements IVue {

    /*
     * sa presentation :
     */
    private final PresentationCheckBox presentationCheckBox;

    public VueCheckBox(PresentationCheckBox presentationCheckBox , Context context) {
        /*
         * le super :
         */
        super(context);
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
