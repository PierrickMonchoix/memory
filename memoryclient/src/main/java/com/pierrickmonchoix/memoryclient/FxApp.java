package com.pierrickmonchoix.memoryclient;

import com.pierrickmonchoix.memoryclient.graphicComponent.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponent.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponent.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.PresentationCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.VueCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.graphicComponent.login.PresentationLogin;
import com.pierrickmonchoix.memoryclient.graphicComponent.login.VueLogin;
import com.pierrickmonchoix.memoryclient.graphicComponent.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponent.rootLogin.VueRootLogin;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        PresentationLogin presentationLogin = new PresentationLogin("mon pseudooo", "first here?", false);
        VueLogin vueLogin = new VueLogin(presentationLogin);
        presentationLogin.setVue(vueLogin);
        ModelLogin modelLogin = new ModelLogin(presentationLogin);

        

        primaryStage.setScene(new Scene(vueLogin, 300, 250));

        primaryStage.show();

    }


}