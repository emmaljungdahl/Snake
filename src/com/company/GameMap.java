package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;
import java.awt.Point;
import java.nio.charset.Charset;

public class GameMap {
    private static Terminal terminal;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    public static Snake snake = new Snake();

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
        drawSnake(snake.getSnakeBody());
        terminal.setCursorVisible(false);
    }
    public static void updateGameMap(List<SnakeParts>snakeList) {
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

    public static void printMessage (Point point, String message) {
        for (int i = 0; i < message.length(); i++) {
            terminal.moveCursor(point.x, point.y);
            terminal.putCharacter(message.charAt(i));
            point.x++;
        }
    }
}


//mvoement add new snake på index[0] och ta bort sista index. om den ska växa låter man
// den sista vara. listName.size()-1 (ger sista indexet)