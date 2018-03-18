package com.example.android.myquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Arrays;

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
        if (answerOneQuestionOne && answerTwoQuestionOne && !answerThreeQuestionOne && answerFourQuestionOne) {
            questionCorrect();
        } else {
            questionIncorrect();
        }

    }

    public void gradeQuestionTwo() {
        // Figure out if question 2 is correct
        RadioButton answerOneQuestionTwoRadioButton = findViewById(R.id.answerOneQuestionTwo);
        if (answerOneQuestionTwoRadioButton.isChecked()) {
            questionCorrect();
        } else {
            questionIncorrect();
        }

    }

    public void gradeQuestionThree() {
        // Figure out if question 3 is correct
        EditText answerQuestionThree = findViewById(R.id.answerQuestionThree);
        String userAnswerQuestionThree = answerQuestionThree.getText().toString();
        String rightAnswers[] = {"Avengers", "avengers", "the avengers", "The Avengers", "the Avengers", "The avengers"};
        if (Arrays.asList(rightAnswers).contains(userAnswerQuestionThree)) {
            questionCorrect();
        } else {
            questionIncorrect();
        }
    }

    public void gradeQuestionFour() {
        // Figure out if question 4 is correct
        RadioButton answerThreeQuestionFourRadioButton = findViewById(R.id.answerThreeQuestionFour);
        if (answerThreeQuestionFourRadioButton.isChecked()) {
            questionCorrect();
        } else {
            questionIncorrect();
        }
    }

    public void gradeQuestionFive() {
        // Figure out if question 5 is correct
        CheckBox answerOneQuestionFiveCheckBox = findViewById(R.id.answerOneQuestionFive);
        boolean answerOneQuestionFive = answerOneQuestionFiveCheckBox.isChecked();
        CheckBox answerTwoQuestionFiveCheckBox = findViewById(R.id.answerTwoQuestionFive);
        boolean answerTwoQuestionFive = answerTwoQuestionFiveCheckBox.isChecked();
        CheckBox answerThreeQuestionFiveCheckBox = findViewById(R.id.answerThreeQuestionFive);
        boolean answerThreeQuestionFive = answerThreeQuestionFiveCheckBox.isChecked();
        CheckBox answerFourQuestionFiveCheckBox = findViewById(R.id.answerFourQuestionFive);
        boolean answerFourQuestionFive = answerFourQuestionFiveCheckBox.isChecked();
        if (answerOneQuestionFive && !answerTwoQuestionFive && answerThreeQuestionFive && answerFourQuestionFive) {
            questionCorrect();
        } else {
            questionIncorrect();
        }
    }

    public void gradeTest() {
        gradeQuestionOne();
        gradeQuestionTwo();
        gradeQuestionThree();
        gradeQuestionFour();
        gradeQuestionFive();
    }

    public void scoreTest(View view) {
        gradeTest();
        if (questionsCorrect == 0) {
            Toast.makeText(this, "You got 0/5, try again", Toast.LENGTH_LONG).show();
        } else if (questionsCorrect == 5) {
            Toast.makeText(this, "You got 5/5 Correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You got " + questionsCorrect + "/5 Correct!", Toast.LENGTH_LONG).show();
        }
        questionsCorrect = 0;
    }

}

