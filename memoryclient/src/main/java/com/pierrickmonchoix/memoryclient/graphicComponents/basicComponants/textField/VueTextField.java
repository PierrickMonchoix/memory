package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.control.TextField;

public class VueTextField extends TextField implements IVue{

    private final PresentationTextField presentationTextField;

    public VueTextField(PresentationTextField presentationTextField) {
        super();

        this.presentationTextField = presentationTextField;
        setText(this.presentationTextField.getDefaultText());

        
        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
       //vide, normal car il n'y a QUE des inputs
    }

    public String getTextInput(){
        return getText();
    }


}
