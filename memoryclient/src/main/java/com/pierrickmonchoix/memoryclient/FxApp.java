package com.pierrickmonchoix.memoryclient;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.RootManager;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.ModelRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.PresentationRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.VueRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.ModelRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.VueRootLogin;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * C'est la classe qui lance le client JavaFX. mvn clean javafx:run pour run
 * cette classe
 */
public class FxApp extends Application {

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

        primaryStage.setTitle("Memory");

        WebsocketClientHelper.initialize();

        RootManager.initialize(primaryStage);

    }

}