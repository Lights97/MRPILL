package com.example.user.mrpill;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SkinConditionsQuiz extends AppCompatActivity implements View.OnClickListener{

    Button btn_one, btn_two, btn_three, btn_four;
    TextView skin_conditions_quiz;

    private SkinConditionsQuestion question = new SkinConditionsQuestion();

    private String answer;
    private int questionLength = question.questions.length;
    private int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_conditions_quiz);

        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        skin_conditions_quiz = (TextView)findViewById(R.id.skin_quiz);

        NextQuestion(questionNumber++);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    Toast.makeText(SkinConditionsQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                    }else if (questionNumber == questionLength){
                        Won();
                    }
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    Toast.makeText(SkinConditionsQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                    }else if (questionNumber == questionLength){
                        Won();
                    }
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    Toast.makeText(SkinConditionsQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                    }else if (questionNumber == questionLength){
                        Won();
                    }
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    Toast.makeText(SkinConditionsQuiz.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    if (questionNumber < questionLength) {
                        NextQuestion(questionNumber++);
                    }else if (questionNumber == questionLength){
                        Won();
                    }
                }else{
                    GameOver();
                }

                break;
        }
    }

    private void Won() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SkinConditionsQuiz.this);
        alertDialogBuilder
                .setMessage("Congratulations! You have successfully completed this level! You have also won Mr Bean eVouchers! Check them out by clicking 'Rewards'! Enjoy!")
                .setCancelable(false)
                .setPositiveButton("Rewards", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), Rewards.class));
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

    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SkinConditionsQuiz.this);
        alertDialogBuilder
                .setMessage("Sorry! Try harder next time!")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), SkinConditionsQuiz.class));
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
        skin_conditions_quiz.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

        answer = question.getCorrectAnswer(num);
    }
}


