package com.pierrickmonchoix.memoryclient.graphicComponents.superclasses;

import android.os.Handler;

import com.pierrickmonchoix.memoryclient.ContextHelper;

import java.util.logging.Logger;


/**
 * Posséde déja une IVue par défaut, mais elle DOIT être set juste apres la
 * construction
 */
public abstract class Presentation {





    private static Logger logger = Logger.getLogger(Presentation.class.getName());

    protected IVue vue;



    public void setVue(IVue vue) {
        this.vue = vue;
    }

    public IVue getVue() {
        return vue;
    }

    public void updateVue() {
        if (vue == null) {
            logger.warning("cette presentation a aune vue null : " + this.toString() + " : " + this.getClass().getName());
        }
        //vue.updateFromPresentation();
        Handler mainHandler = new Handler(ContextHelper.getContext().getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                vue.updateFromPresentation();
            } // This is your code
        };
        mainHandler.post(myRunnable);
    /*
    Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vue.updateFromPresentation();
            }
        });
         */
        
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getClass().getName();
    }

}
