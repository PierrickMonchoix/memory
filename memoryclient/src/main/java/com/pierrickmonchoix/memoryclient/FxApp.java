package com.pierrickmonchoix.memoryclient;

import com.pierrickmonchoix.memoryclient.graphicComponents.RootManager;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * C'est la classe qui lance le client JavaFX. mvn clean javafx:run pour run
 * cette classe
 */
public class FxApp extends Application {

    public static void main() {

        launch();

    }

    @Override
    public void start(Stage primaryStage) {

        System.out.println("starting JFX ...");

        primaryStage.setTitle("Memory");

        RootManager.getInstance().launchOn(primaryStage);

    }

}
