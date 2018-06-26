package com.company;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedExeption {

        Terminal terminal = TerminalFacade.createTerminal(System.in,
                            System.out, Charset.forName("UTF8"));

        terminal.enterPrivateMode();

        while(true) {

            Key key;
            do{
                Thread.sleep(5 );
                key =terminal.readInput();
            }
            while(key == null);

            System.out.println(key.getCharacter()+ " " + key.getKind());
        }

    }

}
