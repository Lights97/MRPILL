package com.example.user.mrpill;

public class OticOphthalmicQuestion {
    public String questions[] = {
            "Which is a common feature of common cold?",
            "Which is the usual distinguishing feature of allergic rhinitis from common cold?"
    };

    public String choices[][] = {
            {"Abrupt onset", "High fever", "Severe headache", "Sore throat"},
            {"Nasal congestion", "Nose itch", "Sneezing", "Sore throat"}
    };

    public String correctAnswer[] = {
            "Sore throat",
            "Nose itch"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
