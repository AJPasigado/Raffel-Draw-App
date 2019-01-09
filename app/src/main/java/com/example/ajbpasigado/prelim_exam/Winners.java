package com.example.ajbpasigado.prelim_exam;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Winners extends AppCompatActivity {
    public static final String MY_PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String current = prefs.getString("current", "None");
        String prev = prefs.getString("previous", "None");

        TextView cur = findViewById(R.id.tv_current);
        cur.setText(current);

        TextView pre = findViewById(R.id.tv_prev);
        pre.setText(prev);
    }
}
