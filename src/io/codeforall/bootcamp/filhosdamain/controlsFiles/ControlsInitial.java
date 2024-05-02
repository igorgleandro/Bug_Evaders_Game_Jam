package io.codeforall.bootcamp.filhosdamain.controlsFiles;

import io.codeforall.bootcamp.filhosdamain.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class ControlsInitial implements KeyboardHandler {

    private Game g;
    private boolean spacePressed = false;
    private boolean quitPressed = false;
    private static boolean isGameRunning = false;

    public ControlsInitial(Game g) {
        this.g = g;
        init();
    }


    private void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent playEvent = new KeyboardEvent();
        playEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        playEvent.setKey(KeyboardEvent.KEY_P);
        keyboard.addEventListener(playEvent);

        KeyboardEvent quitEvent = new KeyboardEvent();
        quitEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quitEvent.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(quitEvent);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_P:
                if (!isGameRunning) {
                    spacePressed = true;
                    g.gameScreen();
                    isGameRunning = true;
                    break;
                }
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_P:
                spacePressed = false;
                break;
            case KeyboardEvent.KEY_Q:
                quitPressed = false;
                break;
        }
    }
}



