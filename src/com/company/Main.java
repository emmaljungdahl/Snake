package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;


public class Main {

    public static void main(String[] args) {

        boolean gameOver = false;

        Movement move = new Movement();
        Snake snake = new Snake();

        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        GameMap.createGameMap(terminal);
        GameMap.drawSnake(terminal, snake.startSnake());
        GameMap.drawApple(terminal, Apple.spawnApple());
        GameMap.printMessage(terminal, GameMap.WIDTH - 35, GameMap.HEIGHT / 2, "-START SNAKE-");

        while (!gameOver) {
            gameOver = move.snakeMovementLoop(terminal, snake);
        }
        GameMap.printMessage(terminal, GameMap.WIDTH - 35, GameMap.HEIGHT / 2, "-GAME OVER-");
    }
}