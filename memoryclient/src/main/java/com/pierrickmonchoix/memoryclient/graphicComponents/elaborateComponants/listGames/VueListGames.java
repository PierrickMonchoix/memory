package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.PresentationLoginResult;

import javafx.scene.layout.VBox;

public class VueListGames extends VBox implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueListGames(PresentationListGames presentationListGames) {

        vueTextOutput = new VueTextOutput(presentationListGames.getPresentationTextOutput());
        presentationListGames.getPresentationTextOutput().setVue(vueTextOutput);

        getChildren().addAll(vueTextOutput);

        update();
    }

    @Override
    public void update() {
        vueTextOutput.update();
    }

}