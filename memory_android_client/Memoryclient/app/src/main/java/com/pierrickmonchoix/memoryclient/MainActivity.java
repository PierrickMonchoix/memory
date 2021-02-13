package com.pierrickmonchoix.memoryclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.graphicComponent.*;
import com.pierrickmonchoix.memoryclient.graphicComponent.rootLogin.PresentationRootLogin;
import com.pierrickmonchoix.memoryclient.graphicComponent.rootLogin.VueRootLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button button = new Button(this);

        LinearLayout linearLayout = findViewById(R.id.monlinear);


        PresentationRootLogin presentationRootLogin = new PresentationRootLogin("mon pseudo", "first here?", true);
        VueRootLogin vueRootLogin = new VueRootLogin(presentationRootLogin , this);
        presentationRootLogin.setVue(vueRootLogin);


        linearLayout.addView(vueRootLogin);

        Log.i("tag","helllooo");

    }
}