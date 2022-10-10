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
    Populamos el tablero
    */
    private void populateBoard() {
        for(int i = 0; i<this.getBoardSize(); i++) {
            for(int j = 0; j<this.getBoardSize(); j++) {
                this.board[i][j] =  '_';
            }
        }
    }
    
    /*
    Imprimimos el tablero en la forma en la que se encuentre actualmente
    */
    protected void printBoard() {
        for(int i = 0; i<this.getBoardSize(); i++) {
            for(int j = 0; j<this.getBoardSize(); j++) {
                System.out.print(board[i][j] + " ");
            }
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
