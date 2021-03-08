package com.pierrickmonchoix.memoryclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Context;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.pierrickmonchoix.memoryclient.graphicComponent2.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.RootManager;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.PresentationImage;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.VueImage;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board.PresentationBoard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board.VueBoard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.PresentationCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.VueCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.ModelRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.VueRootLogin;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;

import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContextHelper.setContext(this);

        setContentView(R.layout.activity_main);

        WebsocketClientHelper.initialize();






        Button button = new Button(this);

        LinearLayout linearLayout = findViewById(R.id.monlinear);

        RootManager.getInstance().initialize(linearLayout);
/*

        PresentationCard presentationCard = new PresentationCard("/cinq.png",0,0,true);
        VueCard vueCard = new VueCard(presentationCard);
        presentationCard.setVue(vueCard);

        PresentationBoard presentationBoard = new PresentationBoard();
        VueBoard vueBoard = new VueBoard(presentationBoard);
        presentationBoard.setVue(vueBoard);

        presentationBoard.addCard("/cinq.png",0,0,true);

        presentationBoard.updateVue();

        */

        /*
        RelativeLayout relativeLayout = new RelativeLayout(this);

        PresentationCard presentationCard = new PresentationCard("/cinq.png",0,0,true);
        VueCard vueCard = new VueCard(presentationCard);
        presentationCard.setVue(vueCard);

        int x = 0;
        int y = 0;

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200,200);

        int trueX = 250*x;
        int trueY = 250*y;
        params.setMargins(trueX, trueY, 0, 0);

        vueCard.setLayoutParams(params);

        // on ne met pas reavlead ni pathCard car ne concernet pas palcement / delete /create


        Log.i("rebuildVues" , "add card to coord : " + Integer.toString(x) + " " + Integer.toString(y) );

        relativeLayout.addView(vueCard);  // x = column , y = row




        linearLayout.addView(relativeLayout);



         */














/*
        PresentationRootLogin presentationRootLogin = new PresentationRootLogin("mon pseudo", "first here?", true);
        VueRootLogin vueRootLogin = new VueRootLogin(presentationRootLogin);
        presentationRootLogin.setVue(vueRootLogin);

        new ModelRootLogin(presentationRootLogin);



        linearLayout.addView(vueRootLogin);


 */
       // linearLayout.removeView(vueRootLogin);   on poura faire ca pour rootmanager
       // linearLayout.addView(button);


        Log.i("tag","helllooo");

       // createWebSocketClient();
       // webSocketClient.send("hello from android");

    }
}