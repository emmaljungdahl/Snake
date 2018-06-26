package com.company;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<SnakeParts> snakeBody;

    public Snake() {
        snakeBody = new ArrayList<>();
    }

    public void startSnake() {
        for (int i = 0; i < 4; i++) {
            SnakeParts snakePart = new SnakeParts(50, (25 + i));
            addSnakeBody(snakePart);
        }
    }

    public void addSnakeBody(SnakeParts snake) {
        snakeBody.add(snake);
    }

    public List<SnakeParts> getSnakeBody() {
        return snakeBody;
    }
}

class SnakeParts {
    public Point point;
    public SnakeParts(int x, int y) {
        this.point.x = x;
        this.point.y = y;
    }
}
