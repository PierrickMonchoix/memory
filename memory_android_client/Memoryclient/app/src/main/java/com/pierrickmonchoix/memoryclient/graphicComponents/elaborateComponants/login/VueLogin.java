package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox.VueCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField.VueTextField;



public class VueLogin extends LinearLayout implements IVue {
    

    private final VueCheckBox vueCheckBox;
    private final VueTextField vueTextField;
    private final VueButton vueButton;




    public VueLogin(PresentationLogin presentationLogin) {
        super(ContextHelper.getContext());
        vueCheckBox = (VueCheckBox) presentationLogin.getPresentationCheckBox().getVue();
        vueTextField = (VueTextField) presentationLogin.getPresentationTextField().getVue();
        vueButton = (VueButton) presentationLogin.getPresentationButton().getVue();

        setOrientation(VERTICAL);



        addView(vueTextField);
        addView(vueCheckBox);
        addView(vueButton);


        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {  // only upgrade position
            //nothing to MOVE
    }

    



}
