package com.example.stopwatch_applications;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnStop;
    ImageView icanchor, bgcircle;
    Animation round;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnStart);
        icanchor = findViewById(R.id.icanchor);
        bgcircle = findViewById(R.id.bgcircle);
        btnStop = findViewById(R.id.btnStop);
        timerHere = findViewById(R.id.timerHere);


        //create optional animation
        btnStop.setAlpha(0);

        // load animation
        round = AnimationUtils.loadAnimation(this, R.anim.roundinglone);

        // import fonts
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        //customize fonts
        btnstart.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passing animation
                icanchor.startAnimation(round);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();

                //start timer
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerHere.stop();
                icanchor.animate().alpha(0).translationY(-200).setDuration(100).start();
                bgcircle.animate().alpha(0).translationY(-200).setDuration(300).start();
            }
        });

    }
}
