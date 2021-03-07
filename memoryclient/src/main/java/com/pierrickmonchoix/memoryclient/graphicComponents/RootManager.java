package com.pierrickmonchoix.memoryclient.graphicComponents;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootGame.ModelRootGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootGame.PresentationRootGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootGame.VueRootGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.ModelRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.PresentationRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.VueRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.ModelRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.VueRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootWinner.ModeleRootWinner;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootWinner.PresentationRootWinner;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootWinner.VueRootWinner;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RootManager implements IWebsocketListener {
    private Scene scene;
    private Stage stage;

    private PresentationRootLogin presentationRootLogin;
    private VueRootLogin vueRootLogin;
    private ModelRootLogin modelRootLogin;

    private PresentationRootListGames presentationRootListGames;
    private VueRootListGames vueRootListGames;
    private ModelRootListGames modelRootListGames;

    private PresentationRootGame presentationRootGame;
    private VueRootGame vueRootGame;
    private ModelRootGame modelRootGame;

    private PresentationRootWinner presentationRootWinner;
    private VueRootWinner vueRootWinner;
    private ModeleRootWinner modeleRootWinner;

    private Parent actualVueRoot;

    private static Logger logger = Logger.getLogger(RootManager.class.getName());

    private static RootManager instance;

    public static RootManager getInstance(){
        if(instance == null){
            instance = new RootManager();
        }
        return instance;
    }

    private RootManager(){
        // singleton => private
    }

    public void initialize(Stage _stage) {
        logger.info("inititalisation de root manager");

        stage = _stage;

        presentationRootLogin = new PresentationRootLogin("bernard", "first co?", false);
        vueRootLogin = new VueRootLogin(presentationRootLogin);
        presentationRootLogin.setVue(vueRootLogin);

        presentationRootListGames = new PresentationRootListGames();
        vueRootListGames = new VueRootListGames(presentationRootListGames);
        presentationRootListGames.setVue(vueRootListGames);

        presentationRootGame = new PresentationRootGame();
        vueRootGame = new VueRootGame(presentationRootGame);
        presentationRootGame.setVue(vueRootGame);

        presentationRootWinner = new PresentationRootWinner();
        vueRootWinner = new VueRootWinner(presentationRootWinner);
        presentationRootWinner.setVue(vueRootGame);

        // il faut bien que toutes les vues et presentations soient fiates avant les
        // differents mdoelses
        modelRootLogin = new ModelRootLogin(presentationRootLogin);
        modelRootListGames = new ModelRootListGames(presentationRootListGames);
        modelRootGame = new ModelRootGame(presentationRootGame);
        modeleRootWinner = new ModeleRootWinner(presentationRootWinner);

        actualVueRoot = vueRootLogin;
        scene = new Scene(actualVueRoot, 1200, 800);

        listenWebsocketHelper();

        update();

    }

    @Override
    public void listenWebsocketHelper() {
        WebsocketClientHelper.addListener(this);

    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        logger.info("j'ai recu le msg du ws");
        if(websocketMessage.getType() == EMessageType.DRAW_FIRST_CARD){
            logger.info("je set la vue rootGame");
            setVueRoot(vueRootGame);
        }
        else if(websocketMessage.getType() == EMessageType.WINNER){
            logger.info("je set la vue rootWinner");
            setVueRoot(vueRootWinner);
        }
    }

    private void update() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                scene.setRoot(actualVueRoot);
                stage.setScene(scene);
                stage.show();
            }
        });

    }

    private void setVueRoot(Parent vueRoot) {
        actualVueRoot = vueRoot;
        update();
    }


    public void setVueRootListGames() {
        setVueRoot(vueRootListGames);
    }

    public void setHeroPseudo(String pseudoHero) { // pour le root listes parties
        modelRootListGames.setPseudoLabelOfHero(pseudoHero);
    }





    
}
