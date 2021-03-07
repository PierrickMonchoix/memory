package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput;

import android.content.Context;

import androidx.appcompat.widget.AppCompatTextView;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

public class VueTextOutput extends AppCompatTextView implements IVue {

    private final PresentationTextOutput presentationTextOutput;

    public VueTextOutput(PresentationTextOutput presentationTextOutput ) {
        super(ContextHelper.getContext());
        this.presentationTextOutput = presentationTextOutput;

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        setText(presentationTextOutput.getText());
    }


}
