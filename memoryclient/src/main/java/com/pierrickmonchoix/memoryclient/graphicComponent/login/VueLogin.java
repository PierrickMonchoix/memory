package com.pierrickmonchoix.memoryclient.graphicComponent.login;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.VueCheckBox;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueLogin extends VBox implements IVue {
    
    PresentationLogin presentationLogin;

    VueCheckBox vueCheckBox;

    public VueLogin(PresentationLogin presentationLogin) {
        this.presentationLogin = presentationLogin;

        vueCheckBox = (VueCheckBox)presentationLogin.getPresentationCheckBox().getVue();   // presentation chz"ekbox

        setAlignment(Pos.TOP_CENTER);

        getChildren().addAll(vueCheckBox);

        update();
        
    }

    @Override
    public void update() {
        vueCheckBox.update();
    }

    



}
