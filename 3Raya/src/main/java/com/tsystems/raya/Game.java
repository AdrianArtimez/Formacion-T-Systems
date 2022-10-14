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

/* Structure
    _  _  _                  1  2  3
    _  _  _    Player 1: X   4  5  6
    _  _  _    Player 2: O   7  8  9

 */

public class Game {

    final Board board;
    int PLAYING = 1, FINISHED = 0;
    int GAME_STATE;
    String[] players = new String[2];

    boolean turn; // 'true' -> First player
    // 'false' -> Second player

    public Game() {
        //Generate the board
        this.board = new Board();
        this.turn = randomTurnDecider(); //Get a random player turn
    }

    /*
        Start the game and loop it while GAME_STATE is not finished.
     */
    void start() {
        GAME_STATE = PLAYING;
        System.out.println("\n- TIC TAC TOE -\n");
        getPlayersNames();
        
        while (GAME_STATE != FINISHED) {
            System.out.println("\n- TIC TAC TOE -\n");
            board.printBoard();
            askCoords();
        }
        
        board.printBoard();
        System.out.println("\nGAME IS FINISHED");
    }

    /*  turn = false: 1st player
        turn = true: 2st player 
     */
    private void askCoords() {
        boolean goodCoords = false;
        String userCoords = "";
        
        while (!goodCoords) {
            System.out.println("\n ! " + getCurrentPlayerName() + "'s turn [Use this format: 1,2]");

            Scanner input = new Scanner(System.in);
            userCoords = input.nextLine();
            if (checkCoordsFormat(userCoords)) {
                goodCoords = true;
            }
        }

        String[] parts = userCoords.split("\\s*,\\s*");

        int x = Integer.parseInt(parts[0]) - 1;
        int y = Integer.parseInt(parts[1]) - 1;

        checkMove(x, y);

    }
    
    /*
        Check if the input of the coords. is well formatted.
    */
    private boolean checkCoordsFormat(String coords)
    {
        if (coords.matches("[1-3],[1-3]"))
            return true;
               
        System.out.println("\n ! The coordinates weren't correct. [Use this format: 1,2]");
        return false;
    }

    /*
        
    */
    
    private void checkMove(int x, int y)
    {
        char[][] tempBoard = board.getMatrix();

        if (tempBoard[x][y] == '_') {
            tempBoard[x][y] = getCurrentTurnChar();

            if (checkWinner()) {
                System.out.println("\n! Player " + getCurrentPlayerName() + " won the game!");
                GAME_STATE = 0;
            }

            if (isBoardFull()) {
                System.out.println("\n! The game ended in a draw.");
                GAME_STATE = 0;
            }
            
            changePlayerTurn();

        } else {
            System.out.println("\n ! These coords. are already marked.");
        }

    }

    /*-
        Check if there is a winner checking the lines
     */
    private boolean checkWinner() {

        if (checkRows() || checkColumns() || checkDiagonal()) {
            return true;
        }

        return false;
    }

    boolean checkRows() {
        char[][] tempBoard = board.getMatrix();

        for (int i = 0; i < tempBoard.length; i++) {

            if (tempBoard[i][0] == tempBoard[i][1]
                    && tempBoard[i][1] == tempBoard[i][2] && tempBoard[i][2] != '_') {
                return true;
            }
        }
        return false;
    }

    boolean checkColumns() {
        char[][] tempBoard = board.getMatrix();

        for (int i = 0; i < tempBoard.length; i++) {
            if (tempBoard[0][i] == getCurrentTurnChar()
                    && tempBoard[1][i] == getCurrentTurnChar()
                    && tempBoard[2][i] == getCurrentTurnChar()) {

                return true;
            }
        }
        return false;
    }

    boolean checkDiagonal() {
        char[][] tempBoard = board.getMatrix();

        if (tempBoard[0][0] == getCurrentTurnChar()
                && tempBoard[1][1] == getCurrentTurnChar()
                && tempBoard[2][2] == getCurrentTurnChar()) {
            return true;
        } else if (tempBoard[2][0] == getCurrentTurnChar()
                && tempBoard[1][1] == getCurrentTurnChar()
                && tempBoard[0][2] == getCurrentTurnChar()) {
            return true;
        }
        return false;
    }

    /*
        Change player turn from one to another
     */
    private void changePlayerTurn() {
        this.turn = !this.turn;
    }

    /*
        Change player turn from one to another
     */
    private String getCurrentPlayerName() 
    {
        if (this.turn) {
            return players[0];
        }

        return players[1];
    }

    /*
        Get turn Char
     */
    private char getCurrentTurnChar() 
    {
        if (this.turn) {
            return 'X';
        }
        return 'O';
    }

    /*
        Randomize the boolean that decides the turn
     */
    private boolean randomTurnDecider() 
    {
        Random r = new Random();
        return r.nextBoolean();
    }

    /*
        Check if board is full or if it stills has spots left
     */
    private boolean isBoardFull() 
    {
        char[][] tempBoard = board.getMatrix();

        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < tempBoard[0].length; j++) {
                if (tempBoard[i][j] == '_') {
                    return false;
                }
            }
        }        
        return true;
    }
    
    /*
        Get players name
    */
    private void getPlayersNames() {
        Scanner input = new Scanner(System.in);
        System.out.println("! Enter first player name: ");
        players[0] = input.nextLine();
        System.out.println("! Enter second player name: ");
        players[1] = input.nextLine();
    }
}
