package com.pierrickmonchoix.memoryclient.graphicComponent.login;

import com.pierrickmonchoix.memoryclient.graphicComponent.EComponantEvent;
import com.pierrickmonchoix.memoryclient.graphicComponent.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponent.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.PresentationCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.textField.PresentationTextField;

public class PresentationLogin extends Presentation implements IComponantListener {

    private final PresentationCheckBox presentationCheckBox;
    private final PresentationTextField presentationTextField;
    private final PresentationButton presentationButton;

    public PresentationLogin(String defaultPseudo, String textCheckBox, boolean defaultCheck) {

        presentationCheckBox = new PresentationCheckBox(textCheckBox, defaultCheck);

        presentationTextField = new PresentationTextField(defaultPseudo);

        presentationButton = new PresentationButton("Login");

        presentationCheckBox.addListener(this);

    }

    public PresentationCheckBox getPresentationCheckBox() {
        return presentationCheckBox;
    }

    public PresentationTextField getPresentationTextField() {
        return presentationTextField;
    }

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }


    public String getUsername() {
        return getPresentationTextField().getText();
    }

    public Boolean isNewUser() {
        return getPresentationCheckBox().isChecked();
    }

    @Override
    public void whenNotified(EComponantEvent typeEvent) {
        if (typeEvent == EComponantEvent.CHECK_BOX_CHECKED){
            if(isNewUser()){
                System.out.println("nouveau");
                getPresentationButton().setText("Sign up");
                getPresentationButton().setColor("#3F7");  // #3F7 = #33FF77
            }
            else{
                System.out.println("ancien");
                getPresentationButton().setText("Sign in");
                getPresentationButton().setColor(null);
            }
        }
    }
    

    

    



    



    
    
}
