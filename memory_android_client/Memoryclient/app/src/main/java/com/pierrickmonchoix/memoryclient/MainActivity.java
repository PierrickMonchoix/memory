package com.pierrickmonchoix.memoryclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;


import com.pierrickmonchoix.memoryclient.graphicComponents.RootManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContextHelper.setContext(this);

        setContentView(R.layout.activity_main);

        Button button = new Button(this);

        LinearLayout linearLayout = findViewById(R.id.monlinear);

        RootManager.getInstance().launchOn(linearLayout);
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