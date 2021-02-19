package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox.VueCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField.VueTextField;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueLogin extends VBox implements IVue {
    

    private final VueCheckBox vueCheckBox;
    private final VueTextField vueTextField;
    private final VueButton vueButton;

    private static Logger logger = Logger.getLogger(VueLogin.class.getName());



    public VueLogin(PresentationLogin presentationLogin) {
        logger.info("creation");

        vueCheckBox = (VueCheckBox) presentationLogin.getPresentationCheckBox().getVue();
        vueTextField = (VueTextField) presentationLogin.getPresentationTextField().getVue();
        vueButton = (VueButton) presentationLogin.getPresentationButton().getVue();

        getChildren().addAll(vueTextField);
        getChildren().addAll(vueCheckBox);
        getChildren().addAll(vueButton);


        setAlignment(Pos.TOP_CENTER);
        


        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {  // only upgrade position
            //nothing to MOVE
    }

    



}
