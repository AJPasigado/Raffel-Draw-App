package com.example.ajbpasigado.prelim_exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class Names extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        String[] names = getResources().getStringArray(R.array.names);

        TextView name = findViewById(R.id.tv_names);

        for (int i = names.length - 1; i > -1; i--){
            name.setText(name.getText().toString() + Integer.toString(i) + " : " + names[i] + "\n");
        }
    }
}
