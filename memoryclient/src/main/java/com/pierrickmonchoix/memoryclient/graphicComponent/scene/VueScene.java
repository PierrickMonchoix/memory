package com.pierrickmonchoix.memoryclient.graphicComponent.scene;

import com.pierrickmonchoix.memoryclient.graphicComponent.IVue;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class VueScene extends Scene implements IVue {

    Parent root;

    PresentationScene presentationScene;

    public VueScene(PresentationScene presentationScene) {
        super(new VBox(), 300, 250);
        this.presentationScene = presentationScene;
        //pas d'update ici, il faut d'abord que presentationScene.mainoresentation soit set!
    }

    @Override
    public void update() {
        root = (Parent)presentationScene.getMainPresentation().getVue();
        setRoot(root);
    }

   
}
