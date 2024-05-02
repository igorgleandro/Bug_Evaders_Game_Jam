package io.codeforall.bootcamp.filhosdamain.gameArea;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Rectangle gameArea;
    private Picture backGround;
    public final int PADDING = 10;

    public Field(int width, int height, String filePath) {
        gameArea = new Rectangle(PADDING, PADDING,height,width);
        backGround = new Picture(PADDING, PADDING, filePath);
        gameArea.draw();
        backGround.draw();
    }
}