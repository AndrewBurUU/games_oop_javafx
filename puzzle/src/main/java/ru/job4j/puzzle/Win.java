package ru.job4j.puzzle;

public class Win {
    public static boolean checkHoriz(int[][] table, int row) {
        boolean res = true;
        for (int index = 0; index < table.length; index++) {
            if (table[row][index] != 1) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static boolean checkVert(int[][] table, int cell) {
        boolean res = true;
        for (int index = 0; index < table.length; index++) {
            if (table[index][cell] != 1) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static boolean check(int[][] board) {
        boolean rsl = true;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1) {
                rsl = checkHoriz(board, index) || checkVert(board, index);
                if (rsl) {
                    break;
                }
            }
        }
        return rsl;
    }
}
