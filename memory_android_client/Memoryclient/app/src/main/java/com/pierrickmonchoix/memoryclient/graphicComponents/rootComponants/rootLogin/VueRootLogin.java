package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.VueLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.VueLoginResult;


public class VueRootLogin extends LinearLayout implements IVue {
    
    private final VueLogin vueLogin;

    private final VueLoginResult vueLoginTextResult;

    public VueRootLogin(PresentationRootLogin presentationRootLogin) {
        super(ContextHelper.getContext());

        vueLogin = (VueLogin) presentationRootLogin.getPresentationLogin().getVue();

        vueLoginTextResult = (VueLoginResult) presentationRootLogin.getPresentationLoginTextResult().getVue();


        setOrientation(VERTICAL);


        addView(vueLogin);
        addView(vueLoginTextResult);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // nothing to move
    }


    




}
