package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField;

import android.content.Context;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

public class VueTextField extends AppCompatEditText implements IVue{

    private final PresentationTextField presentationTextField;

    public VueTextField(PresentationTextField presentationTextField) {
        super(ContextHelper.getContext());

        this.presentationTextField = presentationTextField;
        setText(this.presentationTextField.getDefaultText());

        
        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
       //vide, normal car il n'y a QUE des inputs
    }

    public String getTextInput(){
        return getText().toString();
    }


}
