package com.pierrickmonchoix.memoryclient.graphicComponent.textField;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;

import javafx.scene.control.TextField;

public class VueTextField extends TextField implements IVue{

    private final PresentationTextField presentationTextField;

    public VueTextField(PresentationTextField presentationTextField) {
        super();

        this.presentationTextField = presentationTextField;
        setText(this.presentationTextField.getDefaultText());

        
        update();
    }

    @Override
    public void update() {
       //vide, normal car il n'y a QUE des inputs
    }

    public String getTextInput(){
        return getText();
    }


}
