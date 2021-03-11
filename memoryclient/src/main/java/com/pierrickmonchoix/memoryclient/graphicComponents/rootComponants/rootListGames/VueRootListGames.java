package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.createGame.VueCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.VueGamesProposals;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VueRootListGames extends HBox implements IVue {

    private final VueLabelHeroPseudo vueLabelHeroPseudo;
    private final VueGamesProposals vueGamesProposals;
    private final VueCreateGame vueCreateGame;

    public VueRootListGames(PresentationRootListGames presentationRootListGames){
        super(100);

        vueLabelHeroPseudo = (VueLabelHeroPseudo) presentationRootListGames.getPresentationLabelHeroPseudo().getVue();

        vueGamesProposals = (VueGamesProposals) presentationRootListGames.getPresentationGamesProposals().getVue();

        vueCreateGame = (VueCreateGame) presentationRootListGames.getPresentationCreateGame()
                .getVue();

        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(vueLabelHeroPseudo);
        getChildren().addAll(vueCreateGame);
        getChildren().addAll(vueGamesProposals);

        setPadding(new Insets(20,20,20,20));

        
        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        
    }
}
