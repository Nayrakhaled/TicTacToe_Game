package controller;

import controller.Move;
import java.util.Random;


public class AIGame {

    public static int COUNT = 0;
    

    public static Move easyAI(String[][] xoBoard) {
        Move move = new Move();
        for (int i = 0; i < 3 && move.getCol()== -1; i++) {
            for (int j = 0; j < 3 && move.getCol()== -1; j++) {
                if (xoBoard[i][j].equals("a")) {
                    move.setCol(i);
                    move.setRow(j);
                    break;
                }
            }
        }
        return move;
    }

   

}
