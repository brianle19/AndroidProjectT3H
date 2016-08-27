package com.thaile.btvnlab06_duoihinhbatchu.Activity;

/**
 * Created by Le on 6/24/2016.
 */
public class QuestionObject {
    private String fullTextAnswer;
    private String img;
    private String text;
    private String textAnswer;

    public QuestionObject(String img, String text, String textAnswer, String fullTextAnswer){
        this.img = img;
        this.text = text;
        this.textAnswer = textAnswer;
        this.fullTextAnswer = fullTextAnswer;
    }

    public String getImg() {
        return img;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public String getText() {
        return text;
    }

    public String getFullTextAnswer() {
        return fullTextAnswer;
    }
}
