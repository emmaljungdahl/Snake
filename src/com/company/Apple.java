package com.company;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
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

boolean collision = false;

public boolean collisionWall(){
    Snake snake = new Snake();
    snake.getSnakePos();
    Point p = snake.getSnakeBody().get(0);

    for (Snake s : snake.getSnakePos()) {
        if()
    }
}

public boolean collisionBody(){
    Snake snake = new Snake();
    snake.getSnakeBody();

    for ()

}

public boolean collisionApple(){
    Apple apple = new Apple();
    applePos.getX();
    applePos.getY();
}