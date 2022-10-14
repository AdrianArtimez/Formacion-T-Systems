/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tsystems.raya;

/**
 *
 * @author aalonsoa
 */
public final class Board {
    
    protected char[][] board;

    public Board() {
        this.board = new char[3][3];      
        this.populateBoard();
    }
    
    /*
        Populate an empty board with '_' (3x3)
    */
    private void populateBoard() {
        for(int i = 0; i<this.getBoardSize(); i++) {
            for(int j = 0; j<this.getBoardSize(); j++) {
                this.board[i][j] =  '_';
            }
        }
    }
    
    /*
        Print the board the way it is at the moment.
    */
    
    protected void printBoard() {
        for(int i = 0; i<this.getBoardSize(); i++) {
            for(int j = 0; j<this.getBoardSize(); j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    protected char[][] getMatrix() {
        return board;
    }
    
    int getBoardSize() {
        return this.board.length;
    }
   
}
