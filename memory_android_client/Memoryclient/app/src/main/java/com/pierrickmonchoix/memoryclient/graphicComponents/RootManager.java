package com.pierrickmonchoix.memoryclient.graphicComponents;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.ContextHelper;
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


public class RootManager implements IWebsocketListener {

    private LinearLayout appLayout;


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

    private ViewGroup actualVueRoot;

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

    public void launchOn(LinearLayout appLayout) {
        logger.info("inititalisation de root manager");

        this.appLayout = appLayout;



        presentationRootLogin = new PresentationRootLogin("@mickaelbaron", "first co?", false);
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


        // il faut bien que toutes les vues et presentations soient fiates avant les
        // differents mdoelses
        modelRootLogin = new ModelRootLogin(presentationRootLogin);


        actualVueRoot = vueRootLogin;

        listenWebsocketHelper();

        update();

    }

    @Override
    public void listenWebsocketHelper() {
        WebsocketClientHelper.getInstance().addListener(this);
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {

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
        Handler mainHandler = new Handler(ContextHelper.getContext().getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                appLayout.removeAllViews();
                appLayout.addView(actualVueRoot);
            }
        };
        mainHandler.post(myRunnable);

    }

    private void setVueRoot(ViewGroup vueRoot) {
        actualVueRoot = vueRoot;
        update();
    }


    public void setVueRootListGames() {
        setVueRoot(vueRootListGames);
    }

    public void setHeroPseudoOnListGames(String pseudoHero) { // pour le root listes parties
        modelRootListGames.setPseudoLabelOfHero(pseudoHero);
    }






}
