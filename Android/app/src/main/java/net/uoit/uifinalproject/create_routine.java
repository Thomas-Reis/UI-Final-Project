package net.uoit.uifinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class create_routine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_routine);

        createConfig();
    }

    void createConfig(){
        final EditText nam = findViewById(R.id.nme_entry);
        Button cfm_btn = findViewById(R.id.crte_btn);

        cfm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("ROUTINE_NAME", nam.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
