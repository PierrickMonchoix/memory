package com.pierrickmonchoix.memoryclient;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




/**
 * mvn clean javafx:run pour run cette classe
 */
 
public class FxApp extends Application {

    private static Logger logger = Logger.getLogger(FxApp.class);

    TestClientWebSocketTyrus clientWs;

    public static void main() {
        
        launch();
   
    }
    
    @Override
    public void start(Stage primaryStage) {
        logger.info("starting JFX ...");
        


        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Get REST");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                logger.info("appui");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}