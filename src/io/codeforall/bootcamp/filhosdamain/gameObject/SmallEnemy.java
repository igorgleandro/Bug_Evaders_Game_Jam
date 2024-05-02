package io.codeforall.bootcamp.filhosdamain.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SmallEnemy extends Enemy{

    private int health;
    private  boolean isDestroyed;

    public SmallEnemy(int x, int y) {
        super(x, y);
        this.health = 1;
        enemyImage = new Picture(x, y, "villian1.png");
        enemyImage.draw();
    }

    public void hit(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            isDestroyed = true;
        }
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
}



