package com.pierrickmonchoix.memoryclient;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.ModelRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.PresentationRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.VueRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.ModelRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.VueRootLogin;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketClient.WebsocketClient;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * C'est la classe qui lance le client JavaFX.
 *  mvn clean javafx:run pour run cette classe
 */
public class FxApp extends Application {

    private static WebsocketClient websocketClient;

    private static Scene scene;

    private static PresentationRootLogin presentationRootLogin;
    private static VueRootLogin vueRootLogin;
    private static ModelRootLogin modelRootLogin;

    private static PresentationRootListGames presentationRootListGames;
    private static VueRootListGames vueRootListGames;
    private static ModelRootListGames modelRootListGames;

    private static Stage monPrimaryStage;



    private static Logger logger = Logger.getLogger(FxApp.class.getName());
    // private static Logger logger = Logger.getLogger(FxApp.class);

   // WebsocketClient clientWs;

    public static void main() {

        launch();

    }

    @Override
    public void start(Stage primaryStage) {
        monPrimaryStage = primaryStage;

        System.out.println("starting JFX ...");

        // long si ne marche pas
        /*
         * clientWs = WebsocketClient.getInstance(nomInField); clientWs.sendMessage();
         */

/*         clientWs = WebsocketClient.getInstance(nomInField); 
        clientWs.sendMessage(); */

        primaryStage.setTitle("Memory");

  /*       PresentationRootLogin presentationRootLogin = new PresentationRootLogin("mon pseudo", "first here?", true);
        VueRootLogin vueRootLogin = new VueRootLogin(presentationRootLogin);
        presentationRootLogin.setVue(vueRootLogin); */

/*         PresentationLogin presentationLogin = new PresentationLogin("mon pseudooo", "first heree?", false);
        VueLogin vueLogin = new VueLogin(presentationLogin);
        presentationLogin.setVue(vueLogin);
        ModelLogin modelLogin = new ModelLogin(presentationLogin);

        TextField text = new TextField("bonjour");
        text.setEditable(false); */

        WebsocketClientHelper.initialize();

        presentationRootLogin = new PresentationRootLogin("bernard", "first co?", true);
        vueRootLogin = new VueRootLogin(presentationRootLogin);
        presentationRootLogin.setVue(vueRootLogin);
        modelRootLogin = new ModelRootLogin(presentationRootLogin);

        presentationRootListGames = new PresentationRootListGames();
        vueRootListGames = new VueRootListGames(presentationRootListGames);
        presentationRootListGames.setVue(vueRootListGames);
        modelRootListGames = new ModelRootListGames(presentationRootListGames);

        scene = new Scene(vueRootLogin, 800, 500);

        primaryStage.setScene(scene);



        
        primaryStage.show();

    }


    public static void setLisGamesVue(){
        scene.setRoot((Parent)vueRootListGames);
        monPrimaryStage.setScene(scene);
        monPrimaryStage.show();
    }

    public static void setHeroPseudo(String pseudoHero){
        modelRootListGames.setPseudoLabelOfHero(pseudoHero);
    }

}