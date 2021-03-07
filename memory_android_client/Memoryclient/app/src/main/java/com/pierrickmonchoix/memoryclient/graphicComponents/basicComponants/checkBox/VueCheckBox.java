package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox;

import android.content.Context;
import android.widget.CompoundButton;

import androidx.appcompat.widget.AppCompatCheckBox;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


/*
l'extends et l'implement de IVue :
*/
public class VueCheckBox extends AppCompatCheckBox implements IVue {

    /*
     * sa presentation :
     */
    private final PresentationCheckBox presentationCheckBox;

    public VueCheckBox(PresentationCheckBox presentationCheckBox) {
        /*
         * le super :
         */
        super(ContextHelper.getContext());
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

        setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
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
        return isChecked();
    }

}
