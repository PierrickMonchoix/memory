package com.pierrickmonchoix.memoryclient.graphicComponent.login;

import com.pierrickmonchoix.memoryclient.graphicComponent.EComponantEvent;
import com.pierrickmonchoix.memoryclient.graphicComponent.IComponantListener;

import java.util.ArrayList;
import java.util.List;

public class ModelLogin implements IComponantListener {

    private final PresentationLogin presentationLogin;

    private final List<ILoginListener> listListeners;

    public ModelLogin(PresentationLogin presentationLogin) {
        this.presentationLogin = presentationLogin;

        presentationLogin.getPresentationButton().addListener(this);

        listListeners = new ArrayList<ILoginListener>();

    }

    public String getUsername() {
        return presentationLogin.getUsername();
    }

    public Boolean isNewUser() {
        return presentationLogin.isNewUser();
    }


    @Override
    public void whenNotified(EComponantEvent typeEvent) {
        if(typeEvent == EComponantEvent.BUTTON_PRESSED){
            if( ! getUsername().equals("") ){   // si le nom d'utilisateur est bien remplit!
                notifyListenersOfSignInOrUp();
                
                if(isNewUser()){
                    System.out.println("Tentative de premiere connexion en tant que : " + getUsername()) ;
                }
                else{
                    System.out.println("Tentative de connexion habituelle en tant que : " + getUsername()) ;
                }

            }
        }
        
    }

    public void addListener(ILoginListener listener){
        listListeners.add(listener);
    }

    public void notifyListenersOfSignInOrUp(){
        for(ILoginListener listener : listListeners){
            listener.whenNotifiedOfSignInOrUp();
        }
    }


    

    



}
