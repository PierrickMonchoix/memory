package com.pierrickmonchoix.memoryclient.graphicComponent.login;

import android.content.Context;
import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponent.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.VueCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.textField.VueTextField;



public class VueLogin extends LinearLayout implements IVue {

    private final PresentationLogin presentationLogin;

    private final VueCheckBox vueCheckBox;
    private final VueTextField vueTextField;
    private final VueButton vueButton;

    public VueLogin(PresentationLogin presentationLogin , Context context) {
        super(context);
        this.presentationLogin = presentationLogin;

        vueCheckBox = new VueCheckBox(presentationLogin.getPresentationCheckBox() , context);
        presentationLogin.getPresentationCheckBox().setVue(vueCheckBox);

        vueTextField = new VueTextField(presentationLogin.getPresentationTextField(), context);
        presentationLogin.getPresentationTextField().setVue(vueTextField);

        vueButton = new VueButton(presentationLogin.getPresentationButton() , context);
        presentationLogin.getPresentationButton().setVue(vueButton);


        setOrientation(VERTICAL);

        addView(vueTextField);
        addView(vueCheckBox);
        addView(vueButton);

        update();
    }

    @Override
    public void update() {
        vueCheckBox.update();
        vueTextField.update();
        vueButton.update();
    }





}
