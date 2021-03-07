package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.EButtonColorForView;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox.PresentationCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox.VueCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField.PresentationTextField;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField.VueTextField;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;

/**
 * Le login doit avoir un bouton vert si son checkbox est coché ("je suis
 * nouveau") : SignUp et blanc sinon : SignIn Pour l'instant, aucun mot de passe
 * n'est demandé
 * 
 */
public class PresentationLogin extends PresentationNotifier implements IChildenListener {

    private final PresentationCheckBox presentationCheckBox;
    private final PresentationTextField presentationTextField;
    private final PresentationButton presentationButton;

    private static Logger logger = Logger.getLogger(PresentationLogin.class.getName());

    public PresentationLogin(String defaultPseudo, String textCheckBox, boolean defaultCheck) {
        super(EChildEvent.ASK_FOR_LOGIN); // cette presentation peut demander au parent (model ici) un login

        presentationCheckBox = new PresentationCheckBox(textCheckBox, defaultCheck);
        VueCheckBox vueCheckBox = new VueCheckBox(presentationCheckBox);
        presentationCheckBox.setVue(vueCheckBox);

        presentationTextField = new PresentationTextField(defaultPseudo);
        VueTextField vueTextField = new VueTextField(presentationTextField);
        presentationTextField.setVue(vueTextField);

        presentationButton = new PresentationButton("");
        VueButton vueButton = new VueButton(presentationButton);
        presentationButton.setVue(vueButton);

        // OBLIGATOIRE apres deblaration des enfants ssi IChildenListener
        listenAllChildren();

        //rare
        updateFromChildren();
    }

    // OVERIDES

    @Override
    public void listenAllChildren() {
        presentationCheckBox.attributeParentListener(this);
        presentationButton.attributeParentListener(this);
    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        switch (typeEvent) {
            case CHECK_BOX_CHECKED:
                updateFromChildren();
                break;
            case BUTTON_PRESSED:
                notifyParent();  // le model ici
                break;
            default:
                logger.warning("mes enfants ne m'as pas bien notifié");
                break;
        }

    }

    // GETTERS des presentations for vue

    public PresentationCheckBox getPresentationCheckBox() {
        return presentationCheckBox;
    }

    public PresentationTextField getPresentationTextField() {
        return presentationTextField;
    }

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }

    // GETTER SETTER from childrens

    public String getUsername() {
        return presentationTextField.getText();
    }

    public Boolean isNewUser() {
        return presentationCheckBox.isChecked();
    }

    // FROM CHILDREN
    // ASSEZ RARE: ici le bouton doit changer de couleur si checkbox est checked
    // i.e les enfants dépendent des enfants
    public void updateFromChildren() {
        if (isNewUser()) {
            System.out.println("nouveau");
            getPresentationButton().setUpText("Sign up");
            getPresentationButton().setUpColor(EButtonColorForView.VERT);
        } else {
            System.out.println("ancien");
            getPresentationButton().setUpText("Sign in");
            getPresentationButton().setUpColor(null);
        }
    }

}
