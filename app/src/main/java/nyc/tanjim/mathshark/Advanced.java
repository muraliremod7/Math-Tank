package nyc.tanjim.mathshark;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Advanced extends AppCompatActivity {
    Button button0, button1, button2, button3;
    TextView questionText, scoreView;
    ImageButton menuButton;
    int locationOfCorrectAnswer, score = 0, numberOfQuestions = 0;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    ConstraintLayout bg;
    Animation buttonsInit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        questionText = findViewById(R.id.quiestionsView);
        scoreView = findViewById(R.id.scoreView);
        bg = findViewById(R.id.bg);
//        menuButton = findViewById(R.id.menuButton);
        AnimationDrawable drawable = new AnimationDrawable();
        buttonsInit = AnimationUtils.loadAnimation(this,R.anim.advanced_init);

        Handler handler = new Handler();
        //Generate the starting question
        generateQuestion();
    }


    //Answer button's functionality
    public void choose(View view){

        //gets the difference between number of questions answered and score
        double difference;
        difference = numberOfQuestions - score;

        //if statement connects the tapped answer to the correct answer
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
            numberOfQuestions++;
            generateQuestion();
            /*
            bg.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.correct_gradient_1));
            scoreView.setTextColor(Color.WHITE);
            questionText.setTextColor(Color.WHITE);
            menuButton.setImageResource(R.drawable.ic_menu_white);*/
        }else {
            numberOfQuestions++;
            if(locationOfCorrectAnswer == 0){
                button0.startAnimation(AnimationUtils.loadAnimation(this,R.anim.correct_animation));
            } else if (locationOfCorrectAnswer == 1){
                button1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.correct_animation));
            } else if (locationOfCorrectAnswer == 2){
                button2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.correct_animation));
            } else if (locationOfCorrectAnswer == 3){
                button3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.correct_animation));
            }
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    generateQuestion();
                }
            }, 1000);
            /*
            bg.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.wrong_gradient_1));
            scoreView.setTextColor(Color.WHITE);
            questionText.setTextColor(Color.WHITE);
            menuButton.setImageResource(R.drawable.ic_menu_white);*/
        }
        scoreView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));


        answers.clear();
    }
    public void generateQuestion(){
        Random rd = new Random();
        int a = rd.nextInt(4);
        if(a == 0) {
            squareQuestions();
        }else if(a == 1){
            cubeQuestions();
        }else if(a == 2){
            sqrtQuestions();
        }else if(a == 3){
            cbrtQuestions();
        }
        answers.clear();
        button0.startAnimation(buttonsInit);
        button1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.advanced_init_1));
        button2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.advanced_init_2));
        button3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.advanced_init_3));
    }
    public void squareQuestions(){
        Random rd = new Random();
        int a = rd.nextInt(10)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.square,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){

                answers.add((int)Math.pow(a,2));
            }else{
                incorrectAnswer = rd.nextInt(50)+1;
                while(incorrectAnswer == (int)Math.pow(a,2)){
                    incorrectAnswer = rd.nextInt(50)+1;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }
    public void cubeQuestions(){
        Random rd = new Random();
        int a = rd.nextInt(4)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.cube,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){

                answers.add((int)Math.pow(a,3));
            }else{
                incorrectAnswer = rd.nextInt(50)+1;
                while(incorrectAnswer == (int)Math.pow(a,3)){
                    incorrectAnswer = rd.nextInt(50)+1;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }
    public void sqrtQuestions(){
        Random rd = new Random();
        int a = rd.nextInt(100)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        while(Math.sqrt(a) % 1 != 0){
            a = rd.nextInt(100)+1;
        }
        questionText.setText(getString(R.string.sqrt,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((int)Math.sqrt(a));
            }else{
                incorrectAnswer = rd.nextInt(50)+1;
                while(incorrectAnswer == (int)Math.sqrt(a)){
                    incorrectAnswer = rd.nextInt(50)+1;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }
    public void cbrtQuestions(){
        Random rd = new Random();
        int a = rd.nextInt(100)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        while(Math.cbrt(a) % 1 != 0){
            a = rd.nextInt(100)+1;
        }
        questionText.setText(getString(R.string.cbrt,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((int)Math.cbrt(a));
            }else{
                incorrectAnswer = rd.nextInt(50)+1;
                while(incorrectAnswer == (int)Math.cbrt(a)){
                    incorrectAnswer = rd.nextInt(50)+1;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }

    //Resets current session
    public void reset(){
        score = 0;
        numberOfQuestions = 0;
        scoreView.setText("0/0");
        generateQuestion();
        bg.setBackgroundColor(0xffffff);
        scoreView.setTextColor(Color.GRAY);
        questionText.setTextColor(Color.GRAY);
        menuButton.setImageResource(R.drawable.ic_menu);

    }


}
