package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.Score;
import io.codeforall.bootcamp.filhosdamain.gameArea.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import io.codeforall.bootcamp.filhosdamain.positions.Position;

import java.util.LinkedList;


public class Player{

    private static final int PLAYER_SPEED = 20;
    private int playerX;
    private int playerY;
    Position position;
    private  int health;
    private Picture playerImage;
    private LinkedList<BugProjectile> projectiles;
    private Score score;
    private boolean isDestroyed;
    private Field loseScreen;

    public Player(int x, int y, LinkedList<BugProjectile> projectiles) {
        this.playerX = x;
        this.playerY = y;
        this.health = 3;
        this.position = new Position(x,y);

        int playerRandom = (int)(Math.random()*4);
        switch (playerRandom){
            case 0: this.playerImage = new Picture(x, y, "player1.png");
                break;
            case 1: this.playerImage = new Picture(x,y,"player2.png");
                break;
            case 2: this.playerImage = new Picture(x,y,"player3.png");
                break;
            case 3: this.playerImage = new Picture(x,y ,"player4.png");
                break;
        }

        this.playerImage.draw();
        this.projectiles = projectiles;
        this.score = new Score("Score");
    }

    public void moveRight() {
        if (playerX + playerImage.getWidth() < 1000) {
            playerImage.translate(PLAYER_SPEED, 0);
            playerX += PLAYER_SPEED;
            this.position.setX(playerX);
        }
    }

    public void moveLeft() {
        if (playerX > 0) {
            playerImage.translate(-PLAYER_SPEED, 0);
            playerX -= PLAYER_SPEED;
            this.position.setX(playerX);
        }
    }

    public void shoot() {
        if(!isAlive()){
            loseScreen = new Field(1000,1000,"oseScreen.jpg");
            isDestroyed = true;
        }
        score.updateScore();
        Position projectilePosition = new Position(playerX + playerImage.getWidth() / 2, playerY);
        BugProjectile projectile = new BugProjectile(projectilePosition);
        projectiles.add(projectile);
    }

    public void hit(int damage) {
        this.health -= damage;
        if(this.health <= 0){
            loseScreen = new Field(1000,1000,"loseScreen.jpg");
            isDestroyed = true;
        }
    }


    public boolean isAlive() {
        if(score.getScore() <= 0){
            loseScreen = new Field(1000,1000,"loseScreen.jpg");
            return false;
        }
        return true;
    }

    public void destroy(){
        playerImage.delete();
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isDestroyed(){
        return isDestroyed;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerX=" + playerX +
                ", playerY=" + playerY +
                ", playerImage=" + playerImage +
                ", projectiles=" + projectiles +
                '}';
    }

    public Picture getPlayerImage() {
        return playerImage;
    }


}

