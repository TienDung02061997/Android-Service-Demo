package com.example.androidserviceexample_playingmusicinbackground;

import android.content.Intent;
import android.media.MediaPlayer;


import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Start,Stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start= (Button) findViewById(R.id.buttonStart);
        Stop= (Button) findViewById(R.id.buttonStop);
        Start.setOnClickListener(this);
        Stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
             switch (v.getId()){
                 case R.id.buttonStart:
                     startService(new Intent(this,MyService.class));
                  break;

                  case R.id.buttonStop:
                     stopService(new Intent(this,MyService.class));
                      break;

                      default:
                          break;
             }
    }
}
