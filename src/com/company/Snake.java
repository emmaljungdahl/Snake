package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Snake> snakeBody;
    private Point snakePos;

    public Snake() {
        snakeBody = new ArrayList<>();
    }

    public void addSnakeBody (Snake snake) {
        snakeBody.add(snake);
    }

    public List<Snake> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakePosition(Point point) {
        // needs a loop of snakeBody for setting snakePos = point;
    }

    public List<Snake> getSnakePos() {
        //loop to give the whole snake body's position
        return null;
    }
}
