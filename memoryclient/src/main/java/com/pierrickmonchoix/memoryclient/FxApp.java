package com.pierrickmonchoix.memoryclient;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.PresentationLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.VueLogin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * mvn clean javafx:run pour run cette classe
 */

public class FxApp extends Application {

    // private static Logger logger = Logger.getLogger(FxApp.class);

    WebsocketClient clientWs;

    public static void main() {

        launch();

    }

    @Override
    public void start(Stage primaryStage) {

        System.out.println("starting JFX ...");

        String nomInField = "samuel";
        // long si ne marche pas
        /*
         * clientWs = WebsocketClient.getInstance(nomInField); clientWs.sendMessage();
         */

        primaryStage.setTitle("Memory");

  /*       PresentationRootLogin presentationRootLogin = new PresentationRootLogin("mon pseudo", "first here?", true);
        VueRootLogin vueRootLogin = new VueRootLogin(presentationRootLogin);
        presentationRootLogin.setVue(vueRootLogin); */

        PresentationLogin presentationLogin = new PresentationLogin("mon pseudooo", "first heree?", false);
        VueLogin vueLogin = new VueLogin(presentationLogin);
        presentationLogin.setVue(vueLogin);
        ModelLogin modelLogin = new ModelLogin(presentationLogin);


        

        primaryStage.setScene(new Scene(vueLogin, 300, 250));

        primaryStage.show();

    }


}