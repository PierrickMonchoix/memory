package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.ModelGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.VueGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameManagerForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.ShownGameForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;

/**
 * Liste des parties proposées
 * 
 * Architecture:
 * rootListGames > listGamesProposals
 */
public class PresentationGamesProposals extends Presentation {

    private static Logger logger = Logger.getLogger(PresentationGamesProposals.class.getName());

    private final List<PresentationGameProposal> listPresentationsGameProposal;

    public PresentationGamesProposals() {
        listPresentationsGameProposal = new ArrayList<PresentationGameProposal>();

    }

    public void setUpAll(GameManagerForJson gameManagerForJson) {
    
        listPresentationsGameProposal.clear(); // clear la liste des presentations

        List<ShownGameForJson> listGameManagerForJsons = gameManagerForJson.listJsonGames;
        for (ShownGameForJson shownGameForJson : listGameManagerForJsons) {
            if (!shownGameForJson.started) {

                String numberPlayer = shownGameForJson.numberPlayer + "/" + shownGameForJson.maxPlayer;
                String pseudoHost = shownGameForJson.pseudoHost;

                PresentationGameProposal presentationGameProposal = new PresentationGameProposal( pseudoHost, numberPlayer);    
                VueGameProposal vueGameProposal = new VueGameProposal(presentationGameProposal);
                presentationGameProposal.setVue(vueGameProposal);

                listPresentationsGameProposal.add(presentationGameProposal);

                new ModelGameProposal(presentationGameProposal);

                // si on est dans une partie (en train de jouer OU NON (inscrit) )
                boolean imInGame = imInGame(gameManagerForJson);
                presentationGameProposal.setAnableButton( ! imInGame );
            }
        }
        

        updateVue();  // car changement de position/ create/delete
    }

    private boolean imInGame(GameManagerForJson gameManagerForJson){
        String monPseudo = WebsocketClientHelper.getInstance().getPseudo();
        List<ShownGameForJson> listShownGameForJsons = gameManagerForJson.listJsonGames;
        for (ShownGameForJson shownGameForJson : listShownGameForJsons) {
            List<String> listJoueursInGame = shownGameForJson.listPlayer;
            for (String pseudoInGame : listJoueursInGame) {
                if(pseudoInGame.equals(monPseudo)){
                    logger.info("je suis en jeu");
                    return true;
                }
            }
        }
        logger.info("je ne suis PAS en jeu");
        return false;
    }

    public List<PresentationGameProposal> getListPresentationsGameProposal() {
        return listPresentationsGameProposal;
    }

}
