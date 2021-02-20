package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.VueLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.VueLoginResult;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueRootLogin extends VBox implements IVue {
    
    private final VueLogin vueLogin;

    private final VueLoginResult vueLoginTextResult;

    public VueRootLogin(PresentationRootLogin presentationRootLogin) {

        vueLogin = (VueLogin) presentationRootLogin.getPresentationLogin().getVue();

        vueLoginTextResult = (VueLoginResult) presentationRootLogin.getPresentationLoginTextResult().getVue();

        setAlignment(Pos.TOP_CENTER);


        

        getChildren().addAll(vueLogin);
        getChildren().addAll(vueLoginTextResult);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        
    }


    




}
