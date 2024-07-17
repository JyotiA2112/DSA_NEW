/*
package src.Arrays;


import java.util.*;

class SudokuSolver {

    static boolean sudokuSolve(char[][] board) {
        // your code goes here

        int[] emptyCellLoc = findEmptyCell(board);
        if (emptyCellLoc == null) {
            return true;
        }
        int i = emptyCellLoc[0];
        int j = emptyCellLoc[1];

        for (int guess = 1; guess <= 9; guess++) {
            if (isValid(board, guess, i, j)) {
                board[i][j] = (char) (guess + '0');
                if (sudokuSolve(board)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }

        return false;
    }

    public static int[] findEmptyCell(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static boolean isValid(char[][] board, int guess, int i, int j) {
        for (int num = 0; num < 9; num++) {
            if (board[i][num] != '.' && guess == (board[i][num] - '0')) {
                return false;
            }
        }

        for (int num = 0; num < 9; num++) {
            if (board[num][j] != '.' && guess == (board[num][j] - '0')) {
                return false;
            }
        }

        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;
        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if (board[row][col] != '.' && guess == (board[row][col] - '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {


        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (sudokuSolve(board)) {
            for (char[] row : board) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("No solution exists.");
        }
    }

}


//

import java.io.*;
        import java.util.*;

class Solution {

    static boolean sudokuSolve(char[][] board) {
        // your code goes here

        //traverse the board and for each char, will check if it is valid by checking its vorrspoinding row col and box
        for(int i = 0;i<board.length;i++) {
            for(int j = 0;j<board[0].length;j++) {
                //check this char is valid

                if (board[i][j] != ' ' && !isValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isValid(char[][] board, int i, int j) {
        char c = board[i][j];

        //checking in row
        for (int k = 0;k<board[0].length;k++) {
            if (c == board[i][k] && i != k) return false;
        }

        for (int k = 0;k<board.length;k++) {
            if (c == board[j][k] && j != k) return false;
        }

        //checking in box

        int boxRow = 3 * i/3;
        int boxCol = 3 * j/3;

        for (int x = boxRow;x<boxRow+3;x++) {
            for (int y = boxCol;y<boxCol+3;y++) {
                if (board[x][y] == c && i !=x && j != y) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}


///


[[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."]]

*/
