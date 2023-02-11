package model;

public class Board {
    String[][] board;

    public Board(int N) {
        board = new String[N][N];

        for(String[] arr : board) {
            for(int i=0; i<N; i++) {
                arr[i] = "_";
            }
        }
    }

    public void printBoard() {
        for(String[] arr : board) {
            for(int i=0; i<board.length; i++) {
                System.out.println(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public void setPosition(int x, int y, String symbol) {
        board[x][y] = symbol;
    }

    public String getPosition(int x, int y) {
        return board[x][y];
    }

    public String[][] getBoard() {
        return board;
    }
}
