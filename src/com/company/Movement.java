package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.Point;

public class Movement  {

    public boolean movement(Terminal terminal, Snake snake) {

        Collision col = new Collision();

        while (true) {

            Key key;
            do {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                key = terminal.readInput();
            } while (key == null);

            Point head = snake.getSnakeBody().get(0).point;

            switch (key.getKind()) {
                case ArrowDown:
                    Point newPos = new Point(head.x, head.y+1);
                    snake.moveSnakeBody(newPos);
                    break;
                case ArrowUp:
                    newPos = new Point(head.x, head.y-1);
                    snake.moveSnakeBody(newPos);
                    break;
                case ArrowRight:
                    newPos = new Point(head.x+1, head.y);
                    snake.moveSnakeBody(newPos);
                    break;
                case ArrowLeft:
                    newPos = new Point(head.x-1, head.y);
                    snake.moveSnakeBody(newPos);
                    break;
            }

            GameMap.updateGameMap(terminal, snake);

            boolean colCheckBody = col.collisionBody(snake);
            boolean colCheckWall = col.collisionWall(snake);

            if (colCheckBody || colCheckWall) {
                return true;
            } else {
                return false;
            }
        }
    }
}

class Collision {
    private boolean collision = false;

    public boolean collisionWall(Snake snake) {
        Point p = snake.getSnakeBody().get(0).point;

        if (p.x > GameMap.WIDTH - 1 || p.x < 1) {
            collision = true;
        } else if (p.y > GameMap.HEIGHT - 1 || p.y < 1) {
            collision = true;
        }
        return collision;
    }

    public boolean collisionBody(Snake snake) {
        Point head = snake.getSnakeBody().get(0).point;

        for (int i = 1; i < snake.getSnakeBody().size(); i++) {
            if (snake.getSnakeBody().get(i).point.x == head.x && snake.getSnakeBody().get(i).point.y == head.y) {
                collision = true;
            }
        }
        return collision;
    }

    public boolean collisionApple(Snake snake) {
        Point head = snake.getSnakeBody().get(0).point;

        if (Apple.applePos.x == head.x && Apple.applePos.y == head.y) {
            Apple.spawnApple();
            return collision = true;
        } else {
            return false;
        }
    }
}


