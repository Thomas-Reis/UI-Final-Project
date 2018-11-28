package net.uoit.uifinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewRoutineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_routine);
        newExerciseConfig();
    }

    public void heatmapStart(View v) {
        Intent heat_intent = new Intent(ViewRoutineActivity.this, heatyBoi.class);
    }

    void newExerciseConfig(){
        addExercise("Bench Press");
        addExercise("Pull Up");
        addExercise("Overhead Press");
        addExercise("Inclined Bench Press");
        addExercise("Rope Push Down");
    }

    void addExercise(String name) {
        LinearLayout exercise_list = findViewById(R.id.exercise_list);
        final LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View exercise = inflater.inflate(R.layout.exercise_card_view, null);

        exercise.setPadding(0, 8, 0, 0);

        // Change the default name of the exercise and stop it from being
        TextView exercise_name = exercise.findViewById(R.id.exercise_name);
        exercise_name.setText(name);

        Button delete = exercise.findViewById(R.id.delete_btn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercise.setVisibility(View.GONE);
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View expand_items = exercise.findViewById(R.id.expand_items);
                ImageView breakln = exercise.findViewById(R.id.divider_line);
                ImageView arrow = exercise.findViewById(R.id.expand_arrow);

                if (expand_items.getVisibility() == View.GONE){
                    expand_items.setVisibility(View.VISIBLE);
                    breakln.setVisibility(View.VISIBLE);
                    arrow.setImageResource(android.R.drawable.arrow_up_float);
                }
                else {
                    expand_items.setVisibility(View.GONE);
                    breakln.setVisibility(View.GONE);
                    arrow.setImageResource(android.R.drawable.arrow_down_float);
                }
            }
        });
        exercise.setElevation(8);

        exercise_list.addView(exercise, exercise_list.getChildCount() - 1);
    }
}
