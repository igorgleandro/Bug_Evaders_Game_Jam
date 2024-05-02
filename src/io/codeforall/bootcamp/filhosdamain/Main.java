
package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameArea.Field;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Field initialField = new Field(1000,1000,"BugEvaders/resources/initialMenu.jpg");

        Game g = new Game(20);
        g.run();

    }
}
