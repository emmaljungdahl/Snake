package com.company;

import java.awt.Point;
import java.util.Random;

public class Apple {
    public static Point applePos;

    public static Point spawnApple() {
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        applePos = new Point(x, y);
        return applePos;
    }
}