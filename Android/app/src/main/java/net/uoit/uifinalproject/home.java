package net.uoit.uifinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newRoutineConfig();
        addRoutine("Arm Day");
        addRoutine("Leg Day");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar_homepage, menu);
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
            case R.id.calendar_big_option:
                Intent calendar_intent = new Intent(this, Calendar.class);
                startActivity(calendar_intent);
                return true;
            case R.id.logout_option:
                //Intent login_intent = new Intent(this, LoginActivity.class);
                //startActivity(login_intent);
                finish();
                return true;
            case R.id.qr_code_option:
                Intent qr_intent = new Intent(this, QRCode.class);
                startActivity(qr_intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void newRoutineConfig(){
        Button new_rou = findViewById(R.id.new_routine_btn);

        new_rou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_reg = new Intent(home.this, create_routine.class);
                startActivityForResult(get_reg, 1);
            }
        });
    }

    View addRoutine(String name){
        LinearLayout rou_list = findViewById(R.id.routine_list);
        final LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View routine = inflater.inflate(R.layout.routine_card, null);

        TextView name_field = routine.findViewById(R.id.routine_name);

        name_field.setText(name);

        routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View expand_items = routine.findViewById(R.id.expand_items);
                ImageView breakln = routine.findViewById(R.id.divider_line);
                ImageView arrow = routine.findViewById(R.id.expand_arrow);

                if (expand_items.getVisibility() == View.GONE) {
                    expand_items.setVisibility(View.VISIBLE);
                    breakln.setVisibility(View.VISIBLE);
                    arrow.setImageResource(android.R.drawable.arrow_up_float);
                } else {
                    expand_items.setVisibility(View.GONE);
                    breakln.setVisibility(View.GONE);
                    arrow.setImageResource(android.R.drawable.arrow_down_float);
                }
            }
        });

        routine.setPadding(0, 8, 0, 0);
        rou_list.addView(routine, rou_list.getChildCount() - 1);

        Button delete = routine.findViewById(R.id.delete_btn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routine.setVisibility(View.GONE);
            }
        });

        Button edit = routine.findViewById(R.id.edit_btn);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((TextView) routine.findViewById(R.id.routine_name)).setText("todo");
            }
        });

        name_field.setText(name);

        routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View expand_items = routine.findViewById(R.id.expand_items);
                ImageView breakln = routine.findViewById(R.id.divider_line);
                ImageView arrow = routine.findViewById(R.id.expand_arrow);

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
        routine.setElevation(8);

        return routine;
    }

    @Override
    protected void onActivityResult(int request_code, int result_code, Intent data){
        LinearLayout rou_list = findViewById(R.id.routine_list);
        if (request_code == 1){
            if(result_code == RESULT_CANCELED){
                return;
            }
            else {
                String name = data.getStringExtra("ROUTINE_NAME");
                View routine = addRoutine(name);
                rou_list.addView(routine, rou_list.getChildCount() - 1);
            }
        }
    }
}
