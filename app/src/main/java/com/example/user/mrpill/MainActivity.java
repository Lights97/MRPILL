package com.example.user.mrpill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void coughColdButton(View view) {
        Intent intent = new Intent (this, CoughColdQuiz.class);
        startActivity(intent);
    }

    public void oticOphthalmicButton(View view) {
        Intent intent = new Intent (this, OticOphthalmicQuiz.class);
        startActivity(intent);
    }

    public void painButton(View view) {
        Intent intent = new Intent (this, PainQuiz.class);
        startActivity(intent);
    }

    public void gastrointestinalButton(View view) {
        Intent intent = new Intent (this, GastrointestinalQuiz.class);
        startActivity(intent);
    }

    public void skinConditionsButton(View view) {
        Intent intent = new Intent (this, SkinConditionsQuiz.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
