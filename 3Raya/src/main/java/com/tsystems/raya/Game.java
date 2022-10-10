/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tsystems.raya;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author aalonsoa
 */

/*
_  _  _                   1  2  3
_  _  _    Player 1: X    4  5  6
_  _  _    Player 2: O    7  8  9

 */
public class Game {

    final Board board;

    boolean turn; // 'true' -> First player
    // 'false' -> Second player

    public Game() {
        //Generate the board
        this.board = new Board();
        this.turn = turnDecider(); //Get a random player turn
    }

    /*
        Start the game
     */
    void start() {

        System.out.println("TRES EN RAYA\n");

        while (!askCoords()) {
            System.out.println("Coordinates are not valid");
        }

    }

    /*  turn = false: 1st player
        turn = true: 2st player 
     */
    private boolean askCoords() {
        boolean isValidCoords = false;

        board.printBoard();
        
        System.out.println("\nTurno del " + turnMessage() + " [Elige donde marcar. Ej: 1,2]");

        Scanner input = new Scanner(System.in);
        String coords = input.nextLine();
        String[] parts = coords.split("\\s*,\\s*");

        if (coords.matches("[1-3],[1-3]")) {
            isValidCoords = true;
            int x = Integer.parseInt(parts[0])-1;
            int y = Integer.parseInt(parts[1])-1;
            checkMove(x, y);
        }
        return isValidCoords;

    }

    private void checkMove(int x, int y) {
        char[][] tempBoard = board.getMatrix();

        while (tempBoard[x][y] != '_' && !isBoardFull() && !checkWinner() ) {            
            tempBoard[x][y] = getTurnChar();       
        }      
        
        board.printBoard();

    }
    
    private boolean checkWinner() {
        
        return true;
    }
    
    boolean checkRows() {
        char[][] tempBoard = board.getMatrix();
        
        for(int i = 0; i< tempBoard.length; i++) {            
            if(tempBoard[i][0] == getTurnChar() &&
               tempBoard[i][1] == getTurnChar() &&
               tempBoard[i][3] == getTurnChar()) {
                
                    return true;
            }            
        }
        
        return false;   
    }
    
    boolean checkColumns() {
        char[][] tempBoard = board.getMatrix();
        
        for(int i = 0; i< tempBoard.length; i++) {            
            if(tempBoard[1][i] == getTurnChar() &&
               tempBoard[2][i] == getTurnChar() &&
               tempBoard[3][i] == getTurnChar()) {
                
                    return true;
            }            
        }
        
        return false;   
    }
    
    boolean checkDiagonal() {
        char[][] tempBoard = board.getMatrix();
        
            if(tempBoard[1][1] == getTurnChar() &&
               tempBoard[2][2] == getTurnChar() &&
               tempBoard[3][3] == getTurnChar()) {               
                    return true;                    
            } else if(tempBoard[2][0] == getTurnChar() &&
               tempBoard[1][1] == getTurnChar() &&
               tempBoard[0][2] == getTurnChar()) {
                return true;
            }
        
        return false;   
    }

    /*
        Change player turn from one to another
     */
    private void changeTurn() {
        this.turn = !this.turn;
    }

    /*
        Change player turn from one to another
     */
    private String turnMessage() {
        if (this.turn) {
            return "Jugador 1";
        }

        return "Jugador 2";
    }
    
    /*
        Get turn Char
     */
    private char getTurnChar() {
        if (this.turn) {
            return 'X';
        }
        return 'O';
    }

    /*
        Randomize the boolean that decides the turn
     */
    private boolean turnDecider() {
        Random r = new Random();
        return r.nextBoolean();
    }

    /*
        Check if board is full or if it stills has spots left
     */
    private boolean isBoardFull() {
        char[][] tempBoard = board.getMatrix();

        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (tempBoard[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

}
