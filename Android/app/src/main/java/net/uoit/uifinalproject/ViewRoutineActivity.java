package net.uoit.uifinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        setContentView(R.layout.activity_view_routine);
        newExerciseConfig();
        heatmapStart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar_default, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile_option:
                Intent profile_intent = new Intent(this, EditProfile.class);
                startActivity(profile_intent);
                return true;
            case R.id.meals_option:
                Intent meals_intent = new Intent(this, Food_Selection.class);
                startActivity(meals_intent);
                return true;
            case R.id.calender_option:
                Intent calendar_intent = new Intent(this, Calendar.class);
                startActivity(calendar_intent);
                return true;
            case R.id.home_big_option:
                Intent workouts_intent = new Intent(this, home.class);
                //startActivity(workouts_intent);
                finish();
                return true;
            case R.id.logout_option:
                Intent login_intent = new Intent(this, LoginActivity.class);
                startActivity(login_intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void heatmapStart() {
        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.haet_boi_FAB);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent heat_intent = new Intent(ViewRoutineActivity.this, HeatyBoi.class);
                startActivity(heat_intent);
            }
        });

        Button log_button = findViewById(R.id.log_button);
        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
