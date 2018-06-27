package com.company;

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

    public void moveSnakeBody (Point newPos) {
        SnakeParts snakePart = new SnakeParts(newPos.x, newPos.y);
        snakeBody.add(0, snakePart);
        snakeBody.remove(snakeBody.size()-1);
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
