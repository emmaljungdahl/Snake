package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.nio.charset.Charset;

public class Movement {
    private boolean collision = false;

    private Terminal terminal;

    public Movement() { //add return values

        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

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

            System.out.println(key.getCharacter() + " " + key.getKind());
        }
    }

    public boolean collisionWall() {
        Snake snake = new Snake();
        Point p = snake.getSnakeBody().get(0).point;

        if (p.x > GameMap.WIDTH - 1 || p.x < 1) {
            collision = true;
        } else if (p.y > GameMap.HEIGHT - 1 || p.y < 1) {
            collision = true;
        }
        return collision;
    }

    public boolean collisionBody() {
        Snake snake = new Snake();
        Point head = snake.getSnakeBody().get(0).point;

        for (int i = 0; i < snake.getSnakeBody().size(); i++) {
            if (snake.getSnakeBody().get(i).point == head) {
                collision = true;
            }
        }
        return collision;
    }

    public void collisionApple() {
        Point applePos = Apple.applePos;
        Snake snake = new Snake();
        Point head = snake.getSnakeBody().get(0).point;

        if (applePos == head){
            collision = true;
        }
        if (collision){
            Apple.spawnApple();
            SnakeParts snakePart = new SnakeParts(head.x, head.y);
            snake.addSnakeBody(snakePart);

        }
    }
}

