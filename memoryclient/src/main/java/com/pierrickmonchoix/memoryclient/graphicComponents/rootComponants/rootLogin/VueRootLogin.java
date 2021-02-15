package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.VueLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.VueLoginResult;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueRootLogin extends VBox implements IVue {
    
    private final VueLogin vueLogin;

    private final VueLoginResult vueLoginTextResult;

    public VueRootLogin(PresentationRootLogin presentationRootLogin) {

        vueLogin = new VueLogin(presentationRootLogin.getPresentationLogin());
        presentationRootLogin.getPresentationLogin().setVue(vueLogin);

        vueLoginTextResult = new VueLoginResult(presentationRootLogin.getPresentationLoginTextResult());
        presentationRootLogin.getPresentationLoginTextResult().setVue(vueLoginTextResult);;

        setAlignment(Pos.TOP_CENTER);


        

        getChildren().addAll(vueLogin);
        getChildren().addAll(vueLoginTextResult);

        update();
    }

    @Override
    public void update() {
        vueLogin.update();
    }


    




}
