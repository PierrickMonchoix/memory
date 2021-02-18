package com.pierrickmonchoix.memoryserver.business.game.gameEngine;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.GamesManager;
import com.pierrickmonchoix.memoryserver.business.Player;
import com.pierrickmonchoix.memoryserver.business.game.Game;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.Board;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte.Card;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte.Coordinates;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu.AskDrawFirstCard;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu.AskDrawSecondCard;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu.CheckPairOrNot;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu.EtatJeu;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu.WaitCardsSeen;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu.WaitDrawFirstCard;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.etatJeu.WaitDrawSecondCard;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;


public class GameEngine {
    private static Logger logger = Logger.getLogger(GameEngine.class.getName());

    private final Game game;

    private EtatJeu etatJeu;
    private AskDrawFirstCard askDrawFirstCard;
    private WaitDrawFirstCard waitDrawFirstCard;
    private AskDrawSecondCard askDrawSecondCard;
    private WaitDrawSecondCard waitDrawSecondCard;
    private CheckPairOrNot checkPairOrNot;
    private WaitCardsSeen waitCardsSeen;

    private Card firstCard;
    private Card secondCard;


    //CONSTRUCTOR ----------------------------------------------------------------------
    public GameEngine(Game game) {
        this.game = game;
    }

    //PRIVATE GETTER SETTER OF GAME ----------------------------------------------------------------------
    private List<Player> getListPlayers() {
        return game.getListPlayers();
    }
    private Player getActualPlayer(){
        return game.getActualPlayer();
    }
    private void setActualPlayer(Player player){
        game.setActualPlayer(player);
    }
    private void setWinner(Player winner){
        game.setWinner(winner);
    }
    private Player getWinner(){
        return game.getWinner();
    }
    private Board getBoard(){
        return game.getBoard();
    }

    //PUBLIC GETTERS SETTERS
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
    public WaitCardsSeen getWaitCardsSeen(){
        return waitCardsSeen;
    }

    // PUBLIC SEND MESSAGE TO PLAYERS
    public void sendMessageToAllPlayer(EMessageType messageType) {
        String jsonGame = game.toJson();
        for (Player p : getListPlayers()) {
            WebsocketMessage message = new WebsocketMessage();
            message.setPseudo(p.getPseudo());
            message.setType(messageType);
            message.setContenu(jsonGame);
            WebsocketServerHelper.sendMessageToClient(p.getPseudo(), message);
        }
    }

    //PUBLIC START GAME ENGINE
    public void start(){
        this.askDrawFirstCard = new AskDrawFirstCard(this);
        this.waitDrawFirstCard = new WaitDrawFirstCard(this);
        this.askDrawSecondCard = new AskDrawSecondCard(this);
        this.waitDrawSecondCard = new WaitDrawSecondCard(this);
        this.checkPairOrNot = new CheckPairOrNot(this);
        this.waitCardsSeen = new WaitCardsSeen(this);
        changeAndStartEtatJeuTo(askDrawFirstCard);
    }

    //PUBLIC CHANGE ETAT JEU
    public void changeAndStartEtatJeuTo(EtatJeu etatJeu) {
        this.etatJeu = etatJeu;
        startEtatJeu();
    }
    private void startEtatJeu(){
        this.etatJeu.start();
    }

    //PUBLIC CHANGE PLAYER
    public void changePlayer() {
        int idPlayer = getIdListPlayer();
        if (idPlayer < game.getMaxPlayer() - 1) {
            setActualPlayer( getListPlayers().get(idPlayer + 1) );
        } else {
            setActualPlayer( getListPlayers().get(0) );
        }
    }
    private int getIdListPlayer() {
        int i = 0;
        for (Player p : getListPlayers()) {
            if (getActualPlayer().equals(p)) {
                return i;
            }
            i++;
        }
        logger.warning("getIdListPlayer error");
        return -1;
    }


    //PUBLIC DRAW CARDS
    public void drawFirstCardOfJsonCoordinates(String jsonCoordinates){
        this.firstCard =  drawCardOfJsonCoordinates(jsonCoordinates);
    }
    public void drawSecondCardOfJsonCoordinates(String jsonCoordinates){
        this.secondCard =  drawCardOfJsonCoordinates(jsonCoordinates);
    }
    private Card drawCardOfJsonCoordinates(String jsonCoordinates){
        Coordinates coordinates = Coordinates.fromJson(jsonCoordinates);
        return drawCardOfCoordinates(coordinates);
    }
    private Card drawCardOfCoordinates(Coordinates coordinates){
        return getBoard().drawCardOfCoordinates(coordinates);
    }
    

    //PUBLIC IS PAIR DRWAN
    public boolean isPairDrawn() {
        return firstCard.getTypeCarte() == secondCard.getTypeCarte();
    }

    //PUBLIC UPDATE SCORES AND BOARD
    public void updateScoresAndBoard(){
        if(isPairDrawn()){
            incrementsPointsActualPlayer();
            removeRevealedCards();
            if(isBoardEmpty()){
                declareWinner();
            }
        }
        else{
            returnRevealedCards();
        }
    }
    private void incrementsPointsActualPlayer(){
        getActualPlayer().incrementPoints();
    }
    private void removeRevealedCards(){
        getBoard().removeRevealedCards();
    }
    private void returnRevealedCards(){
        getBoard().returnRevealedCards();
    }
    private boolean isBoardEmpty(){
        return getBoard().isEmpty();
    }
    private void declareWinner() {  // pas d'égalités pour l'instant
        int maxPoint = 0;
        for (Player p : game.getListPlayers()) {
            maxPoint = p.getPoints();
        }
        for (Player p : game.getListPlayers()) {
            if (p.getPoints() == maxPoint) {
                setWinner(p);
            }
        }
    }

    //PUBLIC IS WINNER ?
    public boolean isWinner(){
        return ( getWinner() == null );
    }

    //END GAME
    public void endGame(){
        GamesManager.getInstance().removeGame(this.game);
    }




}
