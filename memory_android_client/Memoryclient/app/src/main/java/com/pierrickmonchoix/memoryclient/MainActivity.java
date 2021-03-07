package com.pierrickmonchoix.memoryclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;


import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin.VueRootLogin;

import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class MainActivity extends AppCompatActivity {

    private WebSocketClient webSocketClient;



    private void createWebSocketClient() {
        URI uri;
        try {
            // Connect to local host
            uri = new URI("ws://192.168.1.41:8026/chatwebsocket/chat/mickaelbaron");
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                Log.i("WebSocket", "Session is starting");
                WebsocketMessage websocketMessage = new WebsocketMessage();
                websocketMessage.setContenu("yo from android");
                websocketMessage.setPseudo("android");
                websocketMessage.setType(12);
                Log.i("WebSocket", "Envoie from android: " + websocketMessage.toJson());
                webSocketClient.send(websocketMessage.toJson());
            }
            @Override
            public void onTextReceived(String s) {

                final String message = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Log.i("WebSocket", "Message received by android : " + s);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }



            @Override
            public void onBinaryReceived(byte[] data) {
            }
            @Override
            public void onPingReceived(byte[] data) {
            }
            @Override
            public void onPongReceived(byte[] data) {
            }
            @Override
            public void onException(Exception e) {
                System.out.println(e.getMessage());
            }
            @Override
            public void onCloseReceived() {
                Log.i("WebSocket", "Closed ");
                System.out.println("onCloseReceived");
            }
        };
        webSocketClient.setConnectTimeout(10000);
        webSocketClient.setReadTimeout(60000);
        webSocketClient.enableAutomaticReconnection(5000);
        webSocketClient.connect();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContextHelper.setContext(this);

        setContentView(R.layout.activity_main);




        Button button = new Button(this);

        LinearLayout linearLayout = findViewById(R.id.monlinear);


        PresentationRootLogin presentationRootLogin = new PresentationRootLogin("mon pseudo", "first here?", true);
        VueRootLogin vueRootLogin = new VueRootLogin(presentationRootLogin);
        presentationRootLogin.setVue(vueRootLogin);


        linearLayout.addView(vueRootLogin);



        Log.i("tag","helllooo");

       // createWebSocketClient();
       // webSocketClient.send("hello from android");

    }
}