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

    boolean questionOneCorrect;
    boolean questionTwoCorrect;
    boolean questionThreeCorrect;

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
        questionOneCorrect = (answerOneQuestionOne && answerTwoQuestionOne && answerFourQuestionOne && !answerThreeQuestionOne);}


    public void gradeQuestionTwo() {
        // Figure out if question 2 is correct
        RadioButton answerOneQuestionTwoRadioButton = findViewById(R.id.answerOneQuestionTwo);
        questionTwoCorrect = (answerOneQuestionTwoRadioButton.isChecked());
    }

    public void gradeQuestionThree() {
        // Figure out if question 3 is correct
        EditText answerQuestionThree = findViewById(R.id.answerQuestionThree);
        String userAnswerQuestionThree = answerQuestionThree.getText().toString();
        questionThreeCorrect = (userAnswerQuestionThree.equals("Avengers"));
    }

    public void gradeTest(View view) {
        gradeQuestionOne();
        gradeQuestionTwo();
        gradeQuestionThree();
        if (questionOneCorrect && questionTwoCorrect && questionThreeCorrect) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

}

