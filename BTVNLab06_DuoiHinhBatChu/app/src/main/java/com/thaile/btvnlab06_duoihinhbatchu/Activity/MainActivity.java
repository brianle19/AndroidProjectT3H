package com.thaile.btvnlab06_duoihinhbatchu.Activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thaile.btvnlab06_duoihinhbatchu.R;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Animation anim, animImg;
    private Button btnNext, btnReplay;
    private Button btnAnswer[];
    private TextView score, level;
    private LinearLayout answerLayout, layoutBtnQuestion;
    private Button arrButton[] = new Button[16];
    private ImageView imgQuestion;
    private int userScore;
    private int userLevel = 1;
    private int lengthAnswer;
    private String checkText = "";
    private QuestionManager questionManager;
    private int numberClick = 0;
    private int index = 0;
    private QuestionObject currentQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_rotate_anim);
        animImg = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha_anim);
        initView();
    }

    private void initView() {

        answerLayout = (LinearLayout) findViewById(R.id.answerlayout);

        layoutBtnQuestion = (LinearLayout) findViewById(R.id.layoutBtnQuestion);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

        btnReplay = (Button) findViewById(R.id.btnReplay);
        btnReplay.setOnClickListener(this);

        imgQuestion = (ImageView) findViewById(R.id.imgquestion);
        score = (TextView) findViewById(R.id.coin);
        level = (TextView) findViewById(R.id.level);

        arrButton[0] = (Button) findViewById(R.id.b1);
        arrButton[1] = (Button) findViewById(R.id.b2);
        arrButton[2] = (Button) findViewById(R.id.b3);
        arrButton[3] = (Button) findViewById(R.id.b4);
        arrButton[4] = (Button) findViewById(R.id.b5);
        arrButton[5] = (Button) findViewById(R.id.b6);
        arrButton[6] = (Button) findViewById(R.id.b7);
        arrButton[7] = (Button) findViewById(R.id.b8);
        arrButton[8] = (Button) findViewById(R.id.b9);
        arrButton[9] = (Button) findViewById(R.id.b10);
        arrButton[10] = (Button) findViewById(R.id.b11);
        arrButton[11] = (Button) findViewById(R.id.b12);
        arrButton[12] = (Button) findViewById(R.id.b13);
        arrButton[13] = (Button) findViewById(R.id.b14);
        arrButton[14] = (Button) findViewById(R.id.b15);
        arrButton[15] = (Button) findViewById(R.id.b16);

        questionManager = new QuestionManager();
        initQuestion();

    }

    private void initQuestion() {
            currentQ = questionManager.arrayList.get(index);
            setBitMapImage(currentQ.getImg());
            imgQuestion.setAnimation(animImg);
            setButtonText(currentQ.getText());
            createButtonAnswer(answerLayout);
            setEventForButton();
            index++;
    }

    private void setBitMapImage(String name){
        AssetManager assetManager = getAssets();
        try {
            InputStream input = assetManager.open("img/"+name);
            BitmapFactory.decodeStream(input);
            Bitmap src = BitmapFactory.decodeStream(input);
            imgQuestion.setImageBitmap(src);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setEventForButton() {
        for (int i = 0; i < arrButton.length; i++) {
            final String chooseText = arrButton[i].getText().toString();
            final int finalI = i;
            arrButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClick++;
                    for (int j = 0; j < btnAnswer.length; j++) {
                        if (btnAnswer[j].getText().equals("")) {
                            btnAnswer[j].setText(chooseText);
                            arrButton[finalI].setVisibility(View.INVISIBLE);
                            if (numberClick == btnAnswer.length) {
                                checkAnswer();
                            }
                            break;
                        }
                    }
                }
            });
        }
    }

    public void checkAnswer() {
            if (!(btnAnswer[btnAnswer.length - 1].getText().toString().equals(""))) {
                getAnswer();
                    String textAnswer = currentQ.getTextAnswer();
                    final char fullTextAnswer[] = currentQ.getFullTextAnswer().toCharArray();
                    if (isAnswerCorrect(textAnswer)) {
                        btnNext.setVisibility(View.VISIBLE);
                        setButtonTrue();
                        setFullCorrectAnswer(fullTextAnswer);
                        userScore += 10;
                        score.setText(userScore + "");
                    } else {
                        setButtonFalse();
                        btnReplay.setVisibility(View.VISIBLE);
                    }
            }
    }

    public boolean isAnswerCorrect(String key){
        if (checkText.equals(key))
            return true;
        else
            return false;

    }

    public void setFullCorrectAnswer(char[] fullTextAnswer) {
        for (int j = 0; j < btnAnswer.length; j++) {
            btnAnswer[j].setText(fullTextAnswer[j]+ "");
        }
    }

    public void setButtonFalse() {
        for (int k = 0; k < btnAnswer.length; k++) {
            btnAnswer[k].setBackgroundResource(R.drawable.tile_false);
        }
    }

    public void setButtonTrue() {
        for (int k = 0; k < btnAnswer.length; k++) {
            btnAnswer[k].setBackgroundResource(R.drawable.tile_true);
            btnAnswer[k].startAnimation(anim);
        }
    }

    private void setButtonText(String text) {
        char[] newText = text.toCharArray();
        for (int i = 0; i < arrButton.length; i++) {
            arrButton[i].setText(newText[i] + "");
        }
    }

    public void createButtonAnswer(LinearLayout ln) {
        ln.removeAllViews();
        lengthAnswer = currentQ.getTextAnswer().length();
        btnAnswer = new Button[lengthAnswer];
        for (int j = 0; j < btnAnswer.length; j++) {
            btnAnswer[j] = new Button(this);
            btnAnswer[j].setBackgroundResource(R.drawable.tile_hover);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(120, 140);
            btnAnswer[j].setTextAppearance(this, R.style.textAnswer);
            ln.addView(btnAnswer[j], lp);
        }
    }

    public void getAnswer(){
        for (int i = 0; i < btnAnswer.length ; i++) {
            checkText += btnAnswer[i].getText().toString();
         }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNext:
                userLevel +=1;
                level.setText(""+userLevel);
                numberClick = 0;
                checkText = "";
                btnNext.setVisibility(View.INVISIBLE);
                for (int i = 0; i < arrButton.length ; i++) {
                    arrButton[i].setVisibility(View.VISIBLE);
                }
                initQuestion();
                break;

            case R.id.btnReplay:
                answerLayout.removeAllViews();
                btnReplay.setVisibility(View.INVISIBLE);

                for (int i = 0; i < arrButton.length ; i++) {
                    arrButton[i].setVisibility(View.VISIBLE);
                }

                numberClick = 0;
                checkText = "";
                setButtonText(currentQ.getText());
                createButtonAnswer(answerLayout);
                setEventForButton();
                break;
        }
    }
}

