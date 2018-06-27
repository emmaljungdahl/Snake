package com.company;

import com.googlecode.lanterna.terminal.Terminal;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<SnakeParts> snakeBody;

    public Snake() {
        snakeBody = new ArrayList<>();
    }

    public List<SnakeParts> startSnake() {
        for (int i = 0; i < 4; i++) {
            SnakeParts snakePart = new SnakeParts(GameMap.WIDTH / 2, (GameMap.HEIGHT / 2 - i));
            addSnakeBody(snakePart);
        }
        return snakeBody;
    }

    public void addSnakeBody(SnakeParts snake) {
        snakeBody.add(0, snake);
    }

    public boolean moveSnakeBody (Point newPos, Snake snake) {
        SnakeParts snakePart = new SnakeParts(newPos.x, newPos.y);
        snakeBody.add(0, snakePart);
        Collision col = new Collision();

        boolean appleCol = col.collisionApple(this);
        if (!appleCol) {
            snakeBody.remove(snakeBody.size() - 1);
        }
        boolean colCheckBody = col.collisionBody(snake);
        boolean colCheckWall = col.collisionWall(snake);

        if (colCheckBody || colCheckWall) {
            return true;
        } else {
            return false;
        }
    }

    public List<SnakeParts> getSnakeBody() {
        return snakeBody;
    }
}

class SnakeParts {
    public Point point;
    public SnakeParts(int x, int y) {
        this.point = new Point(x,y);
    }
}
