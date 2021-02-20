package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.VueButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.VueGamesProposals;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VueRootListGames extends HBox implements IVue {

    private final VueLabelHeroPseudo vueLabelHeroPseudo;
    private final VueGamesProposals vueGamesProposals;
    private final VueButtonCreateGame vueButtonCreateGame;

    public VueRootListGames(PresentationRootListGames presentationRootListGames){
        super(50);

        vueLabelHeroPseudo = (VueLabelHeroPseudo) presentationRootListGames.getPresentationLabelHeroPseudo().getVue();

        vueGamesProposals = (VueGamesProposals) presentationRootListGames.getPresentationGamesProposals().getVue();

        vueButtonCreateGame = (VueButtonCreateGame) presentationRootListGames.getPresentationButtonCreateGame()
                .getVue();

        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(vueLabelHeroPseudo);
        getChildren().addAll(vueButtonCreateGame);
        getChildren().addAll(vueGamesProposals);

        setPadding(new Insets(20,20,20,20));

        
        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // TODO Auto-generated method stub

    }
}
