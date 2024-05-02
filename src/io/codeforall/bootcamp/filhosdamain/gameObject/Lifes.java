package io.codeforall.bootcamp.filhosdamain.gameObject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Lifes {

    private Picture life;
    private int x = 50;
    private int y = 50;
    /*public Lifes(int number) {
        for (int i = 0; i < number; i++){
            life = new Picture(x,y,"BugEvaders/resources/lifes.png");
            life.draw();
            this.x += 50;
        }
    }*/

    public Lifes(int x, int y) {
       life = new Picture(x,y,"lifes.png");
       life.draw();
    }

    public void remove(){
        life.delete();
    }
}
