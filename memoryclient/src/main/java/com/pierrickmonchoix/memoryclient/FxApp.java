package com.pierrickmonchoix.memoryclient;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




/**
 * mvn clean javafx:run pour run cette classe
 */
 
public class FxApp extends Application {

    //private static Logger logger = Logger.getLogger(FxApp.class);

    WebsocketClient clientWs;

    public static void main() {
        
        launch();
   
    }
    
    @Override
    public void start(Stage primaryStage) {

        BasicConfigurator.configure();

        System.out.println("starting JFX ...");

        String nomInField = "samuel";

        


        primaryStage.setTitle("Hello World!");

        Button btnConnexion = new Button();
        btnConnexion.setText("Connexion as " + nomInField);
        btnConnexion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("appui connexion");
                clientWs = WebsocketClient.getInstance(nomInField);
            }
        });

        Button btnMessage = new Button();
        btnMessage.setText("Send message");
        btnMessage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("appui message");
                clientWs.sendMessage();
            }
        });

        
        VBox root = new VBox();
        root.getChildren().add(btnConnexion);
        root.getChildren().add(btnMessage);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}