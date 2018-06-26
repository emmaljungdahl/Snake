package com.company;

public class Main {

    public static void main(String[] args) {
        GameMap map = new GameMap();

        //Graphics for start of the game.
        map.createGameMap();
        map.printMessage(44, 13, "-START SNAKE-");

//        map.updateGameMap();
    }

}
