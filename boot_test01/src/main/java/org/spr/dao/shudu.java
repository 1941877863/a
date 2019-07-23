package org.spr.dao;

import java.util.*;

public class shudu {

    public static void main(String[] args) {
        char[][] board = {
                {'1', '.', '.', '.', '3', '2', '.', '.', '7'},
                {'.', '.', '.', '.', '.', '.', '3', '.', '.'},
                {'3', '.', '4', '.', '.', '5', '.', '.', '.'},
                {'.', '.', '9', '.', '.', '.', '.', '1', '4'},
                {'5', '.', '.', '4', '.', '7','.', '.', '8'},
                {'6', '4', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '9', '.', '.', '4', '.', '3'},
                {'.', '.', '7', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '3', '5', '.', '.', '.', '1'}
        };
        shudu a = new shudu();
        a.solveSudoku(board);
        for (int i =0;i < board.length;i++){
            System.out.println(board[i]);
        }
    }

    public void solveSudoku(char[][] board) {
        if(null == board || null == board[0]){
            return;
        }
        solve(board);
    }
    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length ; i ++){
            for(int j = 0 ; j < board[0].length ; j++){
                if('.' == board[i][j]){
                    for(char k = '1'; k <= '9'; k ++){
                        if(isValid(board,i,j,k)){
                            board[i][j] = k;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board,int row,int col,int val){
        for(int i = 0; i < board.length;i++){
            if(i != col && (char) val == board[row][i] ){
                return false;
            }
            if(i != row && (char) val == board[i][col] ){
                return false;
            }
            int celRow = (row / 3) * 3 + i / 3;
            int celClo = (col / 3) * 3 + i % 3;
            if(celRow != row && celClo != col && (char) val == board[celRow][celClo] ){
                return false;
            }
        }
        return true;
    }


    }
