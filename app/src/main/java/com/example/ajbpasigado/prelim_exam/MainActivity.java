package com.example.ajbpasigado.prelim_exam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String MY_PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startDraw();
    }

    public void showNames(View v){
        Intent intent = new Intent(this, Names.class);
        startActivity(intent);
    }

    public void showWinners(View v){
        Intent intent = new Intent(this, Winners.class);
        startActivity(intent);
    }

    public void startDraw(){
        final TextView first = findViewById(R.id.tv_first);
        final TextView second = findViewById(R.id.tv_second);
        final TextView third = findViewById(R.id.tv_third);
        final TextView winner = findViewById(R.id.tv_newWinner);


        CountDownTimer countDownTimer = new CountDownTimer(4000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random random = new Random();
                int choice = random.nextInt(10);

                if (millisUntilFinished == 3000){
                    first.setText(Integer.toString(choice));
                } else if (millisUntilFinished == 2000){
                    second.setText(Integer.toString(choice));
                } else  if (millisUntilFinished == 1000){
                    third.setText(Integer.toString(choice));
                }
            }

            @Override
            public void onFinish() {
                String[] names = getResources().getStringArray(R.array.names);
                winner.setText(names[Integer.parseInt(third.getText().toString()) + (Integer.parseInt(second.getText().toString()) * 10) + (Integer.parseInt(first.getText().toString()) * 100)]);
            }
        }.start();
    }

    public void draw(View v){
        startDraw();
    }

    public void claim(View v){
        final TextView winner = findViewById(R.id.tv_newWinner);

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor.putString("previous", prefs.getString("current", "None"));
        editor.putString("current", winner.getText().toString());
        editor.apply();
    }
}
