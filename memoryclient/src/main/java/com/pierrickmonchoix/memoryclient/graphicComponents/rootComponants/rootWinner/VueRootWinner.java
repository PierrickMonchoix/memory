package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootWinner;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner.VueWinner;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueRootWinner extends VBox implements IVue {

    private VueWinner vueWinner;


    public VueRootWinner(PresentationRootWinner presentationRootWinner) {

        vueWinner = (VueWinner) presentationRootWinner.getPresentationWinner().getVue();
        setAlignment(Pos.TOP_CENTER);


        

        getChildren().addAll(vueWinner);

        updateFromPresentation();
    }


    @Override
    public void updateFromPresentation() {
        // TODO Auto-generated method stub

    }


}
