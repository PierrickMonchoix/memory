package com.pierrickmonchoix.memoryclient;

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
    public static void main() {
        System.out.println("######                 HEYYYE");
        launch();
        System.out.println("######                 HEYYY 2");  // ,e fait rien
    }
    
    @Override
    public void start(Stage primaryStage) {
        System.out.println("######                 HEYYY fx");  // work
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World' from client");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}