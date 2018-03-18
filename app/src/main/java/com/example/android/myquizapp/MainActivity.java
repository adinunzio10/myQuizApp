package com.example.android.myquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int questionsCorrect = 0;
    int questionsIncorrect = 0;

    public void questionCorrect() {
        questionsCorrect = questionsCorrect + 1;
    }
    public void questionIncorrect() {
        questionsIncorrect = questionsIncorrect + 1;
    }

    public void gradeQuestionOne() {
        // Figure out if question 1 is correct
        CheckBox answerOneQuestionOneCheckBox = findViewById(R.id.answerOneQuestionOne);
        boolean answerOneQuestionOne = answerOneQuestionOneCheckBox.isChecked();
        CheckBox answerTwoQuestionOneCheckBox = findViewById(R.id.answerTwoQuestionOne);
        boolean answerTwoQuestionOne = answerTwoQuestionOneCheckBox.isChecked();
        CheckBox answerThreeQuestionOneCheckBox = findViewById(R.id.answerThreeQuestionOne);
        boolean answerThreeQuestionOne = answerThreeQuestionOneCheckBox.isChecked();
        CheckBox answerFourQuestionOneCheckBox = findViewById(R.id.answerFourQuestionOne);
        boolean answerFourQuestionOne = answerFourQuestionOneCheckBox.isChecked();
        if(answerOneQuestionOne && answerTwoQuestionOne && answerFourQuestionOne && !answerThreeQuestionOne){
            questionCorrect();
        }
        else {
            questionIncorrect();
        }
    }

    public void gradeQuestionTwo() {
        // Figure out if question 2 is correct
        RadioButton answerOneQuestionTwoRadioButton = findViewById(R.id.answerOneQuestionTwo);
        if(answerOneQuestionTwoRadioButton.isChecked()){
            questionCorrect();
        }
        else {
            questionIncorrect();
        }
    }

    public void gradeQuestionThree() {
        // Figure out if question 3 is correct
        EditText answerQuestionThree = findViewById(R.id.answerQuestionThree);
        String userAnswerQuestionThree = answerQuestionThree.getText().toString();
        if(userAnswerQuestionThree.equals("Avengers")){
            questionCorrect();
        }
        else {
            questionIncorrect();
        }
    }

    public void gradeTest(View view) {
        gradeQuestionOne();
        gradeQuestionTwo();
        gradeQuestionThree();
        if(questionsCorrect == 0) {
            Toast.makeText(this, "You got no questions correct, try again", Toast.LENGTH_LONG).show();
        }
        else if (questionsCorrect == 3) {
            Toast.makeText(this, "You got all questions correct!", Toast.LENGTH_LONG).show();
        }
        else if(questionsIncorrect == 0) {
            Toast.makeText(this, "You got " + questionsCorrect + " Correct!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, questionsCorrect + " Correct! " + questionsIncorrect + " Incorrect!", Toast.LENGTH_LONG).show();
        }
        questionsCorrect = 0;
        questionsIncorrect = 0;
        }
}

