package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox.PresentationCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField.PresentationTextField;

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

    public void addButtonListener(IComponantListener listener){
        presentationButton.addListener(listener);
    }

    @Override
    public void whenNotifiedByComponant(EComponantBasicEvent typeEvent) {
        if (typeEvent == EComponantBasicEvent.CHECK_BOX_CHECKED){
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
