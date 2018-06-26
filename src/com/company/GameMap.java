package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class GameMap {
    Terminal terminal;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 100;

    public void createGameMap() {
        terminal = TerminalFacade.createTerminal(System.in, System.out,
                Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        int[] borderVertical = new int[]{0,WIDTH};
        int[] borderHorizontal = new int[]{0,HEIGHT};

        terminal.applyBackgroundColor(Terminal.Color.RED);

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
        terminal.setCursorVisible(false);
    }
}
