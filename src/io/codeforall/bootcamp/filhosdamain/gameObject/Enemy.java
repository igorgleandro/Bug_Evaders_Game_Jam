package io.codeforall.bootcamp.filhosdamain.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.filhosdamain.positions.Position;

public abstract class Enemy{
    private int enemyX;
    private int enemyY;
    private Position position;
    protected Picture enemyImage;
    public final int ENEMY_SPEED = 2;
    private static int  random = 1;
    private int health;
    private boolean isDestroyed;

    public Enemy(int x, int y) {
        this.enemyX = x;
        this.enemyY = y;
        this.position = new Position(x, y);
    }

    public void destroy() {
        enemyImage.delete();
    }

    public void movement() {

        switch (random) {
            case 0:
                moveLeft();
                if (getEnemyX() == 50 ) {
                    random = 1;
                }
                break;
            case 1:
                moveRight();
                if (getEnemyX() == 950) {
                    random = 0;
                }
                break;
        }
    }

    public void moveRight() {
        if (enemyX + enemyImage.getWidth() < 1000) {
            enemyImage.translate(ENEMY_SPEED, 0);
            enemyX += ENEMY_SPEED;
            this.getPosition().setX(enemyX);
        }
    }

    public void moveLeft() {
        if (enemyX > 0) {
            enemyImage.translate(-ENEMY_SPEED, 0);
            enemyX -= ENEMY_SPEED;
            this.getPosition().setX(enemyX);
        }
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


    public Position getPosition() {
        return position;
    }

    public int getEnemyX() {
        return enemyX;
    }

    public void setEnemyX(int enemyX) {
        this.enemyX = enemyX;
    }

    public int getEnemyY() {
        return enemyY;
    }

    public void setEnemyY(int enemyY) {
        this.enemyY = enemyY;
    }

    public Picture getPicture() {
        return enemyImage;
    }

}
