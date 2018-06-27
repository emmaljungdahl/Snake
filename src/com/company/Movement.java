package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.Point;

public class Movement {

    private boolean keyUp = false;
    private boolean keyDown = false;
    private boolean keyRight = false;
    private boolean keyLeft = false;
    private boolean collision = false;

    public boolean movement(Terminal terminal, Snake snake) {

        do {
            Key input = keyPress(terminal);
            direction(input);

            collision = moveOnKey(terminal, snake);
        }while (!collision);

            return collision;
        }


        private boolean moveOnKey (Terminal terminal, Snake snake){
            boolean collision = false;
            Point head = snake.getSnakeBody().get(0).point;
            Point newPos;

            while (!collision) {
                if (keyUp) {
                    boolean canMove = counter();
                    if (canMove) {
                        newPos = new Point(head.x, (head.y -= 1));
                        collision = snake.moveSnakeBody(newPos, snake);
                        GameMap.updateGameMap(terminal, snake);
                    }
                } else if (keyDown) {
                    boolean canMove = counter();
                    if (canMove) {
                        newPos = new Point(head.x, (head.y += 1));
                        collision = snake.moveSnakeBody(newPos, snake);
                        GameMap.updateGameMap(terminal, snake);
                    }
                } else if (keyRight) {
                    boolean canMove = counter();
                    if (canMove) {
                        newPos = new Point((head.x += 1), head.y);
                        collision = snake.moveSnakeBody(newPos, snake);
                        GameMap.updateGameMap(terminal, snake);
                    }
                } else if (keyLeft) {
                    boolean canMove = counter();
                    if (canMove) {
                        newPos = new Point((head.x -= 1), head.y);
                        collision = snake.moveSnakeBody(newPos, snake);
                        GameMap.updateGameMap(terminal, snake);
                    }
                }
            }

            return collision;
        }


        private Key keyPress (Terminal terminal){
            Key key;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return key = terminal.readInput();
        }

        private void direction (Key key){

            if (key != null) {
                switch (key.getKind()) {
                    case ArrowDown:
                        keyUp = false;
                        keyDown = true;
                        keyRight = false;
                        keyLeft = false;
                    case ArrowUp:
                        keyUp = true;
                        keyDown = false;
                        keyRight = false;
                        keyLeft = false;
                        break;
                    case ArrowRight:
                        keyUp = false;
                        keyDown = false;
                        keyRight = true;
                        keyLeft = false;
                        break;
                    case ArrowLeft:
                        keyUp = false;
                        keyDown = false;
                        keyRight = false;
                        keyLeft = true;
                        break;
                }
            }
        }

        private boolean counter () {
            boolean canMove = false;
            int counter = 0;
            for (int i = 0; i <= 30; i++) {
                counter++;
                if (counter == 30) {
                    canMove = true;
                }
            }
            return canMove;
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