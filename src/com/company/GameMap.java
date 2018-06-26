package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;
import java.awt.Point;
import java.nio.charset.Charset;

public class GameMap {
    private static Terminal terminal;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 50;
    private static Snake snake = new Snake();

    public static void createGameMap() {
        terminal = TerminalFacade.createTerminal(System.in, System.out,
                Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        int[] borderVertical = new int[]{0,WIDTH};
        int[] borderHorizontal = new int[]{0,HEIGHT};

        terminal.applyBackgroundColor(Terminal.Color.CYAN);

        for(int v : borderVertical){
            for (int i = 0; i < HEIGHT; i++) {
                terminal.moveCursor(v, i);
                terminal.putCharacter(' ');
            }
        }
        for(int h : borderHorizontal){
            for (int i = 0; i < WIDTH; i++) {
                terminal.moveCursor(i, h);
                terminal.putCharacter(' ');
            }
        }
        drawSnake(snake.startSnake());
        terminal.setCursorVisible(false);
    }
    public static void updateGameMap() {
        terminal.clearScreen();
        createGameMap();
        drawSnake(snake.getSnakeBody());
    }

    public static void drawSnake(List<SnakeParts>snakeList) {
        for (int i = 0; i < snakeList.size(); i++) {
            Point point = snakeList.get(i).point;
            terminal.moveCursor(point.x, point.y);
            terminal.applyBackgroundColor(Terminal.Color.GREEN);
            terminal.putCharacter(' ');
        }
    }

    public static void printMessage (int x, int y, String message) {
        for (int i = 0; i < message.length(); i++) {
            terminal.applyBackgroundColor(Terminal.Color.CYAN);
            terminal.applyForegroundColor(Terminal.Color.BLACK);
            terminal.moveCursor(x, y);
            terminal.putCharacter(message.charAt(i));
            x++;
        }
    }
}