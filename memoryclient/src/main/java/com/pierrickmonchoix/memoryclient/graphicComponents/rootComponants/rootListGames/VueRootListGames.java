package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.VueButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.VueGamesProposals;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VueRootListGames extends HBox implements IVue {

    private final VueLabelHeroPseudo vueLabelHeroPseudo;
    private final VueGamesProposals vueGamesProposals;
    private final VueButtonCreateGame vueButtonCreateGame;

    public VueRootListGames(PresentationRootListGames presentationRootListGames){
        super(50);

        vueLabelHeroPseudo = new VueLabelHeroPseudo(presentationRootListGames.getPresentationLabelHeroPseudo());
        presentationRootListGames.getPresentationLabelHeroPseudo().setVue(vueLabelHeroPseudo);
        vueGamesProposals = new VueGamesProposals(presentationRootListGames.getPresentationGamesProposals());
        presentationRootListGames.getPresentationGamesProposals().setVue(vueGamesProposals);
        vueButtonCreateGame = new VueButtonCreateGame(presentationRootListGames.getPresentationButtonCreateGame());
        presentationRootListGames.getPresentationButtonCreateGame().setVue(vueButtonCreateGame);

        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(vueLabelHeroPseudo);
        getChildren().addAll(vueButtonCreateGame);
        getChildren().addAll(vueGamesProposals);

        setPadding(new Insets(20,20,20,20));

        
        update();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}
