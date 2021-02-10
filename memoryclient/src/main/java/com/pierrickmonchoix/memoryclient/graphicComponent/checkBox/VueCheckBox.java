package com.pierrickmonchoix.memoryclient.graphicComponent.checkBox;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;

import javafx.scene.control.CheckBox;

public class VueCheckBox extends CheckBox implements IVue{

    private PresentationCheckBox presentationCheckBox;

    public VueCheckBox(PresentationCheckBox presentationCheckBox) {
        super();
        this.presentationCheckBox = presentationCheckBox;
        setSelected(presentationCheckBox.isDefaultChecked());

        update();
    }


    @Override
    public void update() {
        this.setText(presentationCheckBox.getText());
    }

    public boolean isChecked(){
        return isSelected();
    }




    
    
}
