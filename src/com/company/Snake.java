package com.company;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Snake> snakeBody;

    public Snake() {
        snakeBody = new ArrayList<>();
    }

    public void addSnakeBody (Snake snake) {
        snakeBody.add(snake);
    }

    public List<Snake> getSnakeBody() {
        return snakeBody;
    }
}
