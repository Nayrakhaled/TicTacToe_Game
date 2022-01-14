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
    
     public static Move normalAI(String[][] xoGameBoard) {
        Move move = new Move();

        if (COUNT < 4) {
            do {
                int random = new Random().nextInt(8);
                switch (random) {
                    case 0:
                        move.setCol(0);
                        move.setRow(0);
                        break;
                    case 1:
                        move.setCol(0);
                        move.setRow(1);
                        break;
                    case 2:
                        move.setCol(0);
                        move.setRow(2);
                        break;
                    case 3:
                        move.setCol(1);
                        move.setRow(0);
                        break;
                    case 4:
                        move.setCol(1);
                        move.setRow(1);
                        break;
                    case 5:
                        move.setCol(1);
                        move.setRow(2);
                        break;
                    case 6:
                        move.setCol(2);
                        move.setRow(0);
                        break;
                    case 7:
                        move.setCol(2);
                        move.setRow(1);
                        break;
                    case 8:
                        move.setCol(2);
                        move.setRow(2);
                        break;
                }

            } while (!xoGameBoard[move.getCol()][move.getRow()].equals("a") && COUNT < 4);
            
            COUNT++;
        }
       
        return move;
    }
    
    

   

}
