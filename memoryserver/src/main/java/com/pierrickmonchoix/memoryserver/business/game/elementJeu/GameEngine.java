package com.pierrickmonchoix.memoryserver.business.game.elementJeu;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.Player;
import com.pierrickmonchoix.memoryserver.business.game.Game;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.AskDrawFirstCard;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.AskDrawSecondCard;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.CheckPairOrNot;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.EtatJeu;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.WaitDrawFirstCard;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.WaitDrawSecondCard;

public class GameEngine {

    private static Logger logger = Logger.getLogger(GameEngine.class.getName());
    private final Game game;

    private EtatJeu etatJeu;

    private final AskDrawFirstCard askDrawFirstCard;
    private final WaitDrawFirstCard waitDrawFirstCard;
    private final AskDrawSecondCard askDrawSecondCard;
    private final WaitDrawSecondCard waitDrawSecondCard;
    private final CheckPairOrNot checkPairOrNot;

    private Card firstCard;
    private Card secondCard;

    /**
     * joueur actuel
     */
    private Player player;

    public void changeEtatJeuTo(EtatJeu nextEtatJeu) {
        etatJeu = nextEtatJeu;
    }

    private List<Player> getListPlayers() {
        return game.getListPlayers();
    }

    private int getIdListPlayer() {
        int i = 0;
        for (Player p : getListPlayers()) {
            if (player.equals(p)) {
                return i;
            }
            i++;
        }
        logger.warning("getIdListPlayer error");
        return -1;
    }

    public void changePlayer() {
        int idPlayer = getIdListPlayer();
        if (idPlayer < game.getMaxPlayer() - 1) {
            player = getListPlayers().get(idPlayer + 1);
        } else {
            player = getListPlayers().get(0);
        }
    }

    public GameEngine(Game game) {
        this.game = game;
        this.askDrawFirstCard = new AskDrawFirstCard(this);
        this.waitDrawFirstCard = new WaitDrawFirstCard(this);
        this.askDrawSecondCard = new AskDrawSecondCard(this);
        this.waitDrawSecondCard = new WaitDrawSecondCard(this);
        this.checkPairOrNot = new CheckPairOrNot(this);

        player = game.getListPlayers().get(0);
    }

    public AskDrawFirstCard getAskDrawFirstCard() {
        return askDrawFirstCard;
    }

    public WaitDrawFirstCard getWaitDrawFirstCard() {
        return waitDrawFirstCard;
    }

    public AskDrawSecondCard getAskDrawSecondCard() {
        return askDrawSecondCard;
    }

    public WaitDrawSecondCard getWaitDrawSecondCard() {
        return waitDrawSecondCard;
    }

    public CheckPairOrNot getCheckPairOrNot() {
        return checkPairOrNot;
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }

    public boolean isPeerDrawn(){
        return firstCard.getTypeCarte() == secondCard.getTypeCarte();
    }

    public Board getBoard() {
        return game.getBoard();
    }

    public void startEtatActuel(){
        etatJeu.start();
    }

}
