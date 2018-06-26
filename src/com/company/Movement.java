package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Movement {

HEAD

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
            }  while (key == null);

            System.out.println(key.getCharacter() + " " + key.getKind());
        }
    }

bd34b69c5e90b6dacc5bed54e7010549137f6938
}
