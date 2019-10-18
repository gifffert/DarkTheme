package ru.embersoft.darktheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private CardView switchCardView;
    private Switch switcher;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref= new SharedPref(this);
        if (sharedPref.loadDarkModeState()){
            setTheme(R.style.SettingsDark);
        } else {
            setTheme(R.style.SettingsLight);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchCardView = findViewById(R.id.switchCardView);
        switcher = findViewById(R.id.switcher);

        if (sharedPref.loadDarkModeState()){
            switcher.setChecked(true);
        }

        switcher.setClickable(false);

        switchCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!switcher.isChecked()){
                    switcher.setChecked(true);
                    sharedPref.setDarkModeState(true);
                    restartApp();
                } else {
                    switcher.setChecked(false);
                    sharedPref.setDarkModeState(false);
                    restartApp();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), EasyTransitionAnimation.class);
        startActivity(intent);
        finish();
    }

    private void restartApp() {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
        finish();
    }
}
