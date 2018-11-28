package net.uoit.uifinalproject;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HeatyBoi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heaty_boi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("UIFinalProject");
        setSupportActionBar(toolbar);
        goToExerciseConfig();
    }

    void goToExerciseConfig(){
        FloatingActionButton FAB = findViewById(R.id.exercise_FAB);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeatyBoi.this, ViewRoutineActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
