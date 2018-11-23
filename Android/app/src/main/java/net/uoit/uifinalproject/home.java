package net.uoit.uifinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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

    @Override
    protected void onActivityResult(int request_code, int result_code, Intent data){
        LinearLayout rou_list = findViewById(R.id.routine_list);
        if (request_code == 1){
            if(result_code == RESULT_CANCELED){
                return;
            }
            final LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            String name = data.getStringExtra("ROUTINE_NAME");

            final View routine = inflater.inflate(R.layout.routine_card, null);

            TextView name_field =  routine.findViewById(R.id.routine_name);

            name_field.setText(name);

            routine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View expand_items = routine.findViewById(R.id.expand_items);
                    ImageView arrow = routine.findViewById(R.id.expand_arrow);

                    if (expand_items.getVisibility() == View.GONE){
                        expand_items.setVisibility(View.VISIBLE);
                        arrow.setImageResource(android.R.drawable.arrow_up_float);
                    }
                    else {
                        expand_items.setVisibility(View.GONE);
                        arrow.setImageResource(android.R.drawable.arrow_down_float);
                    }
                }
            });

            rou_list.addView(routine, rou_list.getChildCount() - 1);
        }
    }
}
