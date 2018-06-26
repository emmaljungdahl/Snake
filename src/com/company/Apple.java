package com.company;

import java.awt.Point;
import java.util.Random;

public class Apple {
    public Point applePos;

    public Point spawnApple() {
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        applePos = new Point(x, y);
        return applePos;
    }
}

