package com.sarthak.hospitallocator;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sarthak.hospitallocator.activities.MainActivity;

public class ModeSelectionActivity extends AppCompatActivity {

    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);

        bt1 = findViewById(R.id.icare_button);
        bt2 = findViewById(R.id.ayush_button);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent();
                intent.setComponent(new ComponentName("com.webianks.exp.crimson", "com.webianks.exp.crimson.screens.MainActivity"));
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));


            }
        });
    }
}
