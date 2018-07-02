package com.example.user.mrpill;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_ACTIVITY_FROM = "WhichActivity";

    public static final String EYE_UNLOCKED = "eyeUnlocked";
    public static final String PAIN_UNLOCKED = "painUnlocked";
    public static final String STOMACH_UNLOCKED = "stomachUnlocked";
    public static final String SKIN_UNLOCKED = "skinUnlocked";

    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile = "com.example.user.mrpill";

    public void coughColdButton(View view) {
        Intent intent = new Intent(this, CoughColdQuiz.class);
        startActivity(intent);
    }

    public void oticOphthalmicButton(View view) {
        Intent intent = new Intent(this, OticOphthalmicQuiz.class);
        startActivity(intent);
    }

    public void painButton(View view) {
        Intent intent = new Intent(this, PainQuiz.class);
        startActivity(intent);
    }

    public void gastrointestinalButton(View view) {
        Intent intent = new Intent(this, GastrointestinalQuiz.class);
        startActivity(intent);
    }

    public void skinConditionsButton(View view) {
        Intent intent = new Intent(this, SkinConditionsQuiz.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn_otic_ophthalmic, btn_pain, btn_gastrointestinal, btn_skin;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_otic_ophthalmic = (Button) findViewById(R.id.btn_oticOphthalmic);
        btn_otic_ophthalmic.setEnabled(false);
        btn_pain = (Button) findViewById(R.id.btn_pain);
        btn_pain.setEnabled(false);
        btn_gastrointestinal = (Button) findViewById(R.id.btn_gastrointestinal);
        btn_gastrointestinal.setEnabled(false);
        btn_skin = (Button) findViewById(R.id.btn_skinConditions);
        btn_skin.setEnabled(false);
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();

        // Restore preferences
        if (getIntent().getExtras() != null) {
            if (mPreferences.getString(EYE_UNLOCKED, null).equals("eye_unlocked")) {
                btn_otic_ophthalmic.setEnabled(true);
                Log.i("infoState0", "eye");
            }
            if (mPreferences.getString(PAIN_UNLOCKED, null).equals("pain_unlocked")) {
                btn_pain.setEnabled(true);
                Log.i("infoState1", "pain");
            }
            if (mPreferences.getString(STOMACH_UNLOCKED, null).equals("stomach_unlocked")) {
                btn_gastrointestinal.setEnabled(true);
                Log.i("infoState2", "stomach");
            }
            if (mPreferences.getString(SKIN_UNLOCKED, null).equals("skin_unlocked")) {
                btn_skin.setEnabled(true);
                Log.i("infoState3", "skin");
            }
        }

        if (getIntent().getExtras() != null) {
            String activityFrom = (String) getIntent().getStringExtra(TAG_ACTIVITY_FROM);
            Log.i("infoState4", activityFrom);
            if (activityFrom.equals("From cough cold")) {
                Log.i("infoState5", activityFrom);
                //btn_otic_ophthalmic.setEnabled(true);
                preferencesEditor.putString(EYE_UNLOCKED, "eye_unlocked").apply();
            } else if (activityFrom.equals("From eye")) {
                Log.i("infoState6", activityFrom);
                //btn_pain.setEnabled(true);
                preferencesEditor.putString(PAIN_UNLOCKED, "pain_unlocked").apply();
            } else if (activityFrom.equals("From pain")) {
                Log.i("infoState7", activityFrom);
                //btn_gastrointestinal.setEnabled(true);
                preferencesEditor.putString(STOMACH_UNLOCKED, "stomach_unlocked").apply();
            } else if (activityFrom.equals("From stomach")) {
                Log.i("infoState8", activityFrom);
                //btn_skin.setEnabled(true);
                preferencesEditor.putString(SKIN_UNLOCKED, "skin_unlocked").apply();
            } else {
                Log.i("infoState5", "hey");
            }
        }
    }

    /*Handles the onClick for the Reset button. Resets the corresponding buttons to the defaults, and clears the shared preferences*/
    public void reset(View view) {
        Button btn_otic_ophthalmic, btn_pain, btn_gastrointestinal, btn_skin;

        btn_otic_ophthalmic = (Button) findViewById(R.id.btn_oticOphthalmic);
        btn_otic_ophthalmic.setEnabled(false);
        btn_pain = (Button) findViewById(R.id.btn_pain);
        btn_pain.setEnabled(false);
        btn_gastrointestinal = (Button) findViewById(R.id.btn_gastrointestinal);
        btn_gastrointestinal.setEnabled(false);
        btn_skin = (Button) findViewById(R.id.btn_skinConditions);
        btn_skin.setEnabled(false);

        // Clear preferences
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }
}

