package net.uoit.uifinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar_alt, menu);
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
            case R.id.logout_option:
                Intent login_intent = new Intent(this, LoginActivity.class);
                startActivity(login_intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
