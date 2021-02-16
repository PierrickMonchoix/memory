package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGames.VueListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.VueGamesProposals;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VueRootListGames extends HBox implements IVue {

    private final VueLabelHeroPseudo vueLabelHeroPseudo;
    private final VueGamesProposals vueGamesProposals;

    public VueRootListGames(PresentationRootListGames presentationRootListGames){

        vueLabelHeroPseudo = new VueLabelHeroPseudo(presentationRootListGames.getPresentationLabelHeroPseudo());
        vueGamesProposals = new VueGamesProposals(presentationRootListGames.getPresentationGamesProposals());
        
        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(vueLabelHeroPseudo);
        getChildren().addAll(vueGamesProposals);

        setPadding(new Insets(20,20,20,20));

        
        update();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}
