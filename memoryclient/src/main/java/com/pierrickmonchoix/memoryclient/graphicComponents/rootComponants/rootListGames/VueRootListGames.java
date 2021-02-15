package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGames.VueListGames;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VueRootListGames extends HBox implements IVue {

    private final VueLabelHeroPseudo vueLabelHeroPseudo;

    private final VueListGames vueListGames;

    public VueRootListGames(PresentationRootListGames presentationRootListGames){

        vueLabelHeroPseudo = new VueLabelHeroPseudo(presentationRootListGames.getPresentationLabelHeroPseudo());

        vueListGames = new VueListGames(presentationRootListGames.getPresentationListGames());
        
        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(vueLabelHeroPseudo);
        getChildren().addAll(vueListGames);

        update();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}
