/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author elshamey
 */
public class Move {
    
    private int col;
    private int row;
    
    public  Move(){
        col = -1;
        row = -1;
    }
    
    public  int getCol(){
        return col;
    }
    public  int getRow(){
        return row;
    }
     public  void setCol(int col){
        this.col = col;
    }
    public  void setRow(int row){
        this.row = row;
    }
    
}
