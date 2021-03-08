package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.createGame.VueCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.VueGamesProposals;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueRootListGames extends LinearLayout implements IVue {

    private final VueLabelHeroPseudo vueLabelHeroPseudo;
    private final VueGamesProposals vueGamesProposals;
    private final VueCreateGame vueCreateGame;

    public VueRootListGames(PresentationRootListGames presentationRootListGames){
        super(ContextHelper.getContext());

        vueLabelHeroPseudo = (VueLabelHeroPseudo) presentationRootListGames.getPresentationLabelHeroPseudo().getVue();

        vueGamesProposals = (VueGamesProposals) presentationRootListGames.getPresentationGamesProposals().getVue();

        vueCreateGame = (VueCreateGame) presentationRootListGames.getPresentationCreateGame()
                .getVue();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 70, 0);



        addView(vueLabelHeroPseudo,layoutParams);
        addView(vueCreateGame,layoutParams);
        addView(vueGamesProposals,layoutParams);
        
        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // TODO Auto-generated method stub

    }
}
