package com.example.user.mrpill;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Random;

public class CoughColdQuiz extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView cough_cold_quiz, label;
    CountDownTimer mCountDownTimer;
    ArrayList <Button> buttonList = new ArrayList();

    private CoughColdQuestion question = new CoughColdQuestion();

    private String answer;
    private int questionLength = question.questions.length;
    private int questionNumber = 0;
    public int counter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cough_cold_quiz);

        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        buttonList.add(btn_one);
        buttonList.add(btn_two);
        buttonList.add(btn_three);
        buttonList.add(btn_four);

        cough_cold_quiz = (TextView)findViewById(R.id.cough_cold_quiz);

        NextQuestion(questionNumber++);
        label = (TextView) findViewById(R.id.timer);
        mCountDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                label.setText("Timer:" + String.valueOf(counter));
                counter--;
            }
            public void onFinish() {
                if (counter == 0){
                    label.setText("Timer:0");
                    GameOver();
                }
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    btn_one.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_one.getBackground().clearColorFilter();
                        }
                    }, 200);
                    Toast.makeText(CoughColdQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                        label = (TextView) findViewById(R.id.timer);
                        ResetTime();
                    }else if (questionNumber == questionLength){
                        if (mCountDownTimer != null) {
                            mCountDownTimer.cancel();
                        }
                        Won();
                    }
                }else{
                    btn_one.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_one.getBackground().clearColorFilter();
                        }
                    }, 200);
                    answer = question.getCorrectAnswer(questionNumber-1);
                    for (final Button button : buttonList){
                        if(button.getText().equals(answer)) {
                            button.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                            handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    button.getBackground().clearColorFilter();
                                }
                            }, 200);
                            break;
                        }
                    }
                    if (mCountDownTimer != null) {
                        mCountDownTimer.cancel();
                    }
                    GameOver();
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    btn_two.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_two.getBackground().clearColorFilter();
                        }
                    }, 200);
                    Toast.makeText(CoughColdQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                        label = (TextView) findViewById(R.id.timer);
                        ResetTime();
                    }else if (questionNumber == questionLength){
                        if (mCountDownTimer != null) {
                            mCountDownTimer.cancel();
                        }
                        Won();
                    }
                }else{
                    btn_two.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_two.getBackground().clearColorFilter();
                        }
                    }, 200);
                    for (final Button button : buttonList){
                        if(button.getText().equals(answer)) {
                            button.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                            handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    button.getBackground().clearColorFilter();
                                }
                            }, 200);
                            break;
                        }
                    }
                    if (mCountDownTimer != null) {
                        mCountDownTimer.cancel();
                    }
                    GameOver();
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    btn_three.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_three.getBackground().clearColorFilter();
                        }
                    }, 200);
                    Toast.makeText(CoughColdQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                        label = (TextView) findViewById(R.id.timer);
                        ResetTime();
                    }else if (questionNumber == questionLength){
                        if (mCountDownTimer != null) {
                            mCountDownTimer.cancel();
                        }
                        Won();
                    }
                }else{
                    btn_three.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_three.getBackground().clearColorFilter();
                        }
                    }, 200);
                    for (final Button button : buttonList){
                        if(button.getText().equals(answer)) {
                            button.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                            handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    button.getBackground().clearColorFilter();
                                }
                            }, 200);
                            break;
                        }
                    }
                    if (mCountDownTimer != null) {
                        mCountDownTimer.cancel();
                    }
                    GameOver();
                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    btn_four.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_four.getBackground().clearColorFilter();
                        }
                    }, 200);
                    Toast.makeText(CoughColdQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                        label = (TextView) findViewById(R.id.timer);
                        ResetTime();
                    }else if (questionNumber == questionLength){
                        if (mCountDownTimer != null) {
                            mCountDownTimer.cancel();
                        };
                        Won();
                    }
                }else{
                    btn_four.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_four.getBackground().clearColorFilter();
                        }
                    }, 200);
                    for (final Button button : buttonList){
                        if(button.getText().equals(answer)) {
                            button.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                            handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    button.getBackground().clearColorFilter();
                                }
                            }, 200);
                            break;
                        }
                    }
                    if (mCountDownTimer != null) {
                        mCountDownTimer.cancel();
                    }
                    GameOver();
                }

                break;
        }
    }
    private void ResetTime() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            counter = 10;
        }
        mCountDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                label.setText("Timer:" + String.valueOf(counter));
                counter--;
            }
            public void onFinish() {
                if (counter == 0) {
                    label.setText("Timer:0");
                    GameOver();
                }
            }
        }.start();
    }

    private void Won() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CoughColdQuiz.this);
        alertDialogBuilder
                .setMessage("Congratulations! You have successfully completed this level! You have unlocked 'Otic and Ophthalmic' quiz! ")
                .setCancelable(false)
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(CoughColdQuiz.this, MainActivity.class);
                        intent.putExtra(MainActivity.TAG_ACTIVITY_FROM, "From cough cold");
                        startActivity(intent);
                        finish();

                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();
    }

    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CoughColdQuiz.this);
        alertDialogBuilder
                .setMessage("Sorry! Try harder next time!")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), CoughColdQuiz.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       System.exit(0);
                    }
                });

        alertDialogBuilder.show();

    }

    private void NextQuestion(int num){
        cough_cold_quiz.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

        answer = question.getCorrectAnswer(num);
    }
}
