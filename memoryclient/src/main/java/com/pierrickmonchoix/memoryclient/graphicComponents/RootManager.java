package com.pierrickmonchoix.memoryclient.graphicComponents;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.ModelRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.PresentationRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames.VueRootListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.ModelRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.VueRootLogin;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RootManager {
    private static Scene scene;
    private static Stage stage;

    private static PresentationRootLogin presentationRootLogin;
    private static VueRootLogin vueRootLogin;
    private static ModelRootLogin modelRootLogin;

    private static PresentationRootListGames presentationRootListGames;
    private static VueRootListGames vueRootListGames;
    private static ModelRootListGames modelRootListGames;

    private static Parent actualVueRoot;

    private static Logger logger = Logger.getLogger(RootManager.class.getName());

    public static void initialize(Stage _stage){

        logger.info("inititalisation de root manager");
        
        stage = _stage;

        presentationRootLogin = new PresentationRootLogin("bernard", "first co?", true);
        vueRootLogin = new VueRootLogin(presentationRootLogin);
        presentationRootLogin.setVue(vueRootLogin);
        

        presentationRootListGames = new PresentationRootListGames();
        vueRootListGames = new VueRootListGames(presentationRootListGames);
        presentationRootListGames.setVue(vueRootListGames);


        // il faut bien que toutes les vues et presentations soient fiates avant les differents mdoelses
        modelRootLogin = new ModelRootLogin(presentationRootLogin);
        modelRootListGames = new ModelRootListGames(presentationRootListGames);


        actualVueRoot = vueRootLogin;
        scene = new Scene(actualVueRoot, 800, 500);
        update();
    }

    private static void update(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                scene.setRoot(actualVueRoot);
                stage.setScene(scene);
                stage.show();
            }
        });

    }

    private static void setVueRoot(Parent vueRoot){
        actualVueRoot = vueRoot;
        update();
    }

    public static void setVueRootListGames(){
        setVueRoot(vueRootListGames);
    }

    public static void setHeroPseudo(String pseudoHero){  // pour le root listes parties
        modelRootListGames.setPseudoLabelOfHero(pseudoHero);
    }

    
}
