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

        vueCheckBox = new VueCheckBox(presentationLogin.getPresentationCheckBox());
        presentationLogin.getPresentationCheckBox().setVue(vueCheckBox);

        vueTextField = new VueTextField(presentationLogin.getPresentationTextField());
        presentationLogin.getPresentationTextField().setVue(vueTextField);

        vueButton = new VueButton(presentationLogin.getPresentationButton());
        presentationLogin.getPresentationButton().setVue(vueButton);
        

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
