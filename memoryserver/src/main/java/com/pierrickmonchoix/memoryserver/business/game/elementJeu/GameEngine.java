package com.pierrickmonchoix.memoryserver.business.game.elementJeu;

import java.util.List;
import java.util.logging.Logger;

import javax.xml.stream.events.EndDocument;

import com.pierrickmonchoix.memoryserver.business.Player;
import com.pierrickmonchoix.memoryserver.business.game.Game;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.AskDrawFirstCard;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.AskDrawSecondCard;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.CheckPairOrNot;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.EtatJeu;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.WaitDrawFirstCard;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.etatJeu.WaitDrawSecondCard;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class GameEngine {

    private static Logger logger = Logger.getLogger(GameEngine.class.getName());
    private final Game game;

    private EtatJeu etatJeu;

    private final AskDrawFirstCard askDrawFirstCard;
    private final WaitDrawFirstCard waitDrawFirstCard;
    private final AskDrawSecondCard askDrawSecondCard;
    private final WaitDrawSecondCard waitDrawSecondCard;
    private final CheckPairOrNot checkPairOrNot;

    public Game getGame() {
        return this.game;
    }

    public EtatJeu getEtatJeu() {
        return this.etatJeu;
    }

    public void setEtatJeu(EtatJeu etatJeu) {
        this.etatJeu = etatJeu;
    }



    private Card firstCard;
    private Card secondCard;

    /**
     * joueur actuel
     */
    private Player actualPlayer;

    private void changeEtatJeuTo(EtatJeu nextEtatJeu) {
        etatJeu = nextEtatJeu;
    }

    private List<Player> getListPlayers() {
        return game.getListPlayers();
    }

    private int getIdListPlayer() {
        int i = 0;
        for (Player p : getListPlayers()) {
            if (actualPlayer.equals(p)) {
                return i;
            }
            i++;
        }
        logger.warning("getIdListPlayer error");
        return -1;
    }

    private void changePlayer() {
        int idPlayer = getIdListPlayer();
        if (idPlayer < game.getMaxPlayer() - 1) {
            actualPlayer = getListPlayers().get(idPlayer + 1);
        } else {
            actualPlayer = getListPlayers().get(0);
        }
    }

    public GameEngine(Game game) {
        this.game = game;
        this.askDrawFirstCard = new AskDrawFirstCard(this);
        this.waitDrawFirstCard = new WaitDrawFirstCard(this);
        this.askDrawSecondCard = new AskDrawSecondCard(this);
        this.waitDrawSecondCard = new WaitDrawSecondCard(this);
        this.checkPairOrNot = new CheckPairOrNot(this);

        actualPlayer = game.getListPlayers().get(0);
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

    public boolean isPairDrawn() {
        return firstCard.getTypeCarte() == secondCard.getTypeCarte();
    }

    public void startEtatActuel() {
        etatJeu.start();
    }

    public Player getPlayer() {
        return actualPlayer;
    }

    public void setPlayer(Player player) {
        this.actualPlayer = player;
    }

    public boolean handlePairFoundAndSayIfEndGame() {
        if (firstCard.getTypeCarte() != secondCard.getTypeCarte()) {
            logger.warning("les cartes a supprimer ne sont pas identiques");
        }
        actualPlayer.incrementScrore();
        return game.getBoard().removeCardsAndSayIfEmpty(firstCard);
    }

    public void sendMessageToPlayer(EMessageType messageType, String contenu) {
        WebsocketMessage message = new WebsocketMessage();
        message.setPseudo(actualPlayer.getPseudo());
        message.setType(messageType);
        message.setContenu(contenu);
        WebsocketServerHelper.sendMessageToClient(actualPlayer.getPseudo(), message);
    }

    public void sendMessageToAllPlayer(EMessageType messageType, String contenu) {
        for (Player p : game.getListPlayers()) {
            WebsocketMessage message = new WebsocketMessage();
            message.setPseudo(p.getPseudo());
            message.setType(messageType);
            message.setContenu(contenu);
            WebsocketServerHelper.sendMessageToClient(p.getPseudo(), message);
        }
    }

    public void sendMessageToAllPlayerPairFound(){
        Coordinates firstCoordinates = firstCard.getCoordinates();
        Coordinates secondCoordinates = firstCard.getCoordinates();
        int pointsPlayer = actualPlayer.getPoints();
        String pseudoPlayer = actualPlayer.getPseudo();

        DataPlayerPointsCoordinates data = new DataPlayerPointsCoordinates(pseudoPlayer, pointsPlayer, firstCoordinates, secondCoordinates);
        
        String jsonData = data.toJson();

        sendMessageToAllPlayer(EMessageType.PAIR_FOUND , jsonData);

    }

    public void sendMessageToAllPlayerWhoWon() {
        sendMessageToAllPlayer(EMessageType.WINNER, actualPlayer.getPseudo());
    }

    public Player getWinner(){
        //balek egalités pour l'instant
        int maxPoint = 0;
        for (Player p : game.getListPlayers()) {
            maxPoint = p.getPoints();
        }
        for (Player p : game.getListPlayers()) {
            if(p.getPoints() == maxPoint){
                return p;
            }
        }
        return null;

    }

    public void startTurnOfNextPlayer(){
        changePlayer();
        etatJeu = askDrawFirstCard;
    }


    public Card getCardFromJsonCoordinates(String jsonCoordinates) {
        return game.getBoard().getCardFromJsonCoordinates(jsonCoordinates);
    }

    public final void changeAndStartEtatJeuTo(EtatJeu etatJeu){
        changeEtatJeuTo(etatJeu);
        startEtatActuel();
    }

}
