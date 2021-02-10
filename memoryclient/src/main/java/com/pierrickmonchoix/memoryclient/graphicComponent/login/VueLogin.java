package com.pierrickmonchoix.memoryclient.graphicComponent.login;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponent.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.VueCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.textField.VueTextField;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueLogin extends VBox implements IVue {
    
    private final PresentationLogin presentationLogin;

    private final VueCheckBox vueCheckBox;
    private final VueTextField vueTextField;
    private final VueButton vueButton;

    public VueLogin(PresentationLogin presentationLogin) {
        this.presentationLogin = presentationLogin;

        vueCheckBox = (VueCheckBox)presentationLogin.getPresentationCheckBox().getVue();   // presentation chz"ekbox
        vueTextField = (VueTextField)presentationLogin.getPresentationTextField().getVue();
        vueButton = (VueButton)presentationLogin.getPresentationButton().getVue();
        

        setAlignment(Pos.TOP_CENTER);

        getChildren().addAll(vueTextField);
        getChildren().addAll(vueCheckBox);
        getChildren().addAll(vueButton);

        update();
    }

    @Override
    public void update() {
        vueCheckBox.update();
        vueTextField.update();
        vueButton.update();
    }

    



}
