package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.VueLogin;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueRootLogin extends VBox implements IVue {
    
    private final PresentationRootLogin presentationRootLogin;

    private final VueLogin vueLogin;

    public VueRootLogin(PresentationRootLogin presentationRootLogin) {
        this.presentationRootLogin = presentationRootLogin;

        vueLogin = new VueLogin(presentationRootLogin.getPresentationLogin());
        presentationRootLogin.getPresentationLogin().setVue(vueLogin);

        setAlignment(Pos.TOP_CENTER);
        

        getChildren().addAll(vueLogin);

        update();
    }

    @Override
    public void update() {
        vueLogin.update();
    }


    




}
