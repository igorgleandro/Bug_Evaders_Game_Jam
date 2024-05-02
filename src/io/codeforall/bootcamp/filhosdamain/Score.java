package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.Enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class Score {

    private String name;
    private int score = 100;
    private Text scoreText;


    public Score(String name){
        this.name = name;
        scoreText = new Text(850, 70, "BULLETS: ");
        scoreText.setColor(Color.GREEN);
        scoreText.grow(50,15);
        scoreText.draw();
    }
    public void updateScore() {
        setScore(score - 1);
        scoreText.setText("BULLETS: " + score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void delete() {
        scoreText.delete();
    }

    public int getScore() {
        return score;
    }
}
