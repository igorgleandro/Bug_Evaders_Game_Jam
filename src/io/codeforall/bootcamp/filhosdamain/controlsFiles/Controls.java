package io.codeforall.bootcamp.filhosdamain.controlsFiles;

import io.codeforall.bootcamp.filhosdamain.Game;
import io.codeforall.bootcamp.filhosdamain.gameObject.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
public class Controls implements KeyboardHandler {

    private Player player;
    private Mcs mcs;
    private boolean rightPressed = false;
    private boolean leftPressed = false;

    private boolean spacePressed = false;

    public Controls(Player player, Mcs mcs) {
        this.player = player;
        this.mcs = mcs;
        init();
    }

    private void updatePaddles() {
        if (rightPressed) {
            player.moveRight();
        }
        if (leftPressed) {
            player.moveLeft();
        }
        if (spacePressed) {
            player.shoot();
            mcs.shootMcs();
        }
    }

    private void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightEvent = new KeyboardEvent();
        rightEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(rightEvent);

        KeyboardEvent leftEvent = new KeyboardEvent();
        leftEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftEvent.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(leftEvent);

        KeyboardEvent spaceEvent = new KeyboardEvent();
        spaceEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(spaceEvent);

        KeyboardEvent rightEvent2 = new KeyboardEvent();
        rightEvent2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightEvent2.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(rightEvent2);

        KeyboardEvent leftEvent2 = new KeyboardEvent();
        leftEvent2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftEvent2.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(leftEvent2);

        KeyboardEvent restartEvent = new KeyboardEvent();
        restartEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        restartEvent.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(restartEvent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                rightPressed = true;
                leftPressed = false;
                spacePressed = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                leftPressed = true;
                rightPressed = false;
                spacePressed = false;
                break;
            case KeyboardEvent.KEY_SPACE:
                spacePressed = true;
                break;
        }
        updatePaddles();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                rightPressed = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                leftPressed = false;
                break;
            case KeyboardEvent.KEY_SPACE:
                spacePressed = false;
                break;
        }
        updatePaddles();
    }
}

