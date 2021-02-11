package com.pierrickmonchoix.memoryclient.graphicComponent.rootLogin;

import android.content.Context;
import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponent.login.VueLogin;


public class VueRootLogin extends LinearLayout implements IVue {
    
    private final PresentationRootLogin presentationRootLogin;

    private final VueLogin vueLogin;

    public VueRootLogin(PresentationRootLogin presentationRootLogin , Context context) {
        super(context);
        this.presentationRootLogin = presentationRootLogin;

        vueLogin = new VueLogin(presentationRootLogin.getPresentationLogin() , context);
        presentationRootLogin.getPresentationLogin().setVue(vueLogin);

        setOrientation(VERTICAL);


        addView(vueLogin);

        update();
    }

    @Override
    public void update() {
        vueLogin.update();
    }


    




}
