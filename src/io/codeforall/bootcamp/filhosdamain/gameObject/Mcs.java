package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.gameArea.Field;
import io.codeforall.bootcamp.filhosdamain.positions.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Mcs extends Enemy {

    private int health;
    private int mcX;
    private int mcY;
    Position position;
    private boolean isDestroyed;
    private static int random = 1;
    private LinkedList<McBullet> mcProjectiles;
    Field winScreen;

    public Mcs(int x, int y, LinkedList<McBullet> mcProjectiles) {
        super(x, y);
        this.health = 10;
        this.mcX = x;
        this.mcY = y;
        this.position = new Position(x,y);
        this.mcProjectiles = mcProjectiles;

        int mcRandom = (int)(Math.random()*4);
        switch (mcRandom){
            case 0: enemyImage = new Picture(x, y, "mc3.png");
            break;
            case 1: enemyImage = new Picture(x,y,"mc1.png");
            break;
            case 2: enemyImage = new Picture(x,y,"mc2.png");
            break;
            case 3: enemyImage = new Picture(x,y ,"mc4.png");
            break;
        }
        enemyImage.draw();
    }


    public void hit(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            Field winScreen = new Field(1000,1000,"winScreen.jpg");
            isDestroyed = true;
        }
    }


    public boolean isAlive() {
        if(this.health <= 0){
            Field winScreen = new Field(1000,1000,"winScreen.jpg");
            return false;
        }
        return true;
    }


    @Override
    public void movement() {
        switch (random) {
            case 0:
                moveLeft();
                if (getEnemyX() ==200 ) {
                    random = 1;
                }
                break;
            case 1:
                moveRight();
                if (getEnemyX() == 800) {
                    random = 0;
                }
                break;
        }
    }

    public void destroy(){
        enemyImage.delete();
    }

    public void shootMcs() {
        Position projectilePosition = new Position(getEnemyX() + enemyImage.getWidth() / 2, getEnemyY());
        McBullet projectile = new McBullet(projectilePosition);
        mcProjectiles.add(projectile);
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public int getMcX() {
        return mcX;
    }

    public int getMxY() {
        return mcY;
    }
}
