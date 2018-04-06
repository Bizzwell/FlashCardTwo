package com.example.android.flashcardtwo;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.lang.*;


public class MainActivity extends AppCompatActivity {


    Random rand = new Random();
    int topNumber = rand.nextInt(5);
    int bottomNumber = rand.nextInt(10);
    int correctAnswer = 0;
    int userAnswer = 5;
    int numberRight = 0;
    int numberWrong = 0;
    int totalAnswers = 0;

    Button topPlusZero;
    Button topPlusOne;
    Button topPlusTwo;
    Button topPlusThree;
    Button topPlusFour;
    Button topPlusFive;
    Button topPlusSix;
    Button topPlusSeven;
    Button topPlusEight;
    Button topPlusNine;


    CountDownTimer timer = new CountDownTimer(90000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            TextView countdownTimer = (TextView) findViewById(R.id.countdown_timer);
            countdownTimer.setText("" + millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
            TextView countdownTimer = (TextView) findViewById(R.id.countdown_timer);
            countdownTimer.setText("Done!");

            topPlusZero.setEnabled(false);
            topPlusOne.setEnabled(false);
            topPlusTwo.setEnabled(false);
            topPlusThree.setEnabled(false);
            topPlusFour.setEnabled(false);
            topPlusFive.setEnabled(false);
            topPlusSix.setEnabled(false);
            topPlusSeven.setEnabled(false);
            topPlusEight.setEnabled(false);
            topPlusNine.setEnabled(false);
  
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topPlusZero = (Button) findViewById(R.id.top_plus_zero);
        topPlusOne = (Button) findViewById(R.id.top_plus_one);
        topPlusTwo = (Button) findViewById(R.id.top_plus_two);
        topPlusThree = (Button) findViewById(R.id.top_plus_three);
        topPlusFour = (Button) findViewById(R.id.top_plus_four);
        topPlusFive = (Button) findViewById(R.id.top_plus_five);
        topPlusSix = (Button) findViewById(R.id.top_plus_six);
        topPlusSeven = (Button) findViewById(R.id.top_plus_seven);
        topPlusEight = (Button) findViewById(R.id.top_plus_eight);
        topPlusNine = (Button) findViewById(R.id.top_plus_nine);
    }

    public void startFlashing(View view) {
        topNumber = rand.nextInt(5);
        userAnswer = 5;
        numberRight = 0;
        numberWrong = 0;
        totalAnswers = 0;
        bottomNumber = rand.nextInt(10);

        topPlusZero.setText(String.valueOf(topNumber + 0));
        topPlusOne.setText(String.valueOf(topNumber + 1));
        topPlusTwo.setText(String.valueOf(topNumber + 2));
        topPlusThree.setText(String.valueOf(topNumber + 3));
        topPlusFour.setText(String.valueOf(topNumber + 4));
        topPlusFive.setText(String.valueOf(topNumber + 5));
        topPlusSix.setText(String.valueOf(topNumber + 6));
        topPlusSeven.setText(String.valueOf(topNumber + 7));
        topPlusEight.setText(String.valueOf(topNumber + 8));
        topPlusNine.setText(String.valueOf(topNumber + 9));


        topPlusZero.setEnabled(true);
        topPlusOne.setEnabled(true);
        topPlusTwo.setEnabled(true);
        topPlusThree.setEnabled(true);
        topPlusFour.setEnabled(true);
        topPlusFive.setEnabled(true);
        topPlusSix.setEnabled(true);
        topPlusSeven.setEnabled(true);
        topPlusEight.setEnabled(true);
        topPlusNine.setEnabled(true);

        displayTopNumber(topNumber);
        displayBottomNumber(bottomNumber);
        displayAnswer(0);
        displayUnknownAnswer();
        displayTotalNumber(totalAnswers);
        displayNumberRight(numberRight);
        displayNumberWrong(numberWrong);
        timer.start();
        correctAnswer = calculateAnswer(topNumber, bottomNumber);

    }


    /**
     * Displays the topNumber.
     */

    public void displayTopNumber(int topNumber) {
        TextView topNumberView = (TextView) findViewById(R.id.top_number);
        topNumberView.setText(String.valueOf(topNumber));
    }

    /**
     * Displays the bottomNumber
     */

    public void displayBottomNumber(int bottomNumber) {
        TextView bottomNumberView = (TextView) findViewById(R.id.bottom_number);
        bottomNumberView.setText(String.valueOf(bottomNumber));
    }

    public void displayAnswer(int answer) {
        TextView userAnswerView = (TextView) findViewById(R.id.unknown_answer);
        userAnswerView.setText(String.valueOf(answer));
    }

    public int calculateAnswer(int topNumber, int bottomNumber) {
        correctAnswer = topNumber + bottomNumber;
        return correctAnswer;
    }

    public void displayCorrectOrNot(String correctOrNot) {
        TextView correctOrNotView = (TextView) findViewById(R.id.correct_or_not);
        correctOrNotView.setText(String.valueOf(correctOrNot));
    }

    public void determineCorrectness() {

        if (userAnswer == correctAnswer) {
            numberRight = numberRight + 1;
            totalAnswers = totalAnswers + 1;
            displayAnswer(userAnswer);
            displayNumberRight(numberRight);
            displayNumberWrong(numberWrong);
            displayTotalNumber(totalAnswers);
            displayCorrectOrNot("Hooray!");
            nextWithoutButton();
        } else {
            numberWrong = numberWrong + 1;
            totalAnswers = totalAnswers + 1;
            displayNumberRight(numberRight);
            displayNumberWrong(numberWrong);
            displayTotalNumber(totalAnswers);
            displayCorrectOrNot("Try Again!");
        }
    }

    public void displayUnknownAnswer() {
        TextView unknownAnswerView = (TextView) findViewById(R.id.unknown_answer);
        unknownAnswerView.setText(String.valueOf("?"));
    }

    public void displayNumberRight(int numberRight) {
        TextView numberRightView = (TextView) findViewById(R.id.total_right);
        numberRightView.setText(String.valueOf(numberRight));
    }

    public void displayNumberWrong(int numberWrong) {
        TextView numberWrongView = (TextView) findViewById(R.id.total_wrong);
        numberWrongView.setText(String.valueOf(numberWrong));
    }

    public void displayTotalNumber(int totalAnswers) {
        TextView totalAnswersView = (TextView) findViewById(R.id.total_number);
        totalAnswersView.setText(String.valueOf(totalAnswers));
    }

    /**
     * Adds corresponding number to top number to determine userAnswer
     */
    public void topPlusZero(View view) {
        userAnswer = topNumber + 0;
        determineCorrectness();
    }

    public void topPlusOne(View view) {
        userAnswer = topNumber + 1;
        determineCorrectness();
    }

    public void topPlusTwo(View view) {
        userAnswer = topNumber + 2;
        determineCorrectness();
    }

    public void topPlusThree(View view) {
        userAnswer = topNumber + 3;
        determineCorrectness();
    }

    public void topPlusFour(View view) {
        userAnswer = topNumber + 4;
        determineCorrectness();
    }

    public void topPlusFive(View view) {
        userAnswer = topNumber + 5;
        determineCorrectness();
    }

    public void topPlusSix(View view) {
        userAnswer = topNumber + 6;
        determineCorrectness();
    }

    public void topPlusSeven(View view) {
        userAnswer = topNumber + 7;
        determineCorrectness();
    }

    public void topPlusEight(View view) {
        userAnswer = topNumber + 8;
        determineCorrectness();
    }

    public void topPlusNine(View view) {
        userAnswer = topNumber + 9;
        determineCorrectness();
    }


    public void nextWithoutButton() {
        topNumber = rand.nextInt(5);
        userAnswer = 5;
        bottomNumber = rand.nextInt(10);

        topPlusZero.setText(String.valueOf(topNumber + 0));
        topPlusOne.setText(String.valueOf(topNumber + 1));
        topPlusTwo.setText(String.valueOf(topNumber + 2));
        topPlusThree.setText(String.valueOf(topNumber + 3));
        topPlusFour.setText(String.valueOf(topNumber + 4));
        topPlusFive.setText(String.valueOf(topNumber + 5));
        topPlusSix.setText(String.valueOf(topNumber + 6));
        topPlusSeven.setText(String.valueOf(topNumber + 7));
        topPlusEight.setText(String.valueOf(topNumber + 8));
        topPlusNine.setText(String.valueOf(topNumber + 9));

        displayTopNumber(topNumber);
        displayBottomNumber(bottomNumber);
        displayAnswer(0);
        displayUnknownAnswer();
        correctAnswer = calculateAnswer(topNumber, bottomNumber);

    }
}
