package com.pierrickmonchoix.memoryclient.graphicComponent.textField;

import android.content.Context;
import android.widget.EditText;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;


public class VueTextField extends androidx.appcompat.widget.AppCompatEditText implements IVue{

    private final PresentationTextField presentationTextField;

    public VueTextField(PresentationTextField presentationTextField , Context context) {
        super(context);
        this.presentationTextField = presentationTextField;

        setText(this.presentationTextField.getDefaultText());


        update();
    }

    @Override
    public void update() {
       //vide, normal car il n'y a QUE des inputs

    }

    public String getTextInput(){
        return getText().toString();
    }


}
