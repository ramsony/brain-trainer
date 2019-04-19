package com.example.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goBtn;
    int locationOfCorrectAnswer;
    ArrayList<Integer> answers = new ArrayList<>();
    TextView resultTextView;

    public void chooseAnswer(View view){
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
            resultTextView.setText("Correct !!");
        }else{
            resultTextView.setText("Wrong :(");
        }

    }

    public void  start(View view){
        goBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sumTextView = findViewById(R.id.sumTextView);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        resultTextView = findViewById(R.id.resultTextView);

        goBtn = findViewById(R.id.goButton);

        Random rand = new Random();


        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(a + " + " + b);

        locationOfCorrectAnswer = rand.nextInt(4);

        for(int i = 0; i<4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                int wrongAnswer = rand.nextInt(41);

                while(wrongAnswer == a + b){
                    wrongAnswer = rand.nextInt(41);
                }

                answers.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }
}
