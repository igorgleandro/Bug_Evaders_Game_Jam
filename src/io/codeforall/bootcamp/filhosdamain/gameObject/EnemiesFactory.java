package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.gameArea.Field;

import java.util.ArrayList;

public class EnemiesFactory {

    public static void getNewEnemy(ArrayList<Enemy> arraylist) {
        int random = (int) (Math.random() * 2);
        switch (random){
            case 0:
                pattern1(arraylist);
                break;
            case 1:
                pattern2(arraylist);
                break;
        }
    }

    private static void pattern1(ArrayList<Enemy> arraylist) {
        int x = 50;
        int y = 300;
        for (int i = 0; i < 40; i++) {
            arraylist.add(new SmallEnemy(x, y));
            x += 100;
            if (x >= 1000) {
                x = 50;
                y += 100;
            }
        }
    }

    private static void pattern2(ArrayList<Enemy> arraylist) {
        int x = 100;
        int y = 250;
        for (int i = 0; i < 40; i++) {
            arraylist.add(new SmallEnemy(x, y));
            x += 100;
            if (x >= 1000) {
                x = 100;
                y += 100;
            }
        }
    }
}
