
package io.codeforall.bootcamp.filhosdamain.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager {

    private Clip backgroundMusic;
    private Clip attackSound;
    //private Clip p1VictorySound;
    //private Clip p2VictorySound;


    public void startBackgroundMusic() {
        try {
            BackgroundMusic sounds = new BackgroundMusic();
            Thread thread = new Thread(sounds);
            thread.start();
            thread.interrupt();
        } catch (Exception ignored) {

        }
    }

  public void playAttackSound() {
        try {
            AttackSound sounds1 = new AttackSound();
            Thread thread1 = new Thread(sounds1);
            thread1.start();
            thread1.interrupt();
        } catch (Exception ignored) {

        }
    }
//
//    public void playRound1Sound() {
//        try {
//            Round1 sounds1 = new Round1();
//            Thread thread1 = new Thread(sounds1);
//            thread1.start();
//            thread1.interrupt();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void playRound2Sound() {
//        try {
//            flawlessVictorySound();
//            Thread.sleep(2000);
//            Round2 sounds1 = new Round2();
//            Thread thread1 = new Thread(sounds1);
//            thread1.start();
//            thread1.interrupt();
//        } catch (Exception ignored) {
//
//        }
//    }
//
//    public void playRound3Sound() {
//        try {
//            flawlessVictorySound();
//            Thread.sleep(2000);
//            Round3 sounds1 = new Round3();
//            Thread thread1 = new Thread(sounds1);
//            thread1.start();
//            thread1.interrupt();
//        } catch (Exception ignored) {
//
//        }
//    }
//
//
//    public void playP1VictorySound() {
//        try {
//            Gustavo sounds1 = new Gustavo();
//            Thread thread1 = new Thread(sounds1);
//            thread1.start();
//            thread1.interrupt();
//        } catch (Exception ignored) {
//
//        }
//    }
//    public void playP2VictorySound() {
//        try {
//            DeuCaquinha sounds1 = new DeuCaquinha();
//            Thread thread1 = new Thread(sounds1);
//            thread1.start();
//            thread1.interrupt();
//        } catch (Exception ignored) {
//
//        }
//    }
//
//
//    public void flawlessVictorySound() {
//        try {
//            VictorySound sounds1 = new VictorySound();
//            Thread thread1 = new Thread(sounds1);
//            thread1.start();
//            thread1.interrupt();
//        } catch (Exception ignored) {
//
//        }
//    }

}
